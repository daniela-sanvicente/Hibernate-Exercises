package mx.unam.tic.diplomado.agenda;

import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactType;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ContactService;
import mx.unam.tic.diplomado.agenda.servicios.ContactTypeService;
import mx.unam.tic.diplomado.agenda.servicios.PhoneTypeService;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactTypeServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.PhoneTypeServiceImpl;

import java.util.List;

public class ContactTypeAPP {

	public static void main(String[] args) {
		HibernateUtil.init();
		
		ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();

		List<ContactType> listContactType = contactTypeService.getAllContactType();
		for (ContactType contactType : listContactType)
			System.out.println(contactType.toString());
	}
}
