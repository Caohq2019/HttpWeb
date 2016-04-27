package com.mysky.company.entity;

import java.io.Serializable;
import java.sql.Date;

public class staffBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7326965723621257126L;
	
	private int id;
	private String name;
	private Date birthday;
	private String sex;
	private String love;
	private int seID;
	
	public staffBean(){}
	public staffBean(int id,String name,Date date,String sex,String love,int seID)
	{
		this.id=id;
		this.name=name;
		this.birthday=date;
		this.sex=sex;
		this.love=love;
		this.seID=seID;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLove() {
		return love;
	}
	public void setLove(String love) {
		this.love = love;
	}
	public int getSeID() {
		return seID;
	}
	public void setSeID(int seID) {
		this.seID = seID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
