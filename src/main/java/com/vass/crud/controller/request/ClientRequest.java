package com.vass.crud.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ClientRequest {

    @NotBlank
    private String name;
    @NotBlank
    @JsonProperty("lastname")
    private String lastName;
    @NotBlank
    private String identification;
    @NotBlank
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
}
