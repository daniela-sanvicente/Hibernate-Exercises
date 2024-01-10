package mx.unam.tic.diplomado.agenda.modelo.dao;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contact;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;

import java.util.List;

public interface ContactDAO {

	Contact getContactById(Integer id);

	List<Contact> getAllContacts();

	Boolean insertContact(Contact contact);

	Boolean updateContact(Contact contact);

	Boolean deleteContact(Contact contact);
	
	List<MeansContacts> getPhoneTypes(PhoneType phoneType);
}
