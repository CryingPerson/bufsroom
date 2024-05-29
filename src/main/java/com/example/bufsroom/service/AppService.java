package com.example.bufsroom.service;


import com.example.bufsroom.controller.AppCreateForm;
import com.example.bufsroom.repository.AppRepository;
import com.example.bufsroom.user.AppForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;

@RequiredArgsConstructor
@Service
public class AppService {

    private final AppRepository appRepository;

    public AppForm createApp(Date startDate, String startTime, String endTime, String school,String classroom, String purpose) {
            // 클라이언트로부터 전달받은 폼 데이터를 이용하여 예약 정보 생성
            AppForm appForm = new AppForm();
            appForm.setStart_date(startDate);
            appForm.setStart_time(startTime);
            appForm.setEnd_time(endTime);
            appForm.set_school(school);
            appForm.set_classroom(classroom);
            appForm.set_purpose(purpose);
            this.appRepository.save(appForm);

            return appForm;
}
}

