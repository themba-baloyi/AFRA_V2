package com.afra.facade.departments;

import com.afra.entities.DepartmentsEntities;
import com.afra.services.departments.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/afra/department")
public class DepartmentController implements Department{
    @Autowired
    DepartmentServiceImpl service;


    @CrossOrigin
    @Override
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentsEntities>> getAllDepartments() {
        return service.getAllDepartments();
    }

    @CrossOrigin
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentsEntities> getDepartmentById(@PathVariable String id) {
        return service.getDepartmentById(id);
    }

    @CrossOrigin
    @Override
    @PostMapping("/create")
    public ResponseEntity<DepartmentsEntities> createDepartment(@RequestBody DepartmentsEntities department) {
        return service.createDepartment(department);
    }

    @CrossOrigin
    @Override
    @PutMapping("/update")
    public ResponseEntity<DepartmentsEntities> updateDepartment(@RequestBody DepartmentsEntities department) {
        return service.updateDepartment(department);
    }

    @CrossOrigin
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDepartment(@PathVariable String id) {
        return service.deleteDepartment(id);
    }
}
