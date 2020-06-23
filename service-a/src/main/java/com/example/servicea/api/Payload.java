package com.example.servicea.api;

class Payload {

    private String api;
    private String brand;
    private String country;

    Payload(String api, String brand, String country) {
        this.api = api;
        this.brand = brand;
        this.country = country;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
