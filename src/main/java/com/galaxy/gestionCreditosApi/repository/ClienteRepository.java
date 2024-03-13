package com.galaxy.gestionCreditosApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.galaxy.gestionCreditosApi.model.*;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
