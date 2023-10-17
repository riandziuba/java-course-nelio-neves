package org.example.entities;

import org.example.entities.enums.OrderStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private Date date;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Custumer custumer;

    static DateFormat dateFormat = new SimpleDateFormat();

    public Order(Date date, OrderStatus status, Custumer custumer) {
        this.date = date;
        this.status = status;
        this.custumer = custumer;
    }

    public Order(Integer id, Date date, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem orderItem) {
        this.items.add(orderItem);
    }

    public double totalValue() {
        double sum = 0;
        for(OrderItem item : this.items) {
            sum += item.subtotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public String summary() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Order moment: ").append(dateFormat.format(this.date)).append("\n");
        stringBuilder.append("Order status: ").append(this.status).append("\n");
        stringBuilder.append("Custumer: ").append(this.custumer.getName()).append(" (" + this.custumer.getFormattedBirthDate() + ") - ").append(this.custumer.getEmail()).append("\n");
        stringBuilder.append("Order items:").append("\n");
        for (OrderItem item : this.items) {
            stringBuilder.append(item.getProduct().getName() + ", ").append("$" + item.getProduct().getPrice()).append("Subtotal: $" + item.subtotal()).append("\n");
        }
        stringBuilder.append("Total price: ").append(this.totalValue());
        return stringBuilder.toString();
    }
}
