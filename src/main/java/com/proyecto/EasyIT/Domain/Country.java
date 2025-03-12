package com.proyecto.EasyIT.Domain;


import jakarta.persistence.*;

@Entity
@Table(name="COUNTRIES")
public class Country {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="COUNTRY_ID")
    private Long idCountry;
    private String Country_Name;
    private String region_id;

    public Country(){

    }
}
