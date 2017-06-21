package com.stackroute.activity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name ="user")
public class User extends BaseDomain{
	
	@Id
	private String id;
	private String name;
	private String password;
	private String role;
	private boolean enabled;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;

	        User user = (User) o;

	        if (id != user.id) return false;
	        if (name != null ? !name.equals(user.name) : user.name != null) return false;

	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int result =10;
	        result = 31 * result + (name != null ? name.hashCode() : 0);
	        return result;
	    }
	

}
