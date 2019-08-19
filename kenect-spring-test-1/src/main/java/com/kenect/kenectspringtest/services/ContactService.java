package com.kenect.kenectspringtest.services;

import com.kenect.kenectspringtest.domain.Contact;
import com.kenect.kenectspringtest.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {


    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List getAllContacts() {
        List contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);
        return contacts;
    }


    public Contact getContact (Integer id) {
        return contactRepository.findById(id).orElseGet(Contact::new);
    }

    public void addContact (Contact contact) {
        contact.getEmails().stream().forEach(e -> e.setContact(contact));
        contact.getAddresses().stream().forEach(e -> e.setContact(contact));
        contact.getPhones().stream().forEach(e -> e.setContact(contact));
        contactRepository.save(contact);
    }

    public void updateContact(Integer id, Contact contact) {
        contact.setId(id);
        contactRepository.save(contact);
    }

    public void deleteContact (Integer id) {
        contactRepository.deleteById(id);
    }

}
