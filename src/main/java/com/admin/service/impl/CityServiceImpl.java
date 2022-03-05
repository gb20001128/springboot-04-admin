package com.admin.service.impl;

import com.admin.bean.City;
import com.admin.mapper.CitysMapper;
import com.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CitysMapper cityMapper;

    Counter counter;

    /*使用指标注册,将名为cityService.insertCity.count的指标注册进去,当调用insert方法时,次数就会加1
    * 输http://localhost:8080/actuator/metrics/cityService.insertCity.count就可以看到调用的次数和其他信息 */
    public CityServiceImpl(MeterRegistry meterRegistry){
        counter=meterRegistry.counter("cityService.insertCity.count");
    }
    @Override
    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public void insert(City city) {
        counter.increment();//加1
     cityMapper.insert(city);
    }
}
