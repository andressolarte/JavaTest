package com.kenect.kenectspringtest.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class EmailInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NotBlank (message = "Email is mandatory")
    String email;

    @ManyToOne
    @JoinColumn(name="label_id", nullable = true)
    private LabelInfo labelInfo;

    @ManyToOne (optional = false)
    @JoinColumn(name="contact_id", referencedColumnName = "id")
    private Contact contact;

    public EmailInfo() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public LabelInfo getLabelInfo() {
        return labelInfo;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
