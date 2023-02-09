package org.example.clientinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_info")
public class Client {

    @Id
    @Column(name = "id_number", unique = true)
    @NotEmpty(message = "Id Number Must Not Be Null")
    @Size(min = 13, max = 13, message = "Id Length Must Be 13")
    private String idNumber;

    @NotEmpty(message = "First Name Must Not Be Null")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last Name Must Not Be Empty")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "physical_address")
    private String physicalAddress;

    @Column(name = "mobile_number", unique = true)
    private Long mobileNumber;
}
