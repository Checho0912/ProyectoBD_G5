package com.proyecto.EasyIT.Dao;

import com.proyecto.EasyIT.Domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryDao extends JpaRepository<Country,Long> {

}
