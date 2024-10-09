package com.campusdual.classroom;

import java.util.*;

public class Exercise26{

    public static void main(String[] args) {

        Boolean salirGeneral = false;
        Phonebook mapPhone = new Phonebook();
        Contact contact;

        int opcion;
        Scanner sn = new Scanner(System.in);

        while (!salirGeneral){
            // Contact c = new Contact("Julián", "Ramiro Sánchez", "+34630977519");

            System.out.println("Seleccione la opción deseada en la gestión de contactos:");
            System.out.println("1 - Añadir un contacto al listín telefónico");
            System.out.println("2 - Mostrar los contactos del listín telefónico");
            System.out.println("3 - Seleccionar un contacto y mostrar su menú de acciones");
            System.out.println("4 - Eliminar un contacto");
            System.out.println("9 - Salir del programa");

            try{

                opcion = sn.nextInt();

                switch (opcion){
                    case 1:
                        contact = createNewContact();
                        System.out.println("\r\r");
                        mapPhone.addContact(contact);
                        break;
                    case 2:
                        showContacts(mapPhone.getData());
                        break;
                    case 3:
                        showContacts(mapPhone.getData());
                        System.out.println("\r\r");
                        selectContact(mapPhone.getData());
                        break;
                    case 4:
                        showContacts(mapPhone.getData());
                        System.out.println("\r\r");
                        deleteContact(mapPhone.getData());
                        break;
                    case 9:
                        salirGeneral=true;
                        break;
                    default:
                        System.out.println("Las opciones válidas son entre 1, 2, 3 y 9.");

                }
            }
            catch(InputMismatchException e){
                System.out.println("Debes seleccionar un número de opción válida.");
                sn.next();
            }


        }
    }
    private static void showContacts(Map<String, Contact> mapPhoneBook){
        int contador=1;
        for (Map.Entry<String, Contact> entry : mapPhoneBook.entrySet()){
            System.out.println(contador
                    + " | " +  entry.getValue().getCode()
                    + " | " +  entry.getValue().getName()
                    + " | " +  entry.getValue().getPhone()
                    + " | " +  entry.getValue().getSurnames());
            contador++;
        }
    }

    private static void selectContact(Map<String, Contact> mapPhoneBook){
        Scanner sn = new Scanner(System.in);
        int contador = 1;
        int selectedContact;

        System.out.println("Indique el número de contacto para utilizar: ");
        try {

            selectedContact = sn.nextInt();

            for (Map.Entry<String, Contact> entry : mapPhoneBook.entrySet()){
                if (contador == selectedContact){
                    callMenuContactos(entry.getValue());
                }else {
                    contador++;
                }
            }


        } catch (InputMismatchException e) {

            System.out.println("Debes indicar el número de contacto.");
            sn.next();

        }

        System.out.println("\r\r\r\r");

    }

    private static Map<String, Contact> deleteContact(Map<String, Contact> mapPhoneBook ){
        Scanner sn = new Scanner(System.in);

        int contador = 1;
        int selectedContact;

        System.out.println("Indique el número de contacto para eliminar: ");
        try {

            System.out.println("Seleccione el contacto: ");
            selectedContact = sn.nextInt();

            for (Map.Entry<String, Contact> entry : mapPhoneBook.entrySet()){
                if (contador == selectedContact){
                    mapPhoneBook.remove(entry.getKey());
                }else {
                    contador++;
                }
            }

        } catch (InputMismatchException e) {

            System.out.println("Debes indicar el número de contacto.");
            sn.next();

        }

        System.out.println("\r\r\r\r");
        return mapPhoneBook;
    }

    private static  Contact createNewContact(){
        // Variables locales para rellenar el contacto
        Scanner sn = new Scanner(System.in);

        Contact contact = new Contact();

        String strName;
        String strSurname;
        String strPhone;


        System.out.println("Indique los datos de contacto para almacenar: ");

        try {
            System.out.println("Indique el nombre del contacto: ");
            strName = sn.nextLine();

            System.out.println("Indique el apellido del contacto: ");
            strSurname = sn.nextLine();

            System.out.println("Indique el teléfono del contacto: ");
            strPhone = sn.nextLine();

            contact = new Contact(strName, strSurname, strPhone);

        } catch (InputMismatchException e) {
            System.out.println("Debes indicar los datos correctos.");
            sn.nextLine();
        }
        System.out.println(" \n \n \n \n ");

        return contact;

    }
    private static void callMenuContactos(Contact contacto){
        // Variables locales del método
        Boolean salirContacto = false;

        int opcion;
        Scanner sn = new Scanner(System.in);

        // Este el menú de opciones de contacto
        while (!salirContacto) {

            System.out.println("\r\r\r\r");

            System.out.println("Seleccione el número de la opción deseada: ");
            System.out.println("1 - Llamar a mi propio número ");
            System.out.println("2 - Llamar a otro número ");
            System.out.println("3 - Mostrar los detalles del contacto ");
            System.out.println("9 - volver al menú de contactos ");

            try {

                System.out.println("Seleccione la opcion deseada: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        contacto.callMyNumber();
                        break;
                    case 2:
                        contacto.callMyNumber();
                        break;
                    case 3:
                        contacto.showContactDetails();
                        break;
                    case 9:
                        System.out.println("Opción 9 seleccionada salir");
                        salirContacto = true;
                        break;
                    default:
                        System.out.println("Las opciones válidas son entre 1, 2, 3 y 9.");

                }
            } catch (InputMismatchException e) {
                System.out.println("Debes seleccionar un número de opción válida.");
                sn.next();
            }
        }

        System.out.println("\r\r\r\r");

    }
}
