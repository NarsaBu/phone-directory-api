package com.example.phonedirectory.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_account")
@JacksonXmlRootElement(localName = "UserAccount")
public class UserAccount implements Serializable {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @GeneratedValue
    @JacksonXmlProperty(isAttribute = true)
    private UUID id;

    @Column(name = "username", nullable = false)
    @JacksonXmlProperty
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    @JacksonXmlProperty(localName = "Phone")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Phone> phones = new ArrayList<>();
}
