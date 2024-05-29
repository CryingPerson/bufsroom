package com.example.bufsroom.controller;

import com.example.bufsroom.service.AppService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Controller
@RequestMapping("/app")
public class AppController {

    private final AppService appService;

    @GetMapping("/form")
    public String showForm(AppCreateForm appCreateForm) {

        return "page3";
    }


    @PostMapping("/form")
    public String createApp(@Valid AppCreateForm appCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "page3";
        }
        try {
            appService.createApp(appCreateForm.getStartDate(), appCreateForm.getStartTime(), appCreateForm.getEndTime(), appCreateForm.getSchool(), appCreateForm.getClassroom(), appCreateForm.getPurpose());

            return "redirect:/app/form";

        } catch (Exception e) {

            return "page3";
        }

    }


}
