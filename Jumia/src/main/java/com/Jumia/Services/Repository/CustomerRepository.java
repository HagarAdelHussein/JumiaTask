/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Jumia.Services.Repository;

import com.Jumia.Services.Entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hagar.adel
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value="select *  from customer c where c.phone like ?1% ", nativeQuery = true)
    public List<Customer> getByCountryCode(String countryCode);

    @Query(value="select *  from customer c where phone= ?1", nativeQuery = true)
    public List<Customer> getByPhone(String phone);

}
