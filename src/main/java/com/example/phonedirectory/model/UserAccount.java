package com.example.phonedirectory.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_account")
public class UserAccount {

    @Id
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    @GeneratedValue
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id", referencedColumnName = "id")
    private List<Phone> phones = new ArrayList<>();
}
