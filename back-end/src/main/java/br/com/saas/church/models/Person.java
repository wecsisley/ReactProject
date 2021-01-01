package br.com.saas.church.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Person {

    @NotEmpty(message = "Name must not be empty")
    protected String name;
    @NotEmpty(message = "CPF must not be empty")
    protected String cpf;
    @NotEmpty(message = "Birth Date must not be empty")
    protected String birthDate;
    @NotEmpty(message = "Gender must not be empty")
    protected String gender;
    @Email
    protected String email;
    protected String telephone;
    @NotEmpty(message = "Cep must not be empty")
    protected String cep;
    @NotEmpty(message = "Address must not be empty")
    protected String address;
    protected String number;
    protected String complement;
    @NotEmpty(message = "Neighborhood must not be empty")
    protected String neighborhood;
    @NotEmpty(message = "City must not be empty")
    protected String city;
    @NotEmpty(message = "State must not be empty")
    protected String state;
    @NotEmpty(message = "Country must not be empty")
    protected String country;
    protected String bloodType;

    public Person() {
    }

    public static class Builder {

        private Person person;

        public Builder() {
            this.person = new Person();
        }

        public Builder name(String name) {
            this.person.setName(name);
            return this;
        }

        public Builder cpf(String cpf) {
            this.person.setCpf(cpf);
            return this;
        }

        public Builder birthDate(String birthDate) {
            this.person.setBirthDate(birthDate);
            return this;
        }

        public Builder gender(String gender) {
            this.person.setGender(gender);
            return this;
        }

        public Builder email(String email) {
            this.person.setEmail(email);
            return this;
        }

        public Builder telephone(String telephone) {
            this.person.setTelephone(telephone);
            return this;
        }

        public Builder cep(String cep) {
            this.person.setCep(cep);
            return this;
        }

        public Builder address(String address) {
            this.person.setAddress(address);
            return this;
        }

        public Builder number(String number) {
            this.person.setNumber(number);
            return this;
        }

        public Builder complement(String complement) {
            this.person.setComplement(complement);
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.person.setNeighborhood(neighborhood);
            return this;
        }

        public Builder city(String city) {
            this.person.setCity(city);
            return this;
        }

        public Builder state(String state) {
            this.person.setState(state);
            return this;
        }

        public Builder country(String country) {
            this.person.setCountry(country);
            return this;
        }

        public Builder bloodType(String bloodType) {
            this.person.setBloodType(bloodType);
            return this;
        }

        public Person build() {
            return this.person;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
