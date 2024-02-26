package com.sas.SalesAnalysisSystem.service;
import java.util.List;
import java.util.Optional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Distributor;
import com.sas.SalesAnalysisSystem.model.Product;
import com.sas.SalesAnalysisSystem.model.Salesperson;
import com.sas.SalesAnalysisSystem.repository.DistributorRepository;
import com.sas.SalesAnalysisSystem.repository.ProductRepository;
import com.sas.SalesAnalysisSystem.repository.SalespersonRepository;


@Service
public class DistributorServiceImpl implements DistributorService {

    private final DistributorRepository distributorRepository;
    private final ProductRepository productRepository;
    private final SalespersonRepository salespersonRepository;


    @Autowired
	public DistributorServiceImpl(DistributorRepository distributorRepository, ProductRepository productRepository,
			SalespersonRepository salespersonRepository) {
		this.distributorRepository = distributorRepository;
		this.productRepository = productRepository;
		this.salespersonRepository = salespersonRepository;
	}

    
    @Override
    public Distributor createDistributor(Distributor distributor) {
        try {
        	 if (isValidEmail(distributor.getEmail())) {
                 return distributorRepository.save(distributor);
             } else {
                 throw new IllegalArgumentException("Invalid email address: " + distributor.getEmail());
             }
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("Error occurred while saving distributor", e);
        }
    }

    @Override
    public void addProductsToDistributor(int distributorId, List<Long> productIds) {
        Optional<Distributor> distributor = distributorRepository.findById(distributorId);

        if (!distributor.isPresent()) {
            throw new ResourceNotFoundException("Distributor not found with id: " + distributorId);
        }

        System.out.println(distributor);

        List<Product> products = productRepository.findAllById(productIds);

        if (products.size() != productIds.size()) {
            throw new IllegalArgumentException("Not all products with the given IDs were found");
        }
        if (distributor.isPresent()) {
            Distributor dist = distributor.get();
            dist.setProductList(products);
            distributorRepository.save(dist);
        }
    }

    @Override
	public Distributor updateDistributor(Integer id,Distributor distributor) {
        Optional<Distributor> distributorDb = distributorRepository.findById(id);
        if (distributorDb.isPresent()) {
            Distributor distributorUpdate = distributorDb.get();
            distributorUpdate.setAddress(distributor.getAddress());
            distributorUpdate.setState(distributor.getState());
            distributorUpdate.setAgencyName(distributor.getAgencyName());
            distributorUpdate.setContactPerson(distributor.getContactPerson());
            distributorUpdate.setContactNumber(distributor.getContactNumber());
            distributorUpdate.setEmail(distributor.getEmail());
            return distributorRepository.save(distributorUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + distributor.getDistributorId());
        }
    }

    @Override
    public List<Distributor> getAllDistributors() {
        try {
            List<Distributor> distributors = distributorRepository.findAll();
            if (distributors.isEmpty()) {
                throw new ResourceNotFoundException("No distributors found");
            }
            return distributors;
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("Error occurred while retrieving distributors", e);
        }
    }
    
    @Override
    public Distributor getDistributorById(Integer id) {
        Optional<Distributor> distributorDb = distributorRepository.findById(id);
        if (distributorDb.isEmpty()) {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
        return distributorDb.get();
    }
    
    @Override
    public void addSalespersonsToDistributor(int distributorId, List<Long> salespersonIds) {
        Optional<Distributor> distributor = distributorRepository.findById(distributorId);

        if (!distributor.isPresent()) {
            throw new ResourceNotFoundException("Distributor not found with id: " + distributorId);
        }

        System.out.println(distributor);
        List<Salesperson> salespersons = salespersonRepository.findAllById(salespersonIds);

        if (salespersons.size() != salespersonIds.size()) {
            throw new IllegalArgumentException("Not all salespersons with the given IDs were found");
        }

        if (distributor.isPresent()) {
            Distributor dist = distributor.get();
            dist.setSalespersons(salespersons);
            distributorRepository.save(dist);
        }
    }
    

    @Override
    public void deleteDistributor(int distributorId) {
        Optional<Distributor> distributorDb = distributorRepository.findById(distributorId);
        if (distributorDb.isPresent()) {
        	distributorRepository.delete(distributorDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + distributorId);
        }
    }

    private boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
	@Override
	public List<Product> getAllProducts(Integer id) {
		Optional<Distributor> distributorDb = distributorRepository.findById(id);
		if(distributorDb.isPresent()) {
			Distributor finddistributor =   distributorDb.get();
			   List<Product> allProducts = finddistributor.getProductList();
			   return allProducts;
		}
		else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
	}

	@Override
	public List<Salesperson> getAllSalesperson(Integer id) {
		Optional<Distributor> distributorDb = distributorRepository.findById(id);
		if(distributorDb.isPresent()) {
		   Distributor finddistributor =   distributorDb.get();
		   List<Salesperson> allSalesperson = finddistributor.getSalespersons();
		   return allSalesperson;
		}else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
	}

}
