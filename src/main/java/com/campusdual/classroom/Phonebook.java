package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook{

    private static Map<String, Contact> mapContacts = new HashMap<>();

    // Método para agregar contacto al phoneBook
    public void addContact(Contact newContact){
        mapContacts.put(newContact.getCode(), newContact);
    }

    public static Map<String, Contact> getData(){
        return mapContacts;
    }

    // Método para mostrar la información del registro del phoneBook
    public void showPhonebook(){
        for (Map.Entry<String, Contact> entry : mapContacts.entrySet()){
            entry.getValue().showContactDetails();
        }
    }

    // Método para eliminar un contacto del phoneBook
    public void deleteContact(String key){
        mapContacts.remove(key);
    }

    public Contact selectContact(String key){
        return mapContacts.get(key);
    }

}
