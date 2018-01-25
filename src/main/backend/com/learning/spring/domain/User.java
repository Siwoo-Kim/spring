package com.learning.spring.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "TBL_USER")
@SequenceGenerator(name = "USER_SEQ_GENERATOR",
        sequenceName = "USER_SEQ",
        initialValue = 1, allocationSize = 1)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @Column(name = "USER_ID")
    private Long id;

    @Email
    private String email;

    private String name;

    @Embedded
    private Address address;

    private String telephone;

    @NotNull
    private int age;

    @Max(10000)
    @Builder.Default
    private double point = 0;


}