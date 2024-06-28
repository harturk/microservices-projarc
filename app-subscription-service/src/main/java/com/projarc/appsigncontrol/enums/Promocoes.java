package com.projarc.appsigncontrol.enums;

public enum Promocoes {
    PROMO30DAYS(30, 0.05);

    private final int extraDays;
    private final double discount;

    Promocoes(int extraDays, double discount) {
        this.extraDays = extraDays;
        this.discount = discount;
    }

    public int getExtraDays() {
        return extraDays;
    }

    public double getDiscount() {
        return discount;
    }
}
