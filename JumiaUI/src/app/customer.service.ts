import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { Country } from './country';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = "http://localhost:8080/Jumia";

  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl+'/getCustomers');
  }

  getCountrys():Observable<Country[]> {
    return this.http.get<Country[]>(this.baseUrl+'/getCountry');
  }

  getByCountry(country: String):Observable<Customer[]> {
    console.log(this.baseUrl+'/getByCountry?country='+country);
    
    return this.http.get<Customer[]>(this.baseUrl+'/getByCountry?country='+country);
  }
  
  getByCountryCode(countryCode: String):Observable<Customer[]> {
    console.log(this.baseUrl+'/getByCountryCode?countryCode='+countryCode);
    
    return this.http.get<Customer[]>(this.baseUrl+'/getByCountryCode?countryCode='+countryCode);
  }

  getPhone(phone: String):Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl+'/getByPhone?phoneNumber='+phone);
  }

  getByValid(country: String,valid :boolean):Observable<Customer[]> {
    console.log(this.baseUrl+'/getByValidion?country='+country + '&valid='+valid);
    return this.http.get<Customer[]>(this.baseUrl+'/getByValidion?country='+country + '&valid='+valid);
  }
}
