package org.mapeo2;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mapeo2.entity.Tabla;
import org.mapeo2.modelo.hibernate.HibernateUtil;
import org.mapeo2.servicios.TablaService;
import org.mapeo2.servicios.impl.TablaServiceImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private final static TablaService tablaService = TablaServiceImpl.getInstance();
    private static Scanner sn = new Scanner(System.in);


    public static void main(String[] args) {
        HibernateUtil.init();
        cargaMenu();
    }

    public static void cargaMenu() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. mapeo2");
            System.out.println("2. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando menú --");
                        cargaMenuMapeo();
                        break;
                    case 2:
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

    public static void cargaMenuMapeo() {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        do {
            System.out.println("1. Ver por ID");
            System.out.println("2. Ver todos");
            System.out.println("3. Salir");
            try {
                sn = new Scanner(System.in);
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                sn.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("-- Entrando Ver por ID --");
                        consultaTablaPorId();
                        break;
                    case 2:
                        System.out.println("-- Entrando Ver Todos --");
                        consultaTablas();
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
    public static void consultaTablas() {
        for (Tabla tabla : tablaService.getAllTablas()) {
            System.out.println("Tablao:" + tabla.toString());
        }
    }

    public static void consultaTablaPorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dame el id a buscar:");
        int busca = scanner.nextInt();
        Tabla tabla = tablaService.getTablaById(busca);
        if (tabla != null)
            System.out.println("Tabla:" + tabla.toString());
        else
            System.out.println("Tabla no encontrada");
    }

}
