package com.example.jpa2;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Person {
	@Id
	private Integer personId;
	private String firstName;
	private String lastName;
	private Integer age;
}
