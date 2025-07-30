package model;

import java.util.Objects;

public class UserTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private AdressTO address;
    private String phone;
    private String website;
    private CompanyTO company;


    public UserTO(int id, String name, String username, String email, AdressTO address, String phone, String website, CompanyTO company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
    public UserTO() {
        // Default constructor for deserialization
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdressTO getAddress() {
        return address;
    }

    public void setAddress(AdressTO address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public CompanyTO getCompany() {
        return company;
    }

    public void setCompany(CompanyTO company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserTO userTO)) return false;
        return getId() == userTO.getId() &&
                getName().equals(userTO.getName()) &&
                getUsername().equals(userTO.getUsername()) &&
                getEmail().equals(userTO.getEmail()) &&
                getAddress().equals(userTO.getAddress()) &&
                getPhone().equals(userTO.getPhone()) &&
                getWebsite().equals(userTO.getWebsite()) &&
                getCompany().equals(userTO.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getUsername(), getEmail(), getAddress(), getPhone(), getWebsite(), getCompany());
    }
}
