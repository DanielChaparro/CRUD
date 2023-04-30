package com.vass.crud.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "clients")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private String identification;

    @Column
    private String email;

    @Column(name = "birth_date")
    private Date birthDate;

}
