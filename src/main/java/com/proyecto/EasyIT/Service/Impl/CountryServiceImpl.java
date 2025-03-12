package com.proyecto.EasyIT.Service.Impl;

import com.proyecto.EasyIT.Dao.CountryDao;
import com.proyecto.EasyIT.Domain.Country;
import com.proyecto.EasyIT.Service.CountryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryDao countryDao;

    @Override
    //@Transactional(readOnly=true)
    public List<Country> getCountries(){
        var lista = countryDao.findAll();
        return lista;
    }
}
