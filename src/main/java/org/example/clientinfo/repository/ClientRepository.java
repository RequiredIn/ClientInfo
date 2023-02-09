package org.example.clientinfo.repository;

import org.example.clientinfo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {

    Boolean existsByMobileNumber(Long mobileNumber);

    Optional<Client> findByMobileNumber(Long mobileNumber);
    Optional<Client> findById(String idNumber);

    Optional<Client> findByFirstName(String firstName);


}
