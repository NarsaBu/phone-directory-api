package com.example.phonedirectory.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "phone")
@JacksonXmlRootElement(localName = "Phone")
public class Phone implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JacksonXmlProperty(isAttribute = true)
    private UUID id;

    @Column(name = "number", nullable = false)
    @JacksonXmlProperty
    private String number;
}
