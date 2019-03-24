package com.hyf.food.entity;

import java.util.Date;

public class Employee {
    private Long e_id;

    private String e_name;

    private Long e_tel;

    private String e_password;

    private String e_address;

    private Date e_regdate;

    private String e_job;

    private Float e_salary;

    private Long e_position;

    public Long gete_id() {
        return e_id;
    }

    public void sete_id(Long e_id) {
        this.e_id = e_id;
    }

    public String gete_name() {
        return e_name;
    }

    public void sete_name(String e_name) {
        this.e_name = e_name == null ? null : e_name.trim();
    }

    public Long gete_tel() {
        return e_tel;
    }

    public void sete_tel(Long e_tel) {
        this.e_tel = e_tel;
    }

    public String gete_password() {
        return e_password;
    }

    public void sete_password(String e_password) {
        this.e_password = e_password == null ? null : e_password.trim();
    }

    public String gete_address() {
        return e_address;
    }

    public void sete_address(String e_address) {
        this.e_address = e_address == null ? null : e_address.trim();
    }

    public Date gete_regdate() {
        return e_regdate;
    }

    public void sete_regdate(Date e_regdate) {
        this.e_regdate = e_regdate;
    }

    public String gete_job() {
        return e_job;
    }

    public void sete_job(String e_job) {
        this.e_job = e_job == null ? null : e_job.trim();
    }

    public Float gete_salary() {
        return e_salary;
    }

    public void sete_salary(Float e_salary) {
        this.e_salary = e_salary;
    }

    public Long gete_position() {
        return e_position;
    }

    public void sete_position(Long e_position) {
        this.e_position = e_position;
    }
}