package org.example.clientinfo.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ClientDTO {

    private Long idNumber;
    private String firstName;
    private String lastName;
    private String physicalAddress;
    private String mobileNumber;

}
