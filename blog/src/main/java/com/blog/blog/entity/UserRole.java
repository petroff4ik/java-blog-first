/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author petroff
 */
@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@Column(name = "user_role_id")
	private Integer userRoleId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", nullable = false)
	private com.blog.blog.entity.User user;
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	//getter and setter methods
}