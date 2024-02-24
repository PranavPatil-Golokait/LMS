package com.sas.SalesAnalysisSystem.controller;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Distributor;
import com.sas.SalesAnalysisSystem.model.Product;
import com.sas.SalesAnalysisSystem.model.Salesperson;
import com.sas.SalesAnalysisSystem.service.DistributorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/distributors")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;

    @GetMapping("/all")
    public ResponseEntity<Object> getAllDistributors() {       
        try {
        	 List<Distributor> distributors = distributorService.getAllDistributors();
        	 return ResponseEntity.ok().body(distributors);
	    } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No distributor found");
        }
    }
    
    @GetMapping("{id}/all-products")
    public ResponseEntity<Object> getAllProducts(@PathVariable("id") Integer id){
    	try {
    		List<Product> products=distributorService.getAllProducts(id);
    		return ResponseEntity.ok().body(products);
    	}
    	catch(ResourceNotFoundException e){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found for this distributor");
    	}
    	
    }
    
    @GetMapping("{id}/all-salesperson")
    public ResponseEntity<Object> getAllSalesperson(@PathVariable("id") Integer id){
    	try {
    		List<Salesperson> salesperson=distributorService.getAllSalesperson(id);
    		return ResponseEntity.ok().body(salesperson);
    	}
    	catch(ResourceNotFoundException e){
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Salesperson found for this distributor");
    	}
    	
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<Object> getDistributorById(@PathVariable("id") Integer id) {
        try {
        	Distributor distributor = distributorService.getDistributorById(id);
            return ResponseEntity.ok().body(distributor);
        } catch (ResourceNotFoundException e) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
	
    @PostMapping("/add-distributor")
    public ResponseEntity<Object> createDistributor(@Valid @RequestBody Distributor distributor) {
        try {
        	Distributor createdDistributor = distributorService.createDistributor(distributor);
            return new ResponseEntity<>(createdDistributor, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    @PutMapping("/update-distributor/{id}")
    public ResponseEntity<Object> updateDistributor(@PathVariable("id") Integer id, @Valid @RequestBody Distributor distributor) {
        try {
			 Distributor updatedDistributor = distributorService.updateDistributor(id,distributor);
			 return ResponseEntity.ok().body(updatedDistributor);
	        } catch (ResourceNotFoundException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
    }

    @DeleteMapping("/delete-distributor/{id}")
    public HttpStatus deleteDistributor(@PathVariable("id") Integer id) {
        this.distributorService.deleteDistributor(id);
        return HttpStatus.OK;
    }
}
