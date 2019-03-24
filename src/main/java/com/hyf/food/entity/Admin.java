package com.hyf.food.entity;

public class Admin {
    private Long a_id;

    private String a_name;

    private String a_password;

    public Long geta_id() {
        return a_id;
    }

    public void seta_id(Long a_id) {
        this.a_id = a_id;
    }

    public String geta_name() {
        return a_name;
    }

    public void seta_name(String a_name) {
        this.a_name = a_name == null ? null : a_name.trim();
    }

    public String geta_password() {
        return a_password;
    }

    public void seta_password(String a_password) {
        this.a_password = a_password == null ? null : a_password.trim();
    }
}