package com.hyf.food.entity;

public class Menu {
    private Long m_id;

    private String m_name;

    private String m_img;

    private Float m_price;

    private Long m_num;

    private String m_type;

    private Long m_position;
    
    //临时存放用户选择的菜品数量
    private Long m_number = (long) 0;
    

    public Long getM_number() {
		return m_number;
	}

	public void setM_number(Long m_number) {
		this.m_number = m_number;
	}

	public Long getm_id() {
        return m_id;
    }

    public void setm_id(Long m_id) {
        this.m_id = m_id;
    }

    public String getm_name() {
        return m_name;
    }

    public void setm_name(String m_name) {
        this.m_name = m_name == null ? null : m_name.trim();
    }

    public String getm_img() {
        return m_img;
    }

    public void setm_img(String m_img) {
        this.m_img = m_img == null ? null : m_img.trim();
    }

    public Float getm_price() {
        return m_price;
    }

    public void setm_price(Float m_price) {
        this.m_price = m_price;
    }

    public Long getm_num() {
        return m_num;
    }

    public void setm_num(Long m_num) {
        this.m_num = m_num;
    }

    public String getm_type() {
        return m_type;
    }

    public void setm_type(String m_type) {
        this.m_type = m_type == null ? null : m_type.trim();
    }

    public Long getm_position() {
        return m_position;
    }

    public void setm_position(Long m_position) {
        this.m_position = m_position;
    }
}