package com.andres.SpringREST_restaurante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.SpringREST_restaurante.entities.Provider;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

}
