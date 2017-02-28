package com.softgroup.db.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 * Author: vadym
 * Date: 28.02.17
 * Time: 17:24
 */
public class HibernateUtil {

        private static final SessionFactory sessionFactory;

        static{
            try{
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

            }catch (Throwable ex) {
                System.err.println("Session Factory could not be created." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

}
