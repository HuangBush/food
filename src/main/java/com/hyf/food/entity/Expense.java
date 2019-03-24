package com.hyf.food.entity;

import java.util.Date;


public class Expense {
    private Long ex_id;

    private String ex_name;

    private Float ex_price;

    private String ex_other;

    private Date ex_regtime;

    public Long getex_id() {
        return ex_id;
    }

    public void setex_id(Long ex_id) {
        this.ex_id = ex_id;
    }

    public String getex_name() {
        return ex_name;
    }

    public void setex_name(String ex_name) {
        this.ex_name = ex_name == null ? null : ex_name.trim();
    }

    public Float getex_price() {
        return ex_price;
    }

    public void setex_price(Float ex_price) {
        this.ex_price = ex_price;
    }

    public String getex_other() {
        return ex_other;
    }

    public void setex_other(String ex_other) {
        this.ex_other = ex_other == null ? null : ex_other.trim();
    }

    public Date getex_regtime() {
        return ex_regtime;
    }

    public void setex_regtime(Date ex_regtime) {
        this.ex_regtime = ex_regtime;
    }
}