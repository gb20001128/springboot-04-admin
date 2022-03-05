package com.admin.mapper;
//一个Mapper可以注解和配置文件混合使用
import com.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CitysMapper {

    @Select("select * from city where id=#{id}")
    City getCityById(Long id);


//   @Insert("insert into city(name,state,country) values (#{name},#{state},#{country})"):sql语句
//   @Options(useGeneratedKeys = true,keyProperty = "id"):设置项(这两个注解等同于在xml文件里的配置)
    void insert(City city);

}
