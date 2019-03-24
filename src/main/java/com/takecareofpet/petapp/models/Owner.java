package com.takecareofpet.petapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "OWNER")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NICKNAME", nullable = false, unique = true, updatable = false)
    private String nickname;

    @NotNull
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @NotNull
    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @NotNull
    @Column(name = "FIRSTNAME")
    private String firstname;

    @NotNull
    @Column(name = "LASTNAME")
    private String lastname;


    // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Keeper> keepers;

    // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets;
}