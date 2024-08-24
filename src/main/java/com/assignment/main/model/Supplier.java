package com.assignment.main.model;



import com.assignment.main.choices.Location;
import com.assignment.main.choices.ManufacturingProcesses;
import com.assignment.main.choices.NatureofBusiness;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Supplier {
		
	@Id
	@GeneratedValue
	private int supplier_id ;
	private String company_name;
	private String website;
	
	@Enumerated(EnumType.STRING)
	private Location location;

	@Enumerated(EnumType.STRING)
	private NatureofBusiness nature_of_business ;
	
	@Enumerated(EnumType.STRING)
	private ManufacturingProcesses manufacturing_processes ;
	
	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public NatureofBusiness getNature_of_business() {
		return nature_of_business;
	}

	public void setNature_of_business(NatureofBusiness nature_of_business) {
		this.nature_of_business = nature_of_business;
	}

	public ManufacturingProcesses getManufacturing_processes() {
		return manufacturing_processes;
	}

	public void setManufacturing_processes(ManufacturingProcesses manufacturing_processes) {
		this.manufacturing_processes = manufacturing_processes;
	}

	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", company_name=" + company_name + ", website=" + website
				+ ", location=" + location + ", nature_of_business=" + nature_of_business + ", manufacturing_processes="
				+ manufacturing_processes + "]";
	}

	
}
