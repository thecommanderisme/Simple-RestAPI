package com.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="members")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName cannot be null.");
        }
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
	
	@Column(name = "lastName")
	private String lastName;

	public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
	
	@Column(name = "email")
	private String email;
	
	public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }

}
