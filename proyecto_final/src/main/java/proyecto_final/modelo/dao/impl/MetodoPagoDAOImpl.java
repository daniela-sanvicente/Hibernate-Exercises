package proyecto_final.modelo.dao.impl;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import proyecto_final.entity.MetodoPago;
import proyecto_final.modelo.dao.MetodoPagoDAO;
import proyecto_final.modelo.hibernate.HibernateUtil;

import java.util.List;

public class MetodoPagoDAOImpl implements MetodoPagoDAO {
    private static MetodoPagoDAOImpl instance;

    private MetodoPagoDAOImpl() {
    }

    public static MetodoPagoDAOImpl getInstance() {
        if (instance == null) {
            instance = new MetodoPagoDAOImpl();
        }
        return instance;
    }

    @Override
    public MetodoPago getMetodoPagoById(Integer id) {
        MetodoPago contact = null;
        try {
            assert HibernateUtil.getSessionFactory() != null; //verifica que sessionFactory(lo que se usa para interactuar con la base de datos) existe 
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            contact = session.get(MetodoPago.class, id);
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
    public List<MetodoPago> getAllMetodoPagos() {
        List<MetodoPago> contactList = null;
        try {
            assert HibernateUtil.getSessionFactory() != null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //catalogo = session.createQuery("FROM MetodoPago").list();
            contactList = session.createQuery("FROM MetodoPago", MetodoPago.class).getResultList();
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

    public Boolean insertMetodoPago(MetodoPago metodoPago) {
        Boolean save = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.persist(metodoPago);
			save = metodoPago.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return save;
    }

	public Boolean updateMetodoPago(MetodoPago metodoPago) {
        Boolean update = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.merge(metodoPago);
			update = metodoPago.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return update;
    }

	public Boolean deleteMetodoPago(MetodoPago metodoPago) {
        Boolean delete = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(metodoPago);
			delete = metodoPago.getId() != null ? Boolean.TRUE : Boolean.FALSE;
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return delete;
    }
}
