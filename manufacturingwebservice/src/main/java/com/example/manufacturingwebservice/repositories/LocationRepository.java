package com.example.manufacturingwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manufacturingwebservice.entities.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Short> {}
