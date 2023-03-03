package com.crescendo.service;

import com.crescendo.model.Business;
import java.util.List;

public interface IBusinessService {
	List<Business> findAll();
    Business findById(int id);
    Business save(Business business);
    Business update(Business business, int id);
    void deleteById(int id);
}
