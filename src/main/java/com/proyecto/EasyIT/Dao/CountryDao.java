package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country,String> {

}
