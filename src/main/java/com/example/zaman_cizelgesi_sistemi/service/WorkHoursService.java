package com.example.zaman_cizelgesi_sistemi.service;

import com.example.zaman_cizelgesi_sistemi.dto.workHoursDto.WorkHoursRequest;
import com.example.zaman_cizelgesi_sistemi.dto.workHoursDto.WorkHoursResponse;
import com.example.zaman_cizelgesi_sistemi.entity.User;
import com.example.zaman_cizelgesi_sistemi.entity.WorkHour;
import com.example.zaman_cizelgesi_sistemi.repositories.UserRepository;
import com.example.zaman_cizelgesi_sistemi.repositories.WorkHourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkHoursService {
    @Autowired
    private WorkHourRepository workHourRepository;

    @Autowired
    private UserRepository userRepository;

    public WorkHoursResponse saveWorkHours(WorkHoursRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        WorkHour workHour = new WorkHour();
        workHour.setUser(user);
        workHour.setStartTime(request.getStartTime());
        workHour.setEndTime(request.getEndTime());
        workHour.setDate(request.getDate());

        WorkHour savedWorkHour = workHourRepository.save(workHour);

        return convertToResponse(savedWorkHour);
    }

    public List<WorkHoursResponse> getWorkHoursByUserId(Long userId) {
        List<WorkHour> workHoursList = workHourRepository.findByUserId(userId);
        return workHoursList.stream().map(this::convertToResponse).collect(Collectors.toList());
    }

    private WorkHoursResponse convertToResponse(WorkHour workHour) {
        WorkHoursResponse response = new WorkHoursResponse();
        response.setId(workHour.getId());
        response.setUserId(workHour.getUser().getId());
        response.setStartTime(workHour.getStartTime());
        response.setEndTime(workHour.getEndTime());
        response.setDate(workHour.getDate());
        response.setTotalHours(Duration.between(workHour.getStartTime(), workHour.getEndTime()).toHours());

        return response;
    }
}
