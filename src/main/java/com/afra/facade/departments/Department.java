package com.afra.facade.departments;

import com.afra.entities.DepartmentsEntities;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Department {
    ResponseEntity<List<DepartmentsEntities>> getAllDepartments();
    ResponseEntity<DepartmentsEntities> getDepartmentById(String id);
    ResponseEntity<DepartmentsEntities> createDepartment(DepartmentsEntities department);
    ResponseEntity<DepartmentsEntities> updateDepartment(DepartmentsEntities department);
    ResponseEntity deleteDepartment(String id);
}
