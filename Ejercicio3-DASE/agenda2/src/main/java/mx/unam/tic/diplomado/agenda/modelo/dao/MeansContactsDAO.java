package mx.unam.tic.diplomado.agenda.modelo.dao;

import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;

import java.util.List;

public interface MeansContactsDAO {
	MeansContacts getMeansContactsById(Integer id);

	List<MeansContacts> getAllMeansContacts();

	Boolean insertMeansContacts(MeansContacts contact);

	Boolean updateMeansContacts(MeansContacts contact);

	Boolean deleteMeansContacts(MeansContacts contact);

	List<MeansContacts> getMeansContactsByContact(Integer id);
}
