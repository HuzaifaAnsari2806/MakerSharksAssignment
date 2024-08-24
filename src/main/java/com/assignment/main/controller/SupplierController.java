package com.assignment.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.main.choices.Location;
import com.assignment.main.choices.ManufacturingProcesses;
import com.assignment.main.choices.NatureofBusiness;
import com.assignment.main.model.Supplier;
import com.assignment.main.service.SupplierService;



@RestController
@RequestMapping("api/supplier/")
public class SupplierController {
	
	@Autowired
	SupplierService service;
	
	@GetMapping("/")
    public Page<Supplier> getSuppliers(
            @RequestParam(required = false) Location location,
            @RequestParam(required = false) NatureofBusiness nature_of_business,
            @RequestParam(required = false) ManufacturingProcesses manufacturing_processes,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

		if (location == null && nature_of_business == null && manufacturing_processes == null) {
            // No parameters, return all suppliers
            return service.findAllSuppliers(page, size);
        } else {
            // Some parameters provided, return filtered suppliers
            return service.findSuppliers(location, nature_of_business, manufacturing_processes, page, size);
        }
    }
	
	@PostMapping("/query")
	public ResponseEntity<Supplier> addSuppliers(
            @RequestBody Supplier supplier) {
		Supplier supplier1=service.saveSupplier(supplier);
        return new ResponseEntity<>(supplier1,HttpStatus.CREATED);
    }
}
