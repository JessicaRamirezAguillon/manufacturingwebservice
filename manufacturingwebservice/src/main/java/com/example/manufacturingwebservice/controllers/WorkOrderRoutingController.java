package com.example.manufacturingwebservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.manufacturingwebservice.dto.WorkOrderRoutingDTO;
import com.example.manufacturingwebservice.entities.WorkOrderRouting;
import com.example.manufacturingwebservice.services.WorkOrderRoutingService;

@RestController
@RequestMapping(path = "/workorderroutes")
public class WorkOrderRoutingController {
    @Autowired
    WorkOrderRoutingService workOrderService;

    @GetMapping("")
    public List<WorkOrderRoutingDTO> getWorkOrderRoutings() {
        return workOrderService.getAll();
    }
    
    @GetMapping("/{workOrderID}/{productID}/{operationSequence}")
    public ResponseEntity<WorkOrderRouting> getWorkOrderRoutingById(
            @PathVariable Integer workOrderID,
            @PathVariable Integer productID,
            @PathVariable Short operationSequence) {
        Optional<WorkOrderRouting> workOrder = workOrderService.getWorkOrderRoutingById(workOrderID, productID, operationSequence);
        return workOrder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/workorder/{workOrderID}")
    public List<WorkOrderRoutingDTO> getAllByWorkOrderID(@PathVariable Integer workOrderID) {
        return workOrderService.getAllByWorkOrderID(workOrderID);
    }
    
    @PostMapping("")
    public ResponseEntity<WorkOrderRoutingDTO> createWorkOrderRouting(@RequestBody WorkOrderRoutingDTO workOrderDTO) {
        WorkOrderRoutingDTO createdWorkOrderRouting = workOrderService.create(workOrderDTO);
        return ResponseEntity.ok(createdWorkOrderRouting);
    }

    @DeleteMapping("/{workOrderID}/{productID}/{operationSequence}")
    public ResponseEntity<Void> deleteWorkOrderRouting(
            @PathVariable Integer workOrderID,
            @PathVariable Integer productID,
            @PathVariable Short operationSequence) {
        workOrderService.delete(workOrderID, productID, operationSequence);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{workOrderID}/{productID}/{operationSequence}")
    public ResponseEntity<WorkOrderRoutingDTO> updateWorkOrderRouting(
            @PathVariable Integer workOrderID,
            @PathVariable Integer productID,
            @PathVariable Short operationSequence,
            @RequestBody WorkOrderRoutingDTO workOrderDTO) {
        Optional<WorkOrderRouting> optionalWorkOrder = workOrderService.getWorkOrderRoutingById(workOrderID, productID, operationSequence);
        if (optionalWorkOrder.isPresent()) {
            WorkOrderRouting workOrder = optionalWorkOrder.get();
            workOrder.setLocationID(workOrderDTO.getLocationID());
            workOrder.setScheduledStartDate(workOrderDTO.getScheduledStartDate());
            workOrder.setScheduledEndDate(workOrderDTO.getScheduledEndDate());
            workOrder.setActualStartDate(workOrderDTO.getActualStartDate());
            workOrder.setActualEndDate(workOrderDTO.getActualEndDate());
            workOrder.setActualResourceHrs(workOrderDTO.getActualResourceHrs());
            workOrder.setPlannedCost(workOrderDTO.getPlannedCost());
            workOrder.setActualCost(workOrderDTO.getActualCost());
            workOrder.setModifiedDate(workOrderDTO.getModifiedDate());
            
            WorkOrderRoutingDTO updatedWorkOrderRouting = workOrderService.create(workOrderDTO);
            return ResponseEntity.ok(updatedWorkOrderRouting);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
