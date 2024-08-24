package com.assignment.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assignment.main.choices.Location;
import com.assignment.main.choices.ManufacturingProcesses;
import com.assignment.main.choices.NatureofBusiness;
import com.assignment.main.dao.SupplierRepository;
import com.assignment.main.model.Supplier;


@Service
public class SupplierService {
	
	@Autowired
	SupplierRepository dao;
	
	
	public Page<Supplier> findSuppliers(Location location, NatureofBusiness nature_of_business, ManufacturingProcesses manufacturing_processes, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return dao.findSuppliers(location, nature_of_business, manufacturing_processes, pageable);
    }
	
	public Supplier saveSupplier(Supplier supplier) {
        return dao.save(supplier);
    }
	
	public Page<Supplier> findAllSuppliers(int page, int size) {
        return dao.findAll(PageRequest.of(page, size));
    }
}
