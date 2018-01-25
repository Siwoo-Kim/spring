package com.learning.spring.domain;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable @Getter @ToString @EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String postCode;

}
