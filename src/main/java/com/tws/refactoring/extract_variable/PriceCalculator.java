package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    private static final int MAX_QUANTITY_LIMIT=500;
    private static final double MAX_SHIPPING_COST=100.0;
    private static final double DISCOUNT_RATE=0.05;
    private static final double SHIPPING_RATE=0.1;


    double getPrice(int quantity, int itemPrice) {
        // Price consists of: base price - discount + shipping cost
        double discountMoney = Math.max(0, quantity - MAX_QUANTITY_LIMIT) * itemPrice * DISCOUNT_RATE;
        int basePrice = quantity * itemPrice;
        double shippingPrice = Math.min(quantity * itemPrice * SHIPPING_RATE, MAX_SHIPPING_COST);


        return basePrice - discountMoney + shippingPrice;
    }
}
