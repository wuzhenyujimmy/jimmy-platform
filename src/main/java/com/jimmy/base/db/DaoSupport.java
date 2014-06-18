package com.jimmy.base.db;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jimmy.base.common.BaseEntity;
import com.jimmy.base.page.Page;
import com.jimmy.util.CalenderUtils;
import com.jimmy.util.PropertyUtil;

public class DaoSupport<T extends BaseEntity> implements BaseDao<T> {

    protected @Autowired HibernateTemplate hibernateTemplate;

    protected Class<T> entityClass = getEntityClass();
    protected String entityClassName = entityClass.getSimpleName();

    @SuppressWarnings("unchecked")
    protected Class<T> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) type).getActualTypeArguments();
            return (Class<T>) params[0];
        }
        return null;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Query getQuery(String hql) {
        return hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(hql);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Connection getJDBCConnection() {
        final String url = PropertyUtil.getProperty("hibernate/jdbc.properties", "jdbc.url");
        final String username = PropertyUtil.getProperty("hibernate/jdbc.properties", "jdbc.username");
        final String password = PropertyUtil.getProperty("hibernate/jdbc.properties", "jdbc.password");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(T entity) {
        entity.setCreateDate(CalenderUtils.getNowString());
        hibernateTemplate.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        hibernateTemplate.delete(hibernateTemplate.get(entityClass, id));
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(T entity) {
        entity.setUpdateDate(CalenderUtils.getNowString());
        hibernateTemplate.saveOrUpdate(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdate(T entity) {
        if (null == entity.getCreateDate()) {
            add(entity);
        } else {
            update(entity);
        }
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<T> findAll(String queryString) {
        return hibernateTemplate.find(queryString);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<T> getAll() {
        String queryString = "from " + entityClassName;
        List<T> list = hibernateTemplate.find(queryString);
        return list.size() == 0 ? null : list;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public T getEntity(String id) {
        return hibernateTemplate.get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getEntities(String... ids) {

        String whereSql = "from o where o.id in (？)";
        Query query = getQuery(whereSql);
        for (int i = 0; i < ids.length; i++) {
            query.setParameter(i + 1, ids[i]);
        }
        return query.list();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<T> getPagingResult(Page<T> page) {
        return getPagingResult(page, null, null, null);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<T> getPagingResult(Page<T> page, String whereSql) {
        return getPagingResult(page, whereSql, null, null);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<T> getPagingResult(Page<T> page, String whereSql, LinkedHashMap<String, String> orderby) {
        return getPagingResult(page, whereSql, null, orderby);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<T> getPagingResult(Page<T> page, String whereSql, Object[] queryParams) {
        return getPagingResult(page, whereSql, queryParams, null);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<T> getPagingResult(Page<T> page, LinkedHashMap<String, String> orderby) {
        return getPagingResult(page, null, null, orderby);
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<T> getPagingResult(Page<T> page, String whereSql, Object[] queryParams,
                    LinkedHashMap<String, String> orderby) {
        // 查询实体记录
        String hql = "select o from " + entityClassName + " o "
                        + (whereSql == null || "".equals(whereSql.trim()) ? "" : "where " + whereSql)
                        + buildOrderby(orderby);
        Query query = getQuery(hql);
        if (queryParams != null && queryParams.length > 0) {
            setQueryParams(query, queryParams);
        }
        query.setFirstResult(page.getFirstRecordQueryFrom()).setMaxResults(page.getRecordCountInPage());
        List<T> list = query.list();
        page.setEntities(list);

        // 获得总记录数
        hql = "select count(o) from " + entityClassName + " o "
                        + (whereSql == null || "".equals(whereSql.trim()) ? "" : "where " + whereSql)
                        + buildOrderby(orderby);
        query = getQuery(hql);
        if (queryParams != null && queryParams.length > 0) {
            setQueryParams(query, queryParams);
        }
        page.setTotalRecordCount(((Integer.valueOf(query.iterate().next().toString()).intValue())));
        return page;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    protected static void setQueryParams(Query query, Object[] queryParams) {
        if (queryParams != null && queryParams.length > 0) {
            for (int i = 0; i < queryParams.length; i++) {
                query.setParameter(i + 1, queryParams[i]);
                // query.setParameter(i + 1, queryParams[i]);
            }
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    protected static String buildOrderby(LinkedHashMap<String, String> orderby) {
        StringBuffer orderbySql = new StringBuffer("");
        if (orderby != null && orderby.size() > 0) {
            orderbySql.append(" order by ");
            for (String key : orderby.keySet()) {
                orderbySql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
            }
            orderbySql.deleteCharAt(orderbySql.length() - 1);
        }
        return orderbySql.toString();
    }

}
