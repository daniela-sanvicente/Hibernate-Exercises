package proyecto_final.modelo.dao.impl;

import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import proyecto_final.entity.Pago;
import proyecto_final.modelo.dao.PagoDAO;
import proyecto_final.modelo.hibernate.HibernateUtil;

import java.util.List;

public class PagoDAOImpl implements PagoDAO {
    private static PagoDAOImpl instance;

    private PagoDAOImpl() {
    }

    public static PagoDAOImpl getInstance() {
        if (instance == null) {
            instance = new PagoDAOImpl();
        }
        return instance;
    }

    @Override
    public Pago getPagoById(Integer id) {
        Pago contact = null;
        try {
            assert HibernateUtil.getSessionFactory() != null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            contact = session.get(Pago.class, id);
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
    public List<Pago> getAllPagos() {
        List<Pago> contactList = null;
        try {
            assert HibernateUtil.getSessionFactory() != null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            // se inicia una transaccion
            session.beginTransaction();
            //catalogo = session.createQuery("FROM Pago").list();
            contactList = session.createQuery("FROM Pago", Pago.class).getResultList();
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

    public Boolean insertPago(Pago pago) {
        Boolean save = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.persist(pago);
			save = pago.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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

	public Boolean updatePago(Pago pago) {
        Boolean update = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.merge(pago);
			update = pago.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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

	public Boolean deletePago(Pago pago) {
        Boolean delete = Boolean.FALSE;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(pago);
			delete = pago.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
