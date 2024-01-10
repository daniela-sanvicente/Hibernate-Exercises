package mx.unam.tic.diplomado.agenda;

import mx.unam.tic.diplomado.agenda.modelo.entidades.MeansContacts;
import mx.unam.tic.diplomado.agenda.modelo.entidades.ContactType;
import mx.unam.tic.diplomado.agenda.modelo.entidades.Contact;
import mx.unam.tic.diplomado.agenda.modelo.entidades.PhoneType;
import mx.unam.tic.diplomado.agenda.modelo.hibernate.HibernateUtil;
import mx.unam.tic.diplomado.agenda.servicios.MeansContactsService;
import mx.unam.tic.diplomado.agenda.servicios.ContactService;
import mx.unam.tic.diplomado.agenda.servicios.PhoneTypeService;
import mx.unam.tic.diplomado.agenda.servicios.ContactTypeService;
import mx.unam.tic.diplomado.agenda.servicios.impl.MeansContactsServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.PhoneTypeServiceImpl;
import mx.unam.tic.diplomado.agenda.servicios.impl.ContactTypeServiceImpl;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AgendaAPP {
    private Scanner sn;
    private final PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
    private final ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
    private final ContactService contactService = ContactServiceImpl.getInstance();
    private final MeansContactsService meansContactsService = MeansContactsServiceImpl.getInstance();

    public static void main(String[] args) {
        HibernateUtil.init();
        AgendaAPP catalogosAPP = new AgendaAPP();
        catalogosAPP.cargaMenu();
    }

    public void cargaMenu() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Catalogos");
            System.out.println("2. Contactos");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú catalogos --");
                        cargaMenuCatalogos();
                        //PhoneType
                        //ContactType
                        break;
                    case 2:
                        System.out.println("-- Entrando Contactos --");
                        cargarMenuCatalogoContatos();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }


    public void cargaMenuCatalogos() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Phone Type");
            System.out.println("2. Contact Type");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Phone Type --");
                        cargaMenuPhoneType();
                        break;
                    case 2:
                        System.out.println("-- Entrando Contact Type --");
                        cargaMenuContactType();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuPhoneType() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        PhoneTypeService phoneTypeService = PhoneTypeServiceImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        PhoneType phoneType = null;
        do {
            System.out.println("1. Select All");
            System.out.println("2. Select By Id");
            System.out.println("3. Insert");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Select All --");
                        List<PhoneType> listPhoneType = phoneTypeService.getAllPhoneTypes();
                        for (PhoneType phone : listPhoneType)
                            System.out.println(phone.toString());
                        break;
                    case 2:
                        System.out.println("-- Entrando Select By Id --");
                        System.out.println("Dame id a buscar: ");
                        valor = scanner.nextInt();
                        phoneType = phoneTypeService.getPhoneTypeById(valor);
                        System.out.println(phoneType.toString());
                        break;
                    case 3:
                        System.out.println("-- Entrando Insert --");
                        PhoneType phoneTypeObj = new PhoneType();
                        System.out.println("Dame Nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Dame Estatus:");
                        String estatus = scanner.nextLine();
                        phoneTypeObj.setName(nombre);
                        phoneTypeObj.setStatus(estatus);
                        System.out.println(phoneTypeService.insertPhoneType(phoneTypeObj));
                        break;
                    case 4:
                        System.out.println("-- Entrando Update --");
                        System.out.println("Dame id a buscar: ");
                        valor = scanner.nextInt();
                        phoneType = phoneTypeService.getPhoneTypeById(valor);
                        scanner.nextLine();
                        System.out.println("Dame Nombre: ");
                        String nombre2 = scanner.nextLine();
                        System.out.println("Dame Estatus:");
                        String estatus2 = scanner.nextLine();
                        phoneType.setName(nombre2);
                        phoneType.setStatus(estatus2);
                        System.out.println(phoneTypeService.updatePhoneType(phoneType));
                        break;
                    case 5:
                        System.out.println("-- Entrando Delete --");
                        System.out.println("Dame id a eliminar: ");
                        valor = scanner.nextInt();
                        phoneType = phoneTypeService.getPhoneTypeById(valor);
                        System.out.println(phoneTypeService.deletePhoneType(phoneType));
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuContactType() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        ContactTypeService contactTypeService = ContactTypeServiceImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        ContactType contactType = null;
        do {
            System.out.println("1. Select All");
            System.out.println("2. Select By Id");
            System.out.println("3. Insert");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Select All --");
                        List<ContactType> listcontactType = contactTypeService.getAllContactType();
                        for (ContactType phone : listcontactType)
                            System.out.println(phone.toString());
                        break;
                    case 2:
                        System.out.println("-- Entrando Select By Id --");
                        System.out.println("Dame id a buscar: ");
                        valor = scanner.nextInt();
                        contactType = contactTypeService.getContactTypeById(valor);
                        System.out.println(contactType.toString());
                        break;
                    case 3:
                        System.out.println("-- Entrando Insert --");
                        ContactType contactTypeObj = new ContactType();
                        System.out.println("Ingrese un tipo de contacto: ");
                        String nombre = scanner.nextLine();
                        System.out.println("Ingrese su estatus:");
                        String estatus = scanner.nextLine();
                        contactTypeObj.setName(nombre);
                        contactTypeObj.setStatus(estatus);
                        System.out.println(contactTypeService.insertContactType(contactTypeObj));
                        break;
                    case 4:
                        System.out.println("-- Entrando Update --");
                        System.out.println("Dame id a buscar: ");
                        valor = scanner.nextInt();
                        contactType = contactTypeService.getContactTypeById(valor);
                        scanner.nextLine();
                        System.out.println("Dame Nombre: ");
                        String nombre2 = scanner.nextLine();
                        System.out.println("Dame Estatus:");
                        String estatus2 = scanner.nextLine();
                        contactType.setName(nombre2);
                        contactType.setStatus(estatus2);
                        System.out.println(contactTypeService.updateContactType(contactType));
                        break;
                    case 5:
                        System.out.println("-- Entrando Delete --");
                        System.out.println("Dame id a eliminar: ");
                        valor = scanner.nextInt();
                        contactType = contactTypeService.getContactTypeById(valor);
                        System.out.println(contactTypeService.deleteContactType(contactType));
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargarMenuCatalogoContatos() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Contact");
            System.out.println("2. MeansContacts");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Contact --");
                        cargaMenuContact();
                        break;
                    case 2:
                        System.out.println("-- Entrando MeansContacts --");
                        cargaMenuMeansContacts();
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuContact() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        ContactService contactService = ContactServiceImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        Contact contact = null;
        do {
            System.out.println("1. Select All");
            System.out.println("2. Select By Id");
            System.out.println("3. Insert");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza

                Scanner snNumeros = new Scanner(System.in);

                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Select All --");
                        List<Contact> listContact = contactService.getAllContacts();
                        for (Contact cont : listContact)
                            System.out.println(cont.toString());
                        break;
                    case 2:
                        System.out.println("-- Entrando Select By Id --");
                        System.out.println("Dame id a buscar: ");
                        valor = scanner.nextInt();
                        contact = contactService.getContactById(valor);
                        System.out.println(contact.toString());
                        break;
                    case 3:
                        System.out.println("-- Entrando Insert --");
                        Contact contactObj = new Contact();

                        System.out.println("Dame Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.println("Dame Apellido: ");
                        String apellido = scanner.nextLine();

                        System.out.println("Dame Edad:");
                        int edad = snNumeros.nextInt();

                        System.out.println("Dame ID del tipo de contacto:");
                        int id = snNumeros.nextInt();
                        ContactType ct= new ContactType();
                        ct.setId(id);
                        contactObj.setContactType(ct);

                        System.out.println("Dame Dirección:");
                        String direccion = scanner.nextLine();

                        contactObj.setName(nombre);
                        contactObj.setLastName(apellido);
                        contactObj.setAge(edad);
                        contactObj.setAddress(direccion);

                        System.out.println(contactService.insertContact(contactObj));
                        break;
                    case 4:
                        System.out.println("-- Entrando Update --");
                        System.out.println("Dame id a buscar: ");
                        Contact contactObj2 = new Contact();
                        valor = snNumeros.nextInt();
                        contact = contactService.getContactById(valor);

                        System.out.println("Dame Nombre: ");
                        String nombre2 = scanner.nextLine();

                        System.out.println("Dame Apellido: ");
                        String apellido2 = scanner.nextLine();

                        System.out.println("Dame Edad:");
                        int edad2 = snNumeros.nextInt();

                        System.out.println("Dame Dirección:");
                        String direccion2 = scanner.nextLine();

                        contactObj2.setName(nombre2);
                        contactObj2.setLastName(apellido2);
                        contactObj2.setAge(edad2);
                        contactObj2.setAddress(direccion2);
                        contact.setName(nombre2);
                        contact.setLastName(apellido2);
                        contact.setAge(edad2);
                        contact.setAddress(direccion2);

                        System.out.println(contactService.updateContact(contact));
                        break;
                    case 5:
                        System.out.println("-- Entrando Delete --");
                        System.out.println("Dame id a eliminar: ");
                        valor = scanner.nextInt();
                        contact = contactService.getContactById(valor);
                        System.out.println(contactService.deleteContact(contact));
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }

    public void cargaMenuMeansContacts() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        MeansContactsService meansContactsService = MeansContactsServiceImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        int valor = 0;
        MeansContacts meansContacts = null;
        do {
            System.out.println("1. Select All");
            System.out.println("2. Select By Id");
            System.out.println("3. Insert");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();//limpieza
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Select All --");
                        List<MeansContacts> listMeansContacts = meansContactsService.getAllMeansContacts();
                        for (MeansContacts meanContact : listMeansContacts)
                            System.out.println(meanContact.toString());
                        break;
                    case 2:
                        System.out.println("-- Entrando Select By Id --");
                        System.out.println("Dame id a buscar: ");
                        valor = scanner.nextInt();
                        meansContacts = meansContactsService.getMeansContactsById(valor);
                        System.out.println(meansContacts.toString());
                        break;
                    case 3:
                        System.out.println("-- Entrando Insert --");
                        MeansContacts meansContactsObj = new MeansContacts();
                        System.out.println("Dame valor: ");
                        String valor2 = scanner.nextLine();
                        System.out.println("Dame ID del contacto:");
                        int ctId = scanner.nextInt();
                        System.out.println("Dame ID del tipo de teléfono:");
                        int tfId = scanner.nextInt();
                        scanner.nextLine();
                        Contact ct =new Contact();
                        PhoneType tf = new PhoneType();
                        ct.setId(ctId);
                        tf.setId(tfId);
                        meansContactsObj.setValue(valor2);
                        meansContactsObj.setContact(ct);
                        meansContactsObj.setPhoneType(tf);
                        System.out.println(meansContactsService.insertMeansContacts(meansContactsObj));
                        break;
                    case 4:
                        System.out.println("-- Entrando Update --");
                        System.out.println("Dame id a buscar: ");
                        MeansContacts meansContactsObj2 = new MeansContacts();
                        int id = scanner.nextInt();
                        meansContacts = meansContactsService.getMeansContactsById(id);
                        scanner.nextLine();
                        System.out.println("Dame Valor: ");
                        String valor3 = scanner.nextLine();
                        meansContactsObj2.setValue(valor3);
                        meansContacts.setValue(valor3);
                        System.out.println(meansContactsService.updateMeansContacts(meansContacts));
                        break;
                    case 5:
                        System.out.println("-- Entrando Delete --");
                        System.out.println("Dame id a eliminar: ");
                        valor = scanner.nextInt();
                        meansContacts = meansContactsService.getMeansContactsById(valor);
                        System.out.println(meansContactsService.deleteMeansContacts(meansContacts));
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no existe");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
        while (!salir);
    }
}
