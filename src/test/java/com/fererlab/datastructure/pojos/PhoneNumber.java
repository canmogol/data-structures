package com.fererlab.datastructure.pojos;

/**
 * PhoneNumber class for complex type testing
 */
public class PhoneNumber {
    private Integer country;
    private Integer city;
    private Integer phone;
    private Integer extension;

    public PhoneNumber(Integer country, Integer city, Integer phone, Integer extension) {
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.extension = extension;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getExtension() {
        return extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }
}
