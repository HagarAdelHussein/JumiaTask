/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Jumia.Services.Service;

import com.Jumia.Services.Entity.Customer;
import com.Jumia.Services.Repository.CustomerRepository;
import com.Jumia.Services.Utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hagar.adel
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        List<Customer> customerList = Utils.validateCustomerList(customerRepository.findAll());
        return customerList;
    }

    public List<Customer> getByCountryName(String countryName) {
        String countryCode = Utils.countryCodeByName(countryName);
        if (!countryCode.isEmpty()) {
            List<Customer> customerList = Utils.validateCustomerList(customerRepository.getByCountryCode(countryCode));
            return customerList;
        }
        return null;
    }

    public List<Customer> getByCountryCode(String countryCode) {
        if (countryCode != null) {
            countryCode = "(" + countryCode.replace(" ", "") + ")";
            List<Customer> customerList = Utils.validateCustomerList(customerRepository.getByCountryCode(countryCode));
            return customerList;
        }
        return null;
    }

    public List<Customer> getByPhone(String phone) {
        if (phone != null) {
            List<Customer> customerList = Utils.validateCustomerList(customerRepository.getByPhone(phone));
            return customerList;
        }
        return null;
    }

    public List<Customer> getByValidCountry(String country, boolean valid) {
        List<Customer> validCustomerList = new ArrayList<>();
        String countryCode = Utils.countryCodeByName(country);
        if (!countryCode.isEmpty()) {
            List<Customer> customerList = Utils.validateCustomerList(customerRepository.getByCountryCode(countryCode));
            if (valid) {
                validCustomerList = Utils.validList(customerList);
            } else {
                validCustomerList = Utils.notValidList(customerList);
            }
            return validCustomerList;
        }
        return null;
    }

    public List<Customer> getByValidCustomer() {
        List<Customer> customerList = Utils.validateCustomerList(getAll());
        List<Customer> validCustomerList = Utils.validList(customerList);
        return validCustomerList;
    }

    public List<Customer> getByNotValidCustomer() {
        List<Customer> customerList = Utils.validateCustomerList(getAll());
        List<Customer> validCustomerList = Utils.notValidList(customerList);
        return validCustomerList;
    }
}
