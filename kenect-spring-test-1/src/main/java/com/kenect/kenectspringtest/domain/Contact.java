package com.kenect.kenectspringtest.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "First name is mandatory")
    private String firstName;
    private String lastName;

    private String enterprise;
    private String notes;

    @OneToMany (mappedBy = "contact", cascade = CascadeType.ALL)
    private List<EmailInfo> emails;

    @OneToMany (mappedBy = "contact", cascade = CascadeType.ALL)
    private List<PhoneInfo> phones;

    @OneToMany (mappedBy = "contact", cascade = CascadeType.ALL)
    private List<AddressInfo> addresses;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String address1, String address2, String address3, String mobile, String mobile2, String mobile3, String landLine, String enterprise, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.enterprise = enterprise;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEnterprise() {
        return enterprise;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<EmailInfo> getEmails() {
        return emails;
    }

    public List<PhoneInfo> getPhones() {
        return phones;
    }

    public List<AddressInfo> getAddresses() {
        return addresses;
    }
}
