package com.example.manufacturingwebservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manufacturingwebservice.entities.WorkOrderRouting;
import com.example.manufacturingwebservice.entities.WorkOrderRoutingId;

import java.util.List;

@Repository
public interface WorkOrderRoutingRepository extends JpaRepository<WorkOrderRouting, WorkOrderRoutingId> {
    List<WorkOrderRouting> findAllByWorkOrderID(Integer workOrderID);
}
