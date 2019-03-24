package com.hyf.food.entity;

import java.util.Date;
import java.util.List;

public class Orderitems {
    private Long os_id;

    private Long d_id;

    private Float os_allprice;

    private Long os_position;

    private Date os_regtime;
    
    private List<Orderitem> oiList;
    
    

    public List<Orderitem> getOiList() {
		return oiList;
	}

	public void setOiList(List<Orderitem> oiList) {
		this.oiList = oiList;
	}

	public Long getos_id() {
        return os_id;
    }

    public void setos_id(Long os_id) {
        this.os_id = os_id;
    }

    public Long getd_id() {
        return d_id;
    }

    public void setd_id(Long d_id) {
        this.d_id = d_id;
    }

    public Float getos_allprice() {
        return os_allprice;
    }

    public void setos_allprice(Float os_allprice) {
        this.os_allprice = os_allprice;
    }

    public Long getos_position() {
        return os_position;
    }

    public void setos_position(Long os_position) {
        this.os_position = os_position;
    }

    public Date getos_regtime() {
        return os_regtime;
    }

    public void setos_regtime(Date os_regtime) {
        this.os_regtime = os_regtime;
    }

	@Override
	public String toString() {
		return "Orderitems [os_id=" + os_id + ", d_id=" + d_id
				+ ", os_allprice=" + os_allprice + ", os_position="
				+ os_position + ", os_regtime=" + os_regtime + ", oiList="
				+ oiList + "]";
	}
    
    
}