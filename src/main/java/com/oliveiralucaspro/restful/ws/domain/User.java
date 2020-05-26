package com.oliveiralucaspro.restful.ws.domain;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Integer id;
    
    @Size(min = 2, message = "Name should have at least 2 characters.")
    private String name;
    
    @Past
    private Date birthDate;

}
