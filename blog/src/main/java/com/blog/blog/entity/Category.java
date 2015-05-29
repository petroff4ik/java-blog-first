/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.blog.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

/**
 *
 * @author petroff
 */
@Entity
@Table(name = "category")
@FilterDef(name = "currentLang", parameters = {
	@ParamDef(name = "lang", type = "string")
})
public class Category implements Serializable {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "dt")
	private String dt;
	@Column(name = "enable", length = 5)
	private String enable;
	@OneToOne()
	@Filter(name = "currentLang", condition = ":lang = lang")
	@JoinColumn(name = "context_id", nullable = false, updatable = false, referencedColumnName = "link")
	private Context context;

	public int getId() {
		return id;//test
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Category() {
	}

	public Category(String dt, String enable) {
		this.dt = dt;
		this.enable = enable;
	}
}
