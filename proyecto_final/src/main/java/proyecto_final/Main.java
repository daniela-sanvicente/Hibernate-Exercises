package proyecto_final;

import proyecto_final.entity.MetodoPago;
import proyecto_final.entity.Pago;
import proyecto_final.modelo.hibernate.HibernateUtil;
import proyecto_final.servicios.MetodoPagoService;
import proyecto_final.servicios.PagoService;
import proyecto_final.servicios.impl.MetodoPagoServiceImpl;
import proyecto_final.servicios.impl.PagoServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final PagoService pagoService = PagoServiceImpl.getInstance();
    private static final MetodoPagoService metodoPagoService = MetodoPagoServiceImpl.getInstance();
    
    private static Scanner sn = new Scanner(System.in);
    private static Scanner scanner = new Scanner(System.in);
    private static Scanner snNumeros = new Scanner(System.in);

    public static void main(String[] args) {
        HibernateUtil.init();
        cargaMenu();
    }

    public static void cargaMenu() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Pago");
            System.out.println("2. MetodoPago");
            System.out.println("3. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú Pagos --");
                        cargaMenuPagos();
                        break;
                    case 2:
                        System.out.println("-- Entrando menú Metodo de Pago --");
                        cargaMenuMetodoPagos();
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
        while (!salir) ;
    }

    public static void cargaMenuPagos() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Ver por ID");
            System.out.println("2. Ver todos");
            System.out.println("3. Insertar");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Salir");

            try {
                sn = new Scanner(System.in);
                
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver por ID --");
                        consultaPagoPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos --");
                        consultaPagos();
                        break;
                    case 3:
                        System.out.println("-- Entrando Insertar --");
                        insertaPago();
                        break;
                    case 4:
                        System.out.println("-- Entrando Update --");
                        actualizaPago();
                        break;
                    case 5:
                        System.out.println("-- Entrando Delete --");
                        borraPago();
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
    
    public static void cargaMenuMetodoPagos() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Ver por ID");
            System.out.println("2. Ver todos");
            System.out.println("3. Insertar");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Salir");

            try {
                sn = new Scanner(System.in);
                
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver por ID --");
                        consultaMetodoPagoPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos --");
                        consultaMetodoPagos();
                        break;
                    case 3:
                        System.out.println("-- Entrando Insertar --");
                        insertaMetodoPago();
                        break;
                    case 4:
                        System.out.println("-- Entrando Update --");
                        actualizaMetodoPago();
                        break;
                    case 5:
                        System.out.println("-- Entrando Delete --");
                        borraMetodoPago();
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

    /* PAGOS */

    public static void consultaPagos() {
        for (Pago pago : pagoService.getAllPagos()) {
            System.out.println("Pago:" + pago.toString());
        }
    }

    public static void consultaPagoPorId() {
        System.out.println("Dame el id a buscar:");
        
        int busca = snNumeros.nextInt();
        
        Pago pago = pagoService.getPagoById(busca);
        
        if (pago != null)
            System.out.println("Pago:" + pago.toString());
        else
            System.out.println("Pago no encontrado");
    }

    public static void insertaPago() {
        Pago pagoObj = new Pago();

        System.out.println("Dame emisor: ");
        String emisor = scanner.nextLine();
                
        System.out.println("Dame numero de la cuenta: ");
        String numeroCuenta = scanner.nextLine();

        System.out.println("Dame la fecha de expiracion: ");
        String fechaExpiracion = scanner.nextLine();

        System.out.println("Dame CVV:");
        String cvv = scanner.nextLine();

        pagoObj.setEmisor(emisor);
        pagoObj.setNumeroCuenta(numeroCuenta);
        pagoObj.setFechaExpiracion(fechaExpiracion);
        pagoObj.setCvv(cvv);

        System.out.println("Dame ID del metodo de pago:");
        int id = snNumeros.nextInt();
        
        MetodoPago metodoPago = new MetodoPago();
        metodoPago.setId(id);
        pagoObj.setMetodoPago(metodoPago);

        System.out.println(pagoService.insertPago(pagoObj));
    }

    public static void actualizaPago() {
        System.out.println("Dame id a buscar: ");
        int valor = snNumeros.nextInt();
        Pago pago = pagoService.getPagoById(valor);

        System.out.println("Dame emisor: ");
        String emisor = scanner.nextLine();
                
        System.out.println("Dame numero de la cuenta: ");
        String numeroCuenta = scanner.nextLine();

        System.out.println("Dame la fecha de expiracion: ");
        String fechaExpiracion = scanner.nextLine();

        System.out.println("Dame CVV:");
        String cvv = scanner.nextLine();

        pago.setEmisor(emisor);
        pago.setNumeroCuenta(numeroCuenta);
        pago.setFechaExpiracion(fechaExpiracion);
        pago.setCvv(cvv);

        System.out.println(pagoService.updatePago(pago));
    }

    public static void borraPago() {
        System.out.println("Dame id a eliminar: ");

        int id = snNumeros.nextInt();
        
        Pago pago = pagoService.getPagoById(id);
        
        System.out.println(pagoService.deletePago(pago));
    }

    /* MÉTODO DE PAGO */

    public static void consultaMetodoPagos() {
        for (MetodoPago metodoPago : metodoPagoService.getAllMetodoPagos()) {
            System.out.println("MetodoPago:" + metodoPago.toString());
        }
    }

    public static void consultaMetodoPagoPorId() {
        System.out.println("Dame el id a buscar:");
        
        int busca = snNumeros.nextInt();
        
        MetodoPago metodoPago = metodoPagoService.getMetodoPagoById(busca);
        
        if (metodoPago != null)
            System.out.println("MetodoPago:" + metodoPago.toString());
        else
            System.out.println("MetodoPago no encontrado");
    }

    public static void insertaMetodoPago() {
        MetodoPago metodoPagoObj = new MetodoPago();

        System.out.println("Dame nombre del metodo de pago: ");
        String metodo = scanner.nextLine();

        metodoPagoObj.setMetodo(metodo);
    
        System.out.println(metodoPagoService.insertMetodoPago(metodoPagoObj));
    }

    public static void actualizaMetodoPago() {
        System.out.println("Dame id a buscar: ");
        int valor = snNumeros.nextInt();
        MetodoPago metodoPago = metodoPagoService.getMetodoPagoById(valor);

        System.out.println("Dame nombre del metodo de pago: ");
        String metodo = scanner.nextLine();

        metodoPago.setMetodo(metodo);
        System.out.println(metodoPagoService.updateMetodoPago(metodoPago));
    }

    public static void borraMetodoPago() {
        System.out.println("Dame id a eliminar: ");

        int id = snNumeros.nextInt();
        
        MetodoPago metodoPago = metodoPagoService.getMetodoPagoById(id);
        
        System.out.println(metodoPagoService.deleteMetodoPago(metodoPago));
    }
}
