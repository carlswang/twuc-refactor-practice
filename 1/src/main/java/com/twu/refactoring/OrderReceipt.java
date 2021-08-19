package com.twu.refactoring;

public class OrderReceipt {
    private final Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		return "======Printing Orders======\n"
				+ order.outputDetails();
	}
}