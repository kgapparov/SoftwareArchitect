package esb;

public class Order {
	private String orderNumber;
	private double amount;

	private OrderType orderType;

	public Order(String orderNumber, OrderType type, double amount) {
		super();
		this.orderNumber = orderNumber;
		this.amount = amount;
		this.orderType = type;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderNumber='" + orderNumber + '\'' +
				", amount=" + amount +
				", orderType=" + orderType +
				'}';
	}
}
