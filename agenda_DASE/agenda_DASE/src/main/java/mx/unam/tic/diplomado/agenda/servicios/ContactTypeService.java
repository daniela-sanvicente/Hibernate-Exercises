package mx.unam.tic.diplomado.agenda.servicios;

import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactType;

import java.util.List;

public interface ContactTypeService {
	ContactType getContactTypeById(Integer id);

	List<ContactType> getAllContactType();

	Boolean insertContactType(ContactType contactType);

	Boolean updateContactType(ContactType contactType);

	Boolean deleteContactType(ContactType contactType);
}
