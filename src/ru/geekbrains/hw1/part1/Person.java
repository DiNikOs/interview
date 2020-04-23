/**
 * @author Ostrovskiy Dmitriy
 * @created 23/04/2020
 * Class Person builder
 * @version v1.0
 */

package ru.geekbrains.hw1.part1;

public class Person {
    FirstName firstName;
    MiddleName middleName;
    LastName lastName;
    Country country;
    Address address;
    Phone phone;
    Age age;
    Gender gender;

    public static class Builder {
        protected FirstName firstName;
        protected MiddleName middleName;
        protected LastName lastName;
        protected Country country;
        protected Address address;
        protected Phone phone;
        protected Age age;
        protected Gender gender;

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

        public Person build() {
            return new Person();
        }
    }
}
