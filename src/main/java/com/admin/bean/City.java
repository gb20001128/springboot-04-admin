package com.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    private Long id;
    private String name;
    private String state;
    private String country;
}
