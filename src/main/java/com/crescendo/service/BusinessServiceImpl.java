package com.crescendo.service;

import com.crescendo.exception.BusinessNotFoundException;
import com.crescendo.model.Business;
import com.crescendo.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements IBusinessService {
    private final BusinessRepository repository;

    @Autowired
    public BusinessServiceImpl(BusinessRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Business> findAll() {
        return repository.findAll();
    }

    @Override
    public Business findById(int id) {
        Optional<Business> businessOptional = repository.findById(id);

        if(businessOptional.isPresent()) {
            return businessOptional.get();
        }
        else {
            throw new BusinessNotFoundException(id);
        }
    }

    @Override
    public Business save(Business business) {
        return repository.save(business);
    }

    @Override
    public Business update(Business business, int id) {
        Optional<Business> optional = repository.findById(id);
        Business businessToUpdate;
        if(optional.isPresent()) {
            businessToUpdate = optional.get();
            businessToUpdate.setBusinessName(business.getBusinessName());
            businessToUpdate.setAddress(business.getAddress());
            businessToUpdate.setPhone(business.getPhone());
            return repository.save(businessToUpdate);
        }
        else {
            throw new BusinessNotFoundException(id);
        }
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
