package com.somnus.apache;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
    
    private Date birthday;
    private BigDecimal money;
    
    private Pet pet;
    
    public Person() {
		super();
	}
	
	public Person(String username, String password, Date birthday,
			BigDecimal money, Pet pet) {
		super();
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.money = money;
		this.pet = pet;
	}
    
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {  
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);   
    }
	
	static class Pet  implements Serializable{
		private static final long serialVersionUID = 1L;
		
		private String name;
		
		public Pet(String name) {
			super();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		/*public String toString() {  
	    	return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);   
	    }*/
		
	}
}
