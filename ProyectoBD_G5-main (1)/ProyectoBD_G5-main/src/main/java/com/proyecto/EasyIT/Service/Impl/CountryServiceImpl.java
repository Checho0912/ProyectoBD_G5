package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.CountryDao;
import com.proyecto.EasyIT.Model.Country;
import com.proyecto.EasyIT.Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    public List<Country> getCountries(){
        var lista = countryDao.findAll();

        return lista;
    }
}
