package com.kenect.kenectspringtest.controller;

import com.kenect.kenectspringtest.domain.Contact;
import com.kenect.kenectspringtest.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ContactController {


    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/signup")
    public String showSignUpForm(Contact user) {
        return "add-contact";
    }

    @GetMapping("/contacts")
    public String getAllContacts (Model model) {
         model.addAttribute("contacts", contactService.getAllContacts());

         return "index";
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
