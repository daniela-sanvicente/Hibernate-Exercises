package mx.unam.tic.diplomado.agenda;

import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ContactService;
import mx.unam.tic.diplomado.agenda.servicios.PhoneTypeService;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.PhoneTypeServiceImpl;

import java.util.List;

public class PhoneTypeAPP {

	public static void main(String[] args) {
		HibernateUtil.init();
		
		PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
		ContactService contactService = ContactServiceImpl.getInstance();

		System.out.println("Carga Tipos Telefonos");
		List<PhoneType> listPhoneType = phoneTypeService.getAllPhoneTypes();
		for (PhoneType phone : listPhoneType)
			System.out.println(phone.toString());

		System.out.println("Carga Tipos Telefonos por Id");
		PhoneType phoneType = phoneTypeService.getPhoneTypeById(1);
		System.out.println(phoneType.toString());
		
		List<MeansContacts> contactosMedio = contactService.getPhoneTypes(phoneType);
		
		if (contactosMedio != null && ! contactosMedio.isEmpty()) {
			System.out.println("Los números de medio de contacto:" + phoneType.getName());
			for (MeansContacts meansContacts : contactosMedio) {
				System.out.println("El número es:" 
						+ meansContacts.getValue()
						+ " y el nombre del contacto es:" + meansContacts.getContact().getName());
			}
		}
	}
}
