/**
 * @author Ostrovskiy Dmitriy
 * @created 23/04/2020
 * Class Builder for Person
 * @version v1.0
 */

package ru.geekbrains;
//Создать builder для класса Person со следующими полями: String firstName, String lastName,
//        String middleName, String country, String address, String phone, int age, String gender.

public class Main {

    public static void main(String[] args) {
        Person person = new Person.Builder().
                addFirstName(new FirstName()).
                addMiddleName(new MiddleName()).
                addLastName(new LastName()).
                addCountry(new Country()).
                addAddress(new Address()).
                addPhone(new Phone()).
                addAge(new Age()).
                addGender(new Gender()).build();
    }
}

class FirstName  {}
class MiddleName {}
class LastName   {}
class Country    {}
class Address    {}
class Phone      {}
class Age        {}
class Gender     {}

class Person{
    FirstName  firstName;
    MiddleName middleName;
    LastName   lastName;
    Country    country;
    Address    address;
    Phone      phone;
    Age        age;
    Gender     gender;

    public static class Builder{
        private FirstName  firstName;
        private MiddleName middleName;
        private LastName   lastName;
        private Country    country;
        private Address    address;
        private Phone      phone;
        private Age        age;
        private Gender     gender;

        public Builder addFirstName(FirstName firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder addMiddleName(MiddleName middleName) {
            this.middleName = middleName;
            return this;
        }
        public Builder addLastName(LastName lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder addCountry(Country country) {
            this.country = country;
            return this;
        }
        public Builder addAddress(Address address) {
            this.address = address;
            return this;
        }
        public Builder addPhone(Phone phone) {
            this.phone = phone;
            return this;
        }
        public Builder addAge(Age age) {
            this.age = age;
            return this;
        }
        public Builder addGender(Gender gender) {
            this.gender = gender;
            return this;
        }
        public Person build(){
            return new Person();
        }
    }
}










