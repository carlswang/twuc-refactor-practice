package com.twu.refactoring;

public class LineItem {
	private final String description;
	private final double price;
	private final int quantities;

	public LineItem(String description, double price, int quantities) {
		this.description = description;
		this.price = price;
		this.quantities = quantities;
	}

	double totalAmount() {
        return price * quantities;
    }

    public void getLineItemInfo(StringBuilder output) {
		output.append(description + '\t'
                + price + '\t'
                + quantities + '\t'
                + totalAmount() + '\n');
    }
}