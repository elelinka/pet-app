package com.takecareofpet.petapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "KEEPER")
public class Keeper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false, updatable = false, unique = true)
    private String name;

    // @JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    // @JsonManagedReference
    @JsonIgnore
    @OneToMany(mappedBy = "keeper", cascade = CascadeType.ALL)
    private Set<Pet> pets;
}