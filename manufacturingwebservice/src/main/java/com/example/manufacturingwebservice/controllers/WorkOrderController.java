package com.example.manufacturingwebservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manufacturingwebservice.entities.WorkOrder;
import com.example.manufacturingwebservice.dto.WorkOrderDTO;
import com.example.manufacturingwebservice.services.WorkOrderService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/workorders")
public class WorkOrderController {
    @Autowired
    WorkOrderService workOrderService;

    @GetMapping("")
    public List<WorkOrderDTO> getWorkOrders() {
        return workOrderService.getAll();
    }
    

    @GetMapping("/{workOrderID}")
    public ResponseEntity<WorkOrder> getWorkOrderById(@PathVariable int workOrderID) {
        Optional<WorkOrder> workOrder = workOrderService.getWorkOrderById(workOrderID);
        return workOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("")
    public ResponseEntity<WorkOrderDTO> createWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
        WorkOrderDTO createdWorkOrder = workOrderService.create(workOrderDTO);
        return ResponseEntity.ok(createdWorkOrder);
    }

    @DeleteMapping("/{workOrderID}")
    public ResponseEntity<Void> deleteWorkOrder(@PathVariable int workOrderID) {
        workOrderService.delete(workOrderID);
        return ResponseEntity.noContent().build();
    }
}
