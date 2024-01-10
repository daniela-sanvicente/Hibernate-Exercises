package mx.unam.tic.diplomado.agenda.modelo.dao.impl;

import mx.unam.tic.diplomado.agenda.modelo.dao.ContactDAO;
import mx.unam.tic.diplomado.agenda.modelo.dao.ContactTypeDAO;
import mx.unam.tic.diplomado.agenda.modelo.entidades.Contact;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactType;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
	private static ContactDAOImpl instance;

	private ContactDAOImpl() {
	}

	public static ContactDAOImpl getInstance() {
		if (instance == null)
			instance = new ContactDAOImpl();
		return instance;
	}

	@Override
	public Contact getContactById(Integer id) {
		Contact contact = null;
		//completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			contact = session.get(Contact.class, id);
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
	public List<Contact> getAllContacts() {
		List<Contact> contactList = null;
		//completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//listPhoneType = session.createQuery("SELECT t FROM PhoneType t WHERE t.estatus = 'ACTIVO' ").list();
			contactList = session.createQuery("SELECT t FROM Contact t WHERE t.status = 'ACTIVO' ", Contact.class).getResultList();
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

	@Override
	public Boolean insertContact(Contact contact) {
		Boolean save = Boolean.FALSE;
		//Completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.persist(contact);
			save = contact.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
	public Boolean updateContact(Contact contact) {
		Boolean update = Boolean.FALSE;
		//Completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.merge(contact);
			update = contact.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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
	public Boolean deleteContact(Contact contact) {
		Boolean delete = Boolean.FALSE;
		//Completar código
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			session.remove(contact);
			delete = contact.getId() != null ? Boolean.TRUE : Boolean.FALSE;
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

	@Override
	public List<MeansContacts> getPhoneTypes(PhoneType phoneType) {
		List<MeansContacts> meansContactsList = null;
		//completar
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			// se inicia una transaccion
			session.beginTransaction();
			//listPhoneType = session.createQuery("SELECT t FROM PhoneType t WHERE t.estatus = 'ACTIVO' ").list();
			meansContactsList = session.createQuery("SELECT cm FROM MeansContacts cm WHERE cm.phoneType.id =:idMedioContacto",
					MeansContacts.class).setParameter("idMedioContacto", phoneType.getId()).getResultList();
			// se realiza el commit
			session.getTransaction().commit();
			// se cierra la session hibernate
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(HibernateUtil.getRegistry());
		}
		return meansContactsList;
	}
}
