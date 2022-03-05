package com.admin.service;

import com.admin.bean.City;

public interface CityService {
     City getCityById(Long id);
     void insert(City city);
}
