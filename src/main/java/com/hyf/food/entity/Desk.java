package com.hyf.food.entity;

public class Desk {
    private Long d_id;

    private String d_password;

    private String d_name;

    private String d_type;

    private String d_place;

    private Long d_position;

    public Long getd_id() {
        return d_id;
    }

    public void setd_id(Long d_id) {
        this.d_id = d_id;
    }

    public String getd_password() {
        return d_password;
    }

    public void setd_password(String d_password) {
        this.d_password = d_password == null ? null : d_password.trim();
    }

    public String getd_name() {
        return d_name;
    }

    public void setd_name(String d_name) {
        this.d_name = d_name == null ? null : d_name.trim();
    }

    public String getd_type() {
        return d_type;
    }

    public void setd_type(String d_type) {
        this.d_type = d_type == null ? null : d_type.trim();
    }

    public String getd_place() {
        return d_place;
    }

    public void setd_place(String d_place) {
        this.d_place = d_place == null ? null : d_place.trim();
    }

    public Long getd_position() {
        return d_position;
    }

    public void setd_position(Long d_position) {
        this.d_position = d_position;
    }
}