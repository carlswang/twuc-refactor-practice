package com.twu.refactoring;

public class OrderReceipt {
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		return outputHead() + outputDetails();
	}

	private String outputDetails() {
		StringBuilder output = new StringBuilder();
		double totSalesTx = 0d;
		double tot = 0d;
		output.append(order.getCustomerName())
				.append(order.getCustomerAddress());

		for (LineItem lineItem : order.getLineItems()) {
			lineItem.getLineItemInfo(output);
		}

		for (LineItem lineItem : order.getLineItems()) {
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx += salesTax;
            tot += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t')
				.append(totSalesTx)
				.append("Total Amount").append('\t')
				.append(tot);
		return output.toString();
	}

	private String outputHead() {
		return "======Printing Orders======\n";
	}
}