package com.example.zaman_cizelgesi_sistemi.controller;

import com.example.zaman_cizelgesi_sistemi.dto.workHoursDto.WorkHoursRequest;
import com.example.zaman_cizelgesi_sistemi.dto.workHoursDto.WorkHoursResponse;
import com.example.zaman_cizelgesi_sistemi.service.WorkHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workhours")
public class WorkHoursController {
    @Autowired
    private WorkHoursService workHoursService;

    @PostMapping
    public WorkHoursResponse saveWorkHours(@RequestBody WorkHoursRequest request) {
        return workHoursService.saveWorkHours(request);
    }

    @GetMapping("/user/{userId}")
    public List<WorkHoursResponse> getWorkHoursByUserId(@PathVariable Long userId) {
        return workHoursService.getWorkHoursByUserId(userId);
    }
}
