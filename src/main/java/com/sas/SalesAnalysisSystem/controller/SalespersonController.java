package com.sas.SalesAnalysisSystem.controller;
import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Salesperson;
import com.sas.SalesAnalysisSystem.service.SalespersonService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
public class SalespersonController {
    private final SalespersonService salespersonService;

    @Autowired
    public SalespersonController(SalespersonService salespersonService) {
        this.salespersonService = salespersonService;
    }

    @GetMapping("/salespersons")
    public ResponseEntity<Object> getAllSalespersons() {
        try {
            List<Salesperson> salespersons = salespersonService.getAllSalespersons();
            return ResponseEntity.ok().body(salespersons);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No salespersons found");
        }
    }

    @GetMapping("/salespersons/{id}")
    public ResponseEntity<Object> getSalespersonById(@PathVariable("id") Integer id) {
        try {
            Salesperson salesperson = salespersonService.getSalespersonById(id);
            return ResponseEntity.ok().body(salesperson);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/salespersons")
    public ResponseEntity<Object> createSalesperson(@Valid @RequestBody Salesperson salesperson) {
        try {
            Salesperson createdSalesperson = salespersonService.createSalesperson(salesperson);
            return ResponseEntity.ok().body(createdSalesperson);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/salespersons/{id}")
    public ResponseEntity<Object> updateSalesperson(@PathVariable("id") Integer id, @Valid @RequestBody Salesperson salesperson) {
        try {
            Salesperson updatedSalesperson = salespersonService.updateSalesperson(id, salesperson);
            return ResponseEntity.ok().body(updatedSalesperson);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/salespersons/{id}")
    public HttpStatus deleteSalesperson(@PathVariable("id") Integer id) {
        this.salespersonService.deleteSalesperson(id);
        return HttpStatus.OK;
    }
}
