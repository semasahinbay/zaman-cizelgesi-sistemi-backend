package com.example.zaman_cizelgesi_sistemi.repositories;

import com.example.zaman_cizelgesi_sistemi.entity.WorkHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkHourRepository extends JpaRepository<WorkHour, Long> {
    List<WorkHour> findByUserId(Long userId);
}
