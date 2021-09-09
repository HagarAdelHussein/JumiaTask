package com.Jumia.Services.Manager;

import com.Jumia.Services.Entity.Country;
import com.Jumia.Services.Entity.Customer;
import com.Jumia.Services.Repository.CountryRepository;
import com.Jumia.Services.Repository.CustomerRepository;
import com.Jumia.Services.Service.CountryService;
import com.Jumia.Services.Service.CustomerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author hagar.adel
 */
@Component
public class LoaderManager {

    public static List<Country> countryList = new ArrayList<>();

    @Autowired
    private CountryService countryService;

    @EventListener
    public void onApplicationEvent(ApplicationStartedEvent event) {

        countryList = countryService.getAllCountry();
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {

    }

}
