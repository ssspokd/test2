package com.company.domain;

public class PointOfSale {

    private String IdPointOfSale;

    public PointOfSale(String idPointOfSale) {
        IdPointOfSale = idPointOfSale;
    }

    public String getIdPointOfSale() {
        return IdPointOfSale;
    }

    public void setIdPointOfSale(String idPointOfSale) {
        IdPointOfSale = idPointOfSale;
    }

    @Override
    public String toString() {
        return "PointOfSale{" +
                "IdPointOfSale='" + IdPointOfSale + '\'' +
                '}';
    }
}
