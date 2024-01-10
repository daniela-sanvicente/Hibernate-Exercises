package org.mapeo2.modelo.dao.impl;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mapeo2.entity.Tabla;
import org.mapeo2.modelo.dao.TablaDAO;
import org.mapeo2.modelo.hibernate.HibernateUtil;

import java.util.List;

public class TablaDAOImpl implements TablaDAO {
    private static TablaDAOImpl instance;

    private TablaDAOImpl() {
    }

    public static TablaDAOImpl getInstance() {
        if (instance == null) {
            instance = new TablaDAOImpl();
        }
        return instance;
    }

    @Override
    public Tabla getTablaById(Integer id) {
        Tabla contact = null;
        try {
            assert HibernateUtil.getSessionFactory() != null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            contact = session.get(Tabla.class, id);
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return contact;
    }

    @Override
    public List<Tabla> getAllTablas() {
        List<Tabla> contactList = null;
        try {
            assert HibernateUtil.getSessionFactory() != null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //catalogo = session.createQuery("FROM Tabla").list();
            contactList = session.createQuery("FROM Tabla", Tabla.class).getResultList();
            // se realiza el commit
            session.getTransaction().commit();
            // se cierra la session hibernate
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
        }
        return contactList;
    }


}
