package mx.unam.tic.diplomado.agenda;

import mx.unam.tic.diplomado.agenda.modelo.entidades.Contact;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactType;
import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.ContactService;
import mx.unam.tic.diplomado.agenda.servicios.PhoneTypeService;
import mx.unam.tic.diplomado.agenda.servicios.ContactTypeService;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.PhoneTypeServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactTypeServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agenda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateUtil.init();
		
		ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
		PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
		ContactService contactService = ContactServiceImpl.getInstance();
		
		List<ContactType> tiposContacto = contactTypeService.getAllContactType();
		for (ContactType contactType : tiposContacto) {
			System.out.println("El tipo contacto es:" + contactType.getName());
		}
		ContactType familiar = contactTypeService.getContactTypeById(1);
		System.out.println("El contacto familiar===" + familiar);
		List<PhoneType> mediosContacto = phoneTypeService.getAllPhoneTypes();
		for (PhoneType phoneType : mediosContacto) {
			System.out.println("El medio contacto es:" + phoneType.getName());
		}
		PhoneType casa = phoneTypeService.getPhoneTypeById(1);
		System.out.println("El medio casa===" + casa);

		/*Contact papa = new Contact();//creacion de contacto
		papa.setName("Panchito");
		papa.setLastName("Perez");
		papa.setAddress("Calle de la Muerte");
		papa.setAge(40);		//lenado de datos de contacto
		ContactType laboral = contactTypeService.getContactTypeById(3); //obtencion de catalogo tipo contacto
		papa.setContactType(laboral); //relacionamos contacto con tipo contacto
		
		PhoneType celular = phoneTypeService.getPhoneTypeById(3); //obtencion de catalogo de medio contacto
		MeansContacts contactoMedio = new MeansContacts(); //creacion de contacto medio
		contactoMedio.setValue("0445513264578"); //llenado de datos de contacto medio
		contactoMedio.setPhoneType(celular); //relacionamos contacto medio con catalogo medio contacto
		contactoMedio.setContact(papa); // relacionamos con contacto
		Set<MeansContacts> contactosMedios = new HashSet<>(); //generamos la coleccion
		contactosMedios.add(contactoMedio); //llenamos la coleccion
		papa.setMeansContacts(contactosMedios); //asignamos la coleccion al contacto

		contactService.insertContact(papa); //guardamos al contacto*/

		/*List<Contact> contactos = contactService.getAllContacts();
		for (Contact contacto : contactos) {
			System.out.println("El contacto es:" + contacto.getName());
			System.out.println("El tipo contacto es:" + contacto.getContactType().getName());
			for(MeansContacts m : contacto.getMeansContacts()) {
				System.out.println("m" + m.getValue());
			}
		}*/
	}

}
