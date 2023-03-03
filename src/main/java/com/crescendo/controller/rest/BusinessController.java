package com.crescendo.controller.rest;

import com.crescendo.model.Business;
import com.crescendo.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusinessController {
    private final IBusinessService businessService;

    @Autowired
    public BusinessController(IBusinessService businessService) {
        this.businessService = businessService;
    }

    // get all businesses
    @GetMapping("/api/businesses")
    public List<Business> businessList() {
        return businessService.findAll();
    }

    // get by id
    @GetMapping("/api/businesses/{id}")
    public Business business(@PathVariable int id) {
        return businessService.findById(id);
    }

    // create business
    @PostMapping("/api/businesses")
    public Business add(@RequestBody Business business) {
        return businessService.save(business);
    }

    // update business
    @PutMapping("/api/businesses/{id}")
    public Business update(@RequestBody Business business, @PathVariable int id) {
        return businessService.update(business, id);
    }

    // delete business
    @DeleteMapping("/api/businesses/{id}")
    public void delete(@PathVariable int id) {
        businessService.deleteById(id);
    }

}
