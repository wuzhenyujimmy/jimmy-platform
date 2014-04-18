package com.jimmy.base;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateAutoCreate {

    public static void main(String[] args) {
        Configuration hibernateConfig = new Configuration();

        hibernateConfig.configure("hibernate.cfg.xml");

        SchemaExport dbExport = new SchemaExport(hibernateConfig);

        dbExport.create(true, true);
    }
}
