package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<LineItem> lineItemList;

    public Order(String name, String address, List<LineItem> lineItemList) {
        this.name = name;
        this.address = address;
        this.lineItemList = lineItemList;
    }

    public double getTotalTax() {
        double totSalesTx = 0d;
        for (LineItem lineItem : lineItemList) {
            totSalesTx += lineItem.totalAmount() * .10;
        }
        return totSalesTx;
    }

    public String outputDetails() {
        StringBuilder output = new StringBuilder();
        output.append(name)
                .append(address);

        for (LineItem lineItem : lineItemList) {
            lineItem.getLineItemInfo(output);
        }

        double total = 0d;
        for (LineItem lineItem : lineItemList) {
            total += lineItem.totalAmount() + lineItem.totalAmount() * .10;
        }

        output.append("Sales Tax").append('\t')
                .append(getTotalTax())
                .append("Total Amount").append('\t')
                .append(total);

        return output.toString();
    }
}
