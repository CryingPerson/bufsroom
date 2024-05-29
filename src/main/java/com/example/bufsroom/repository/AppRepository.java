package com.example.bufsroom.repository;
import com.example.bufsroom.user.AppForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<AppForm, Long> {

}