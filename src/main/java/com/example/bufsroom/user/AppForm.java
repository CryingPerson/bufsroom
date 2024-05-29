package com.example.bufsroom.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@Entity
public class AppForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date start_date;
    private String start_time;
    private String end_time;
    private String _school;
    private String _classroom;
    private String _purpose;
}
