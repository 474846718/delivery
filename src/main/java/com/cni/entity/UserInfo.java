package com.cni.entity;

import java.io.Serializable;
public class UserInfo implements Serializable{
	
    /**  
     * @Fields serialVersionUID : 实体类版本序列化号 
     */   
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String username;
    private int age;
    private String birthday;
    private String resume;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
