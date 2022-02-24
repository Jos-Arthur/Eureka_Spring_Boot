package com.bf.gov.ecme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "childs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChild;
    private String lastName;
    private String firstName;
    private Integer age;
    private LocalDate birthDate;
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @JsonIgnore
    private User parent;

}
