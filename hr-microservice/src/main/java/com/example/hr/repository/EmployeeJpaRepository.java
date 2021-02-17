package com.example.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr.orm.EmployeeEntity;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, String> {
	List<EmployeeEntity> findByBirthYearBetween(int fromYear, int toYear);
}
