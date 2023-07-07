package com.example.controller;

import com.example.dto.request.EmployeeMovementRequest;
import com.example.dto.response.EmployeeMovementResponse;
import com.example.service.EmployeeMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empmovement")
@RequiredArgsConstructor
public class EmployeeMovementController {
    private final EmployeeMovementService empMovService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeMovementResponse> getAll(){
        return empMovService.getAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeMovementResponse getById(@PathVariable("id")int empMovId){
        return empMovService.getById(empMovId);
    }

    @DeleteMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeMovementResponse deactivate(@PathVariable("id")int empMovId){
        empMovService.delete(empMovId);
        return empMovService.getById(empMovId);
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody EmployeeMovementRequest request){
        empMovService.insert(request);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id")int empMovId,@RequestBody EmployeeMovementRequest request){
        empMovService.update(empMovId,request);
    }
}
