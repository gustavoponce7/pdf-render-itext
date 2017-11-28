package com.gpch.pdfrender.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	long id;
	@NonNull
	String name;
	@NonNull
	String lastName;
	@NonNull
	String phone;
}
