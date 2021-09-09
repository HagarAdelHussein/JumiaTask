package com.Jumia.Services.Controller;

import com.Jumia.Services.Entity.Country;
import com.Jumia.Services.Entity.Customer;
import com.Jumia.Services.Service.CountryService;
import com.Jumia.Services.Service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author islam.said
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/Jumia/getCountry")
    public List<Country> getCountry() {
        List<Country> countrys = countryService.getAllCountry(); 
        return countrys;
    }

}
