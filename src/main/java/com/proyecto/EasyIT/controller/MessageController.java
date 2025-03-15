package com.proyecto.EasyIT.controller;

import com.proyecto.EasyIT.Model.Country;
import com.proyecto.EasyIT.Model.Dispositivo_de_computacion;
import com.proyecto.EasyIT.Service.CountryService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {
    @Autowired
    CountryService countryService;

    @GetMapping("/hello")
    public List<Country> hello(){

        List<Country> paises= countryService.getCountries();



        return paises;
    }
}
