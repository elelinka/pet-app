package com.takecareofpet.petapp.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.takecareofpet.petapp.common.enums.PetType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "PET")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "NAME", nullable = false, updatable = false)
    private String name;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "AGE")
    private Integer age;

    @NotNull
    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PetType type;

    // @JsonBackReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    // @JsonManagedReference
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "KEEPER_ID")
    private Keeper keeper;

}
