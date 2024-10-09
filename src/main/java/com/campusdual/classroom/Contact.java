package com.campusdual.classroom;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.NormalizedString;

import java.text.Normalizer;

public class Contact implements ICallActions{

    private String contactPhone;
    private String contactName;
    private String contactSurname;
    private String contactID;

    public  Contact (){}

    public  Contact (String name, String surname, String phone){


        String[] arrSurname = surname.toLowerCase().split(" ");
        this.contactName = name;
        this.contactSurname = surname;
        this.contactPhone = phone;

        // Creamos el código de contacto
        this.contactID = name.toLowerCase().substring(0,1);

        if (arrSurname.length > 1){
            this.contactID += arrSurname[0].substring(0,1);
            for (int i = 1; i < (arrSurname.length); i++) {
                this.contactID += arrSurname[i];
            }

        }else
        {
            this.contactID += surname.toLowerCase();
        }

        this.contactID = Normalizer.normalize(this.contactID, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

    }
    public Contact getContact(){
        return this;
    }
    public void setName(String name) {
        this.contactName = name;
    }

    public String getName(){
        return this.contactName;
    }

    public void setPhone(String phone) {
        this.contactPhone = phone;
    }

    public String getPhone(){
        return this.contactPhone;
    }
    public void setSurnames(String surname) {
        this.contactSurname = surname;
    }

    public String getSurnames(){
        return this.contactSurname;
    }

    public String getCode(){
        return this.contactID;
    }

    @Override
    public void callMyNumber() {
        System.out.println("Hola " + this.getName() + " " + this.getSurnames() + " te estás llamando a tí mismo desde tú teléfono: " + this.getPhone());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println("Llamando a  " + this.getName() + " " + this.getSurnames() + " con teléfono: " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("\n\n\n\n");
        System.out.println("Datos del contacto");
        System.out.println("==================");
        System.out.println("contacID: " +  this.contactID);
        System.out.println("contactName: " +  this.contactName);
        System.out.println("contactSurname: " +  this.contactSurname);
        System.out.println("contactPhone: " +  this.contactPhone);
        System.out.println("\n\n\n\n");
    }
}
