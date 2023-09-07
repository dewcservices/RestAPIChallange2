package com.softwareengineeringchallenge.restAPIchallge2.dto;

import lombok.AllArgsConstructor;

//local

//imported
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private Long id;
    private String name;
    private String description;

}

// validation logic
