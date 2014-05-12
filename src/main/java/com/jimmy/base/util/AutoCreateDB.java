package com.jimmy.base.util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class AutoCreateDB {

    public static void main(String[] args) {
        Configuration cfg = new AnnotationConfiguration().configure("hibernate/hibernate.cfg.xml");

        SchemaExport export = new SchemaExport(cfg);

        export.create(true, true);
    }
}
