package com.kenect.kenectspringtest;

import com.kenect.kenectspringtest.controller.ContactController;
import com.kenect.kenectspringtest.domain.Contact;
import com.kenect.kenectspringtest.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class, secure = false)
public class ContactControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ContactService contactService;

    @Test
    public void getAllContact() throws Exception {
        Contact c = new Contact("andres felipe","solarte","uno", "dos", "tres","1", "2", "3", "tele", "local", "ninguna");
        c.setId(1);

        List<Contact> contacts = Arrays.asList(c);
        given(contactService.getAllContacts()).willReturn(contacts);

        mvc.perform(get("/contacts")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].firstName").value(c.getFirstName()));
    }

    @Test
    public void deleteContact() throws Exception {
        Contact c = new Contact("andres felipe","solarte","uno", "dos", "tres","1", "2", "3", "tele", "local", "ninguna");
        c.setId(1);

        List<Contact> contacts = Arrays.asList(c);
        given(contactService.getAllContacts()).willReturn(contacts);

        mvc.perform(get("/contacts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName").value(c.getFirstName()));

        contactService.deleteContact(1);
        given(contactService.getAllContacts()).willReturn(new ArrayList());

        mvc.perform(delete("/contacts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mvc.perform(get("/contacts")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(0)));

    }

}
