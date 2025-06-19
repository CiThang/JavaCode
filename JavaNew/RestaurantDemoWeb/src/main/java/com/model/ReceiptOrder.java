package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReceiptOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customer_name;
    private Double total;
    private Double amount;
    private Double change_amount ;
    private Date date;

    public ReceiptOrder() {
        super();
    }

    public ReceiptOrder(String customerName, Double total, Double amount, Double changeAmount , Date date) {
        this.customer_name = customerName;
        this.total = total;
        this.amount = amount;
        this.change_amount  = changeAmount ;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public void setCustomerName(String customerName) {
        this.customer_name = customerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getChange() {
        return change_amount ;
    }

    public void setChange(Double changeAmount ) {
        this.change_amount  = changeAmount ;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
