package com.company.dto;

import com.company.domain.Payment;
import com.company.domain.PointOfSale;
import com.company.utils.Utils;

public class PaymentsOfPointSaleDTO {

    private Payment payment;
    private PointOfSale pointOfSale;

    public PaymentsOfPointSaleDTO(Payment payment, PointOfSale pointOfSale) {
        this.payment = payment;
        this.pointOfSale = pointOfSale;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PointOfSale getPointOfSale() {
        return pointOfSale;
    }

    public void setPointOfSale(PointOfSale pointOfSale) {
        this.pointOfSale = pointOfSale;
    }

    @Override
    public String toString() {
        return Utils.convertDate(payment.getDateOperation()) + " " + pointOfSale.getIdPointOfSale() + " "
                + "" + payment.getUuidOperaions() + " " + payment.getSumOperation();
    }
}
