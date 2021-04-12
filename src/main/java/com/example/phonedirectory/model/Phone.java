package com.example.phonedirectory.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "number", nullable = false)
    private String number;
}
