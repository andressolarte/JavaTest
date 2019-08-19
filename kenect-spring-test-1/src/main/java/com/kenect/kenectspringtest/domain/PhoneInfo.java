package com.kenect.kenectspringtest.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class PhoneInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Number is mandatory")
    private String number;

    @ManyToOne
    @JoinColumn(name="label_id", nullable = true)
    private LabelInfo labelInfo;


    @ManyToOne
    @JoinColumn(name="contact_id")
    private Contact contact;

    public PhoneInfo() {
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public LabelInfo getLabelInfo() {
        return labelInfo;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
