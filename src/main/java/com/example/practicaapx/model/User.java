package com.example.practicaapx.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	private  @Id Long id;
	  private String email;
	  private String first_name;
	  private String last_name;
	  private String avatar;

	  User() {}

	  public User(String email, String first_name, String last_name, String avatar) {

	    this.email = email;
	    this.first_name = first_name;
	    this.last_name = last_name;
	    this.avatar = avatar;
	  }

	  public Long getId() {
	    return this.id;
	  }

	  public String getFirstName() {
	    return this.first_name;
	  }

	  public String getLastName() {
	    return this.last_name;
	  }

	  public String getEmail() {
	    return this.email;
	  }

	  public String getAvatar() {
	    return this.avatar;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public void setFirstName(String first_name) {
	    this.first_name = first_name;
	  }

	  public void setLastName(String last_name) {
	    this.last_name = last_name;
	  }
	  
	    public void setEmail(String email) {
	    this.email = email;
	  }

	  public void setAvatar(String avatar) {
	    this.avatar = avatar;
	  }
}
