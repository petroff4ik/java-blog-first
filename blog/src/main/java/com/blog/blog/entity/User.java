/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.entity;

import com.blog.blog.validator.Repassword;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author petroff
 */
@Entity
@Table(name = "tbl_user")
@Repassword(pass = "password", repass = "repassword")
public class User {

	@Id
	@Column(name = "id")
	private int id;
	@NotNull
	@Size(min = 2, max = 64)
	@Column(name = "username")
	private String username;
	@NotNull
	@Size(min = 2, max = 64)
	@Column(name = "password")
	private String password;
	@Column(name = "salt")
	private String salt;
	@Email
	@Column(name = "email")
	private String email;
	@NotEmpty
	@Column(name = "profile")
	private String profile;
	private String repassword;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<UserRole> userRole;

	public Set<UserRole> getUserRole() {
		return userRole;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
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

	public User(int id, String username, String password, String salt, String email, String profile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
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
