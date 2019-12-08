package com.company.domain;

import java.util.Date;

public class Payment {
    private float sumOperation;
    private String uuidOperaions;
    private Date dateOperation;


    public Payment(float sumOperation, String uuidOperaions, Date dateOperation) {
        this.sumOperation = sumOperation;
        this.uuidOperaions = uuidOperaions;
        this.dateOperation = dateOperation;
    }
    public  float getSumOperation() {
        return sumOperation;
    }
    public void setSumOperation(float sumOperation) {
        this.sumOperation = sumOperation;
    }


    public String getUuidOperaions() {
        return uuidOperaions;
    }

    public void setUuidOperaions(String uuidOperaions) {
        this.uuidOperaions = uuidOperaions;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "  sumOperation=" + sumOperation +
                ", uuidOperaions=" + uuidOperaions +
                ", dateOperation=" + dateOperation +
                '}';
    }
}
