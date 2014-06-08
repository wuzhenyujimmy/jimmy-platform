package com.jimmy.base.db;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Query;

import com.jimmy.base.page.Page;

public interface BaseDao<T> {
    /**
     * get hibernate Query Object
     * 
     * @param hql
     *            hql
     * @return Query Object
     */
    Query getQuery(String hql);

    /**
     * get connection object by jdbc
     * 
     * @param dbUrl
     *            db's url
     * @param username
     *            username used to login db
     * @param password
     *            password used to login db
     * @return
     */
    Connection getJDBCConnection();

    /**
     * add entity
     * 
     * @param entity
     */
    void add(T entity);

    /**
     * delete entity according to id
     * 
     * @param id
     *            entity's id
     */
    void delete(String id);

    /**
     * update entity
     * 
     * @param entity
     *            the entity to update
     */
    void update(T entity);

    /**
     * Add or update entity
     * 
     * @param entity
     *            the entity to add or update
     */
    void addOrUpdate(T entity);

    /**
     * get all the entities according to hql
     * 
     * @param queryString
     *            the query string
     * @return all the entities queried
     */
    List<T> findAll(String queryString);

    /**
     * get the entity according to entity's id
     * 
     * @param id
     *            实体id
     * @return the entity founded
     */
    T getEntity(String id);

    /**
     * Get entites by a group of entity id
     * 
     * @param ids
     *            entities ids
     * @return entites
     */
    List<T> getEntities(String... ids);

    /**
     * get all the entities
     * 
     * @return all entities
     */
    List<T> getAll();

    /**
     * query and show them by pagination
     * 
     * @param page
     *            the object to store the query result
     * @return the result queried
     */
    Page<T> getPagingResult(Page<T> page);

    /**
     * query and show them by pagination
     * 
     * @param page
     *            the object to store the query result
     * @param whereSql
     *            the hql started from where but no where included
     * @return the result queried
     */
    Page<T> getPagingResult(Page<T> page, String whereSql);

    /**
     * query and show them by pagination
     * 
     * @param paget
     *            the object to store the query result
     * @param whereSql
     *            the hql started from where but no where included
     * @param orderby
     *            order by
     * @return the result queried
     */
    Page<T> getPagingResult(Page<T> page, String whereSql, LinkedHashMap<String, String> orderby);

    /**
     * query and show them by pagination
     * 
     * @param page
     *            the object to store the query result
     * @param whereSql
     *            the hql started from where but no where included
     * @param queryParams
     *            the parameters in hql
     * @return the result queried
     */
    Page<T> getPagingResult(Page<T> page, String whereSql, Object[] queryParams);

    /**
     * query and show them by pagination
     * 
     * @param page
     *            the object to store the query result
     * @param orderby
     *            order by
     * @return the result queried
     */
    Page<T> getPagingResult(Page<T> page, LinkedHashMap<String, String> orderby);

    /**
     * query and show them by pagination
     * 
     * @param page
     *            the object to store the query result
     * @param whereSql
     *            the hql started from where but no where included
     * @param queryParams
     *            the parameters in hql
     * @param orderby
     *            order by
     * @return the result queried
     */
    Page<T> getPagingResult(Page<T> page, String whereSql, Object[] queryParams, LinkedHashMap<String, String> orderby);

}
