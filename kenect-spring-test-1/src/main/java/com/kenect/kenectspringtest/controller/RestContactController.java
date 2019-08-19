package com.kenect.kenectspringtest.controller;


import com.kenect.kenectspringtest.domain.Contact;
import com.kenect.kenectspringtest.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestContactController {
    private ContactService contactService;

    public RestContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @GetMapping("/contacts")
    public List<Contact> getAllContacts () {
        return contactService.getAllContacts();
    }

    @GetMapping("/contacts/{id}")
    public Contact getContact(@PathVariable Integer id) {
        return contactService.getContact(id);
    }

    @PostMapping("/contacts/add")
    public void addContact (@RequestBody Contact contact) {
        contactService.addContact(contact);
    }

    @PutMapping("/contacts/{id}")
    public void updateContact (@PathVariable Integer id, @RequestBody Contact contact) {
        contactService.updateContact(id, contact);
    }

    @DeleteMapping("/contacts/{id}")
    public void deleteContact(@PathVariable Integer id) {
        contactService.deleteContact(id);
    }
}
