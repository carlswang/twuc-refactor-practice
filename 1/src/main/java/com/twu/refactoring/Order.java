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
        return lineItemList.stream()
                .mapToDouble(lineItem -> lineItem.totalAmount() * .10)
                .sum();
    }

    public String outputDetails() {
        StringBuilder output = new StringBuilder();
        output.append(name)
                .append(address);

        for (LineItem lineItem : lineItemList) {
            lineItem.getLineItemInfo(output);
        }

        output.append("Sales Tax").append('\t')
                .append(getTotalTax())
                .append("Total Amount").append('\t')
                .append(lineItemList.stream()
                        .mapToDouble(lineItem -> lineItem.totalAmount() + lineItem.totalAmount() * .10)
                        .sum());

        return output.toString();
    }
}
