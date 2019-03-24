package com.hyf.food.entity;

import java.util.Date;

public class Orderitem {
    private Long oi_id;

    private Long os_id;

    private Long m_id;

    private Long oi_num;

    private Float oi_price;

    private Date oi_pegtime;

    private Long oi_position;

    //bean
    private Menu menu;
    
    
    public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Orderitem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orderitem(Long os_id, Long m_id, Long oi_num, Float oi_price) {
		super();
		this.os_id = os_id;
		this.m_id = m_id;
		this.oi_num = oi_num;
		this.oi_price = oi_price;
	}

	public Long getoi_id() {
        return oi_id;
    }

    public void setoi_id(Long oi_id) {
        this.oi_id = oi_id;
    }

    public Long getos_id() {
        return os_id;
    }

    public void setos_id(Long os_id) {
        this.os_id = os_id;
    }

    public Long getm_id() {
        return m_id;
    }

    public void setm_id(Long m_id) {
        this.m_id = m_id;
    }

    public Long getoi_num() {
        return oi_num;
    }

    public void setoi_num(Long oi_num) {
        this.oi_num = oi_num;
    }

    public Float getoi_price() {
        return oi_price;
    }

    public void setoi_price(Float oi_price) {
        this.oi_price = oi_price;
    }

    public Date getoi_pegtime() {
        return oi_pegtime;
    }

    public void setoi_pegtime(Date oi_pegtime) {
        this.oi_pegtime = oi_pegtime;
    }

    public Long getoi_position() {
        return oi_position;
    }

    public void setoi_position(Long oi_position) {
        this.oi_position = oi_position;
    }
}