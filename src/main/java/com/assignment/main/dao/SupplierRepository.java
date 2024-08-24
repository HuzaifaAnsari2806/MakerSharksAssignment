package com.assignment.main.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment.main.choices.Location;
import com.assignment.main.choices.ManufacturingProcesses;
import com.assignment.main.choices.NatureofBusiness;
import com.assignment.main.model.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	@Query("SELECT s FROM Supplier s WHERE s.location = :location AND s.nature_of_business = :nature_of_business AND s.manufacturing_processes = :manufacturing_processes")
    Page<Supplier> findSuppliers(@Param("location") Location location,
                                 @Param("nature_of_business") NatureofBusiness nature_of_business,
                                 @Param("manufacturing_processes") ManufacturingProcesses manufacturing_processes,
                                 Pageable pageable);
}
