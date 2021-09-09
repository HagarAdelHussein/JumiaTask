/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Jumia.Services.Utils;

import com.Jumia.Services.Entity.Country;
import com.Jumia.Services.Entity.Customer;
import com.Jumia.Services.Manager.LoaderManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author hagar.adel
 */
public class Utils {

    public static String countryCodeByName(String coutryName) {
        List<Country> countryList = LoaderManager.countryList;
        for (Country country : countryList) {
            if (coutryName.equals(country.getName())) {
                String countryCode = "(" + country.getCode().replace("+", "") + ")";
                return countryCode;
            }
        }
        return "";
    }

    public static List<Customer> validateCustomerList(List<Customer> customerList) {
        for (Customer customer : customerList) {
            if (customer.getValid() == null) {
                customer.setValid(Utils.validPhone(customer.getPhone()));
            }
        }
        return customerList;
    }

    public static List<Customer> validList(List<Customer> customerList) {
        List<Customer> validList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getValid() == "Valid" ) {
                validList.add(customer);
            }
        }
        return validList;
    }

    public static List<Customer> notValidList(List<Customer> customerList) {
        List<Customer> notValidList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getValid() == "Not Valid") {
                notValidList.add(customer);
            }
        }
        return notValidList;
    }

    public static String validPhone(String phone) {
        if (phone != null || !phone.isEmpty()) {
            String phoneCode = "+" + phone.substring(phone.indexOf("(") + 1, phone.indexOf(")"));

            List<Country> countryList = LoaderManager.countryList;
            for (Country country : countryList) {
                if (phoneCode.equals(country.getCode())) {
                    String regex = country.getRegex();
                    if (Pattern.compile(regex).matcher(phone).matches()) {
                        return "Valid";
                    } else {
                        return "Not Valid";
                    }
                }
            }

        }
        return "";
    }
}
