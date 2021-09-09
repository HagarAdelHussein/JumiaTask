package com.Jumia.Services;

import com.Jumia.Services.Entity.Customer;
import com.Jumia.Services.Service.CustomerService;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class JumiaApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testGetAllCustomers() {
        List<Customer> customerList = customerService.getAll();

        assertThat(customerList.size()).isEqualTo(41);
    }

    @Test
    public void testGetByCountryName() {
        List<Customer> customerList = customerService.getByCountryName("Morocco");

        assertThat(customerList.size()).isEqualTo(7);

    }

    @Test
    public void testGetByCountryCode() {
        List<Customer> customerList = customerService.getByCountryCode("256");
        String phone = customerList.get(3).getPhone();
        String phoneCode = phone.substring(phone.indexOf("(") + 1, phone.indexOf(")"));

        assertThat(customerList.size()).isEqualTo(7);
        assertThat(phoneCode).isEqualTo("256");
    }

    @Test
    public void testGetByPhone() {
        List<Customer> customerList = customerService.getByPhone("(251) 9119454961");
        Customer customer = customerList.get(0);

        assertThat(customerList.size()).isEqualTo(1);
        assertThat(customer.getPhone()).isEqualTo("(251) 9119454961");
    }

    @Test
    public void testGetByValidCountry() {
        List<Customer> customerList = customerService.getByValidCountry("Cameroon", true);
        Customer customer = customerList.get(5);

        assertThat(customerList.size()).isEqualTo(7);
        assertThat(customer.getValid()).isEqualTo("Valid");
    }

    @Test
    public void testGetByValidCustomer() {
        List<Customer> customerList = customerService.getByValidCustomer();

        assertThat(customerList.get(0).getValid()).isEqualTo("Valid");
        assertThat(customerList.get(5).getValid()).isEqualTo("Valid");
        assertThat(customerList.get(10).getValid()).isEqualTo("Valid");
        assertThat(customerList.get(13).getValid()).isEqualTo("Valid");
        assertThat(customerList.get(17).getValid()).isEqualTo("Valid");
        assertThat(customerList.get(20).getValid()).isEqualTo("Valid");
    }

    @Test
    public void testGetByNotValidCustomer() {
        List<Customer> customerList = customerService.getByNotValidCustomer();

        assertThat(customerList.get(0).getValid()).isEqualTo("Not Valid");
        assertThat(customerList.get(5).getValid()).isEqualTo("Not Valid");
        assertThat(customerList.get(10).getValid()).isEqualTo("Not Valid");
        assertThat(customerList.get(13).getValid()).isEqualTo("Not Valid");
    }
}
