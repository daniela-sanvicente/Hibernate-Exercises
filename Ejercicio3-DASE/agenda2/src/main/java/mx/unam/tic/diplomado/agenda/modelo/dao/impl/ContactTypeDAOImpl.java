package mx.unam.tic.diplomado.agenda.modelo.dao.impl;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactTypeDAO;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactType;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ContactTypeDAOImpl implements ContactTypeDAO {

	private static ContactTypeDAOImpl instance;

	private ContactTypeDAOImpl() {
	}

	public static ContactTypeDAOImpl getInstance() {
		if (instance == null)
			instance = new ContactTypeDAOImpl();
		return instance;
	}

	@Override
	public ContactType getContactTypeById(Integer id) {
		ContactType contactType = null;
		//completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			contactType = session.get(ContactType.class, id);
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return contactType;
	}

	@Override
	public List<ContactType> getAllContactType() {
		List<ContactType> contactTypeList = null;
		//completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//listPhoneType = session.createQuery("SELECT t FROM PhoneType t WHERE t.estatus = 'ACTIVO' ").list();
			contactTypeList = session.createQuery("SELECT t FROM ContactType t WHERE t.status = 'ACTIVO' ", ContactType.class).getResultList();
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return contactTypeList;
	}

	@Override
	public Boolean insertContactType(ContactType contactType) {
		Boolean save = Boolean.FALSE;
		//Completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.persist(contactType);
			save = contactType.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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

	@Override
	public Boolean updateContactType(ContactType contactType) {
		Boolean update = Boolean.FALSE;
		//Completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.merge(contactType);
			update = contactType.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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

	@Override
	public Boolean deleteContactType(ContactType contactType) {
		Boolean delete = Boolean.FALSE;
		//Completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(contactType);
			delete = contactType.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
