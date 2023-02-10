package com.springboot.app.ams.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity

public class Article {
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
	private long id ;
@NotBlank(message="label in valid")
@Column(name="label")
private String label ;

@Column(name = "price")
public float price;


public Article() {}

public Article(String label ,float price) {
	this.label=label;
	this.price=price;
}

public void setId(long id) {
	this.id=id;
}

public  long getId() {
	return id ;
}

public String getLabel() {
	return label ;
}

public void  setLabel(String label) {
	this.label=label;
}
public float getprice() {
	return price ;
}

public void  setprice(float price) {
	this.price=price;
}
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "provider_id", nullable = false)
@OnDelete(action = OnDeleteAction.CASCADE)
private Provider provider;


public Provider getProvider() {
	return provider;
}
public void setProvider(Provider provider) {
	this.provider=provider;
}
}
