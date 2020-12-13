package br.com.saas.church.dtos;

import br.com.saas.church.models.Person;

public class MemberDTO extends Person {

    private String id;
    private String branch;
    private String core;
    private String role;

    public MemberDTO() {
    }

    public static class Builder {

        private MemberDTO memberDto;


        public Builder() {
            this.memberDto = new MemberDTO();
        }

        public Builder name(String name) {
            this.memberDto.setName(name);
            return this;
        }

        public Builder cpf(String cpf) {
            this.memberDto.setCpf(cpf);
            return this;
        }

        public Builder birthDate(String birthDate) {
            this.memberDto.setBirthDate(birthDate);
            return this;
        }

        public Builder gender(String gender) {
            this.memberDto.setGender(gender);
            return this;
        }

        public Builder email(String email) {
            this.memberDto.setEmail(email);
            return this;
        }

        public Builder telephone(String telephone) {
            this.memberDto.setTelephone(telephone);
            return this;
        }

        public Builder cep(String cep) {
            this.memberDto.setCep(cep);
            return this;
        }

        public Builder address(String address) {
            this.memberDto.setAddress(address);
            return this;
        }

        public Builder number(String number) {
            this.memberDto.setNumber(number);
            return this;
        }

        public Builder complement(String complement) {
            this.memberDto.setComplement(complement);
            return this;
        }

        public Builder neighborhood(String neighborhood) {
            this.memberDto.setNeighborhood(neighborhood);
            return this;
        }

        public Builder city(String city) {
            this.memberDto.setCity(city);
            return this;
        }

        public Builder state(String state) {
            this.memberDto.setState(state);
            return this;
        }

        public Builder country(String country) {
            this.memberDto.setCountry(country);
            return this;
        }

        public Builder bloodType(String bloodType) {
            this.memberDto.setBloodType(bloodType);
            return this;
        }

        public Builder id(String id) {
            this.memberDto.setId(id);
            return this;
        }

        public Builder branch(String branch) {
            this.memberDto.setBranch(branch);
            return this;
        }


        public MemberDTO build() {
            return this.memberDto;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
