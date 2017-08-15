package com.sagarpayne.backend.persistence.domain.backend;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Role implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Role(){}
	
	@Id
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy= "role" , cascade = CascadeType.ALL,fetch= FetchType.EAGER)
	private Set<UserRole> userRoles = new HashSet<>();
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
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

	
	
	

}
