package com.example.manufacturingwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manufacturingwebservice.entities.WorkOrder;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer>{}