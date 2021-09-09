package com.Jumia.Services.Controller;

import com.Jumia.Services.Entity.Customer;
import com.Jumia.Services.Service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author islam.said
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/Jumia/getCustomers")
    public List<Customer> getCustomers() {
        List<Customer> customerList = customerService.getAll();
        return customerList;
    }

    @GetMapping("/Jumia/getByCountry")
    public List<Customer> getByCountry(@RequestParam String country) {
        List<Customer> customerList = customerService.getByCountryName(country);
        return customerList;
    }

    @GetMapping("/Jumia/getByCountryCode")
    public List<Customer> getByCountryCode(@RequestParam String countryCode) {
        List<Customer> customerList = customerService.getByCountryCode(countryCode);
        return customerList;
    }

    @GetMapping("/Jumia/getByPhone")
    public List<Customer> getByPhone(@RequestParam String phoneNumber) {
        List<Customer> customerList = customerService.getByPhone(phoneNumber);
        return customerList;
    }

    @GetMapping("/Jumia/getByValidion")
    public List<Customer> getByValidion(@RequestParam String country, @RequestParam boolean valid) {
        List<Customer> customerList = new ArrayList<>();
        if (country != null && !country.equals("undefined") && !country.isEmpty()) {
            customerList = customerService.getByValidCountry(country, valid);
        } else if (valid) {
            customerList = customerService.getByValidCustomer();
        } else if (!valid) {
            customerList = customerService.getByNotValidCustomer();
        }
        return customerList;
    }

}
