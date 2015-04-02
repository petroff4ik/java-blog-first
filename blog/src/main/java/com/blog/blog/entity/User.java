/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.entity;

import com.blog.blog.validator.Repassword;
import com.blog.blog.validator.Uniq;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author petroff
 */
@Entity
@Table(name = "users")
@Repassword(pass = "password", repass = "repassword")
@Uniq(uniq_field = "username")
@Component
@Scope("session")
public class User implements Serializable {

	@Id
	@NotNull
	@Size(min = 2, max = 64)
	@Column(name = "username")
	private String username;
	@NotNull
	@Size(min = 2, max = 64)
	@Column(name = "password")
	private String password;
	@Email
	@Column(name = "email")
	private String email;
	@NotEmpty
	@Column(name = "profile")
	private String profile;
	@Transient
	private String repassword;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")//ttt
	private Set<UserRole> userRole;

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public User(String username, String password, String email, String profile) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.profile = profile;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
	}
}
