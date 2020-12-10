package com.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor
public class Space {

    @Id @Setter(AccessLevel.PROTECTED)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private Long hostId;
    private String type;
    private String name;
    private String description;
    private String amenities;
    private String maxGuestLimit;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String country;
}
