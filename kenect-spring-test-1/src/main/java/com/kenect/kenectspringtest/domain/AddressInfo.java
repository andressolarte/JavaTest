package com.kenect.kenectspringtest.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class AddressInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Address is mandatory")
    @NotNull(message = "Address is mandatory")
    private String address;

    @ManyToOne
    @JoinColumn(name="contact_id")
    private Contact contact;

    @ManyToOne
    @JoinColumn(name="label_id", nullable = true)
    private LabelInfo labelInfo;

    public AddressInfo() {
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public LabelInfo getLabelInfo() {
        return labelInfo;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
