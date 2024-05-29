package com.example.bufsroom.controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class AppCreateForm {
	@NotNull
	private Date startDate;
	@NotNull
	private String startTime;
	@NotNull
	private String endTime;
	@NotEmpty
	private String school;
	@NotEmpty
	private String classroom;
	@NotEmpty
	private String purpose;

}