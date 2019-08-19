package com.kenect.kenectspringtest.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class LabelInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @NotBlank(message = "Label name is mandatory")
    private String name;

    public LabelInfo() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
