import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service'
import { Customer } from '../customer';
import { Country } from '../country';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customers: Customer[];
  countrys: Country[];
  validation = [{id: 1 , name:"Valid", value:true}, 
              {id: 2 , name:"Not Valid", value:false}];

  countrySelect;
  countryCodeSelect;
  valid;

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
    this.customerService.getCustomers().subscribe((data: Customer[]) => {
      console.log(data);
      this.customers = data;
    });
    this.customerService.getCountrys().subscribe((data: Country[]) => {
      console.log(data);
      this.countrys = data;
    });
  }
  searchCountry() {
    console.log(this.countrySelect);
    this.countryCodeSelect = '';
    this.valid = '';
    this.customerService.getByCountry(this.countrySelect).subscribe((data: Customer[]) => {
      console.log(data);
      this.customers = data;
    });
  }

  searchCountryCode() {
    console.log(this.countryCodeSelect);
    this.countrySelect = '';
    this.valid='';
    this.customerService.getByCountryCode(this.countryCodeSelect).subscribe((data: Customer[]) => {
      console.log(data);
      this.customers = data;
    });
  }

  searchPhone(phoneNumber: String) {
    this.countryCodeSelect = '';
    this.valid = '';
    this.customerService.getPhone(phoneNumber).subscribe((data: Customer[]) => {
      console.log(data);
      this.customers = data;
    });
  }

  searchValid() {
    console.log(this.valid);
    this.countryCodeSelect = '';
    this.customerService.getByValid(this.countrySelect,this.valid).subscribe((data: Customer[]) => {
      console.log(data);
      this.customers = data;
    });
  }
}