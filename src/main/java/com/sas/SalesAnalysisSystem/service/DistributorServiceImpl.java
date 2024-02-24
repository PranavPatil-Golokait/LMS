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


@Service
public class DistributorServiceImpl implements DistributorService {

    private final DistributorRepository distributorRepository;

    @Autowired
    public DistributorServiceImpl(DistributorRepository distributorRepository) {
        this.distributorRepository = distributorRepository;
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
    public void deleteDistributor(int distributorId) {
        Optional<Distributor> distributorDb = distributorRepository.findById(distributorId);
        if (distributorDb.isPresent()) {
        	distributorRepository.delete(distributorDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + distributorId);
        }
    }
//    private void validateDistributor(Distributor distributor) {
//        if (distributor == null) {
//            throw new ResourceNotFoundException("Distributor cannot be null");
//        }
//
//        if (StringUtils.isBlank(distributor.getAgencyName())) {
//            throw new ResourceNotFoundException("Agency Name cannot be blank or null");
//        }
//
//        if (StringUtils.isBlank(distributor.getAddress())) {
//            throw new ResourceNotFoundException("Address cannot be blank or null");
//        }
//
//        if (StringUtils.isBlank(distributor.getState())) {
//            throw new ResourceNotFoundException("State cannot be blank or null");
//        }
//
//        if (StringUtils.isBlank(distributor.getContactPerson())) {
//            throw new ResourceNotFoundException("Contact Person cannot be blank or null");
//        }
//
//        if (StringUtils.isBlank(distributor.getContactNumber())) {
//            throw new ResourceNotFoundException("Contact Number cannot be blank or null");
//        }
//
//        if (StringUtils.isBlank(distributor.getEmail()) || !isValidEmail(distributor.getEmail())) {
//            throw new ResourceNotFoundException("Invalid or blank email");
//        }
//    }
//
    

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
			   List<Product> allProducts = finddistributor.getProducts();
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
