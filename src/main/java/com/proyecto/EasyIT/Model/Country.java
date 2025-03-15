package com.proyecto.EasyIT.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name="COUNTRIES")
public class Country implements Serializable {

    @Id
    @Column(name="COUNTRY_ID")
    private String idCountry;
    @Column(name="COUNTRY_NAME")
    private String Country_Name;
    @Column(name="REGION_ID")
    private int region_id;

    public Country(){

    }
    // Optional: Override toString() for readable output
    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + idCountry + '\'' +
                ", countryName='" + Country_Name + '\'' +
                ", regionId=" + region_id+
                '}';
    }
}
