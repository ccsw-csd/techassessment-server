package com.ccsw.techassessment.position.model;

public class FiltersDto {

    private String client;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public FiltersDto() {
    }

    public FiltersDto(String client) {
        super();
        this.client = client;
    }

    @Override
    public String toString() {
        return "FiltersDto{" +
                "client=" + client +
                '}';
    }

}
