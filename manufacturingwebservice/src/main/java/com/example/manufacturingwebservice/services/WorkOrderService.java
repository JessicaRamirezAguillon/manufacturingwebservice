package com.example.manufacturingwebservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manufacturingwebservice.dto.WorkOrderDTO;
import com.example.manufacturingwebservice.entities.WorkOrder;
import com.example.manufacturingwebservice.repositories.WorkOrderRepository;

@Service
public class WorkOrderService {
    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<WorkOrderDTO> getAll() {
        List<WorkOrder> products = workOrderRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<WorkOrder> getWorkOrderById(int workOrderID) {
        return workOrderRepository.findById(workOrderID);
    }

    public WorkOrderDTO create(WorkOrderDTO workOrderDTO) {
        WorkOrder workOrder = modelMapper.map(workOrderDTO, WorkOrder.class);
        WorkOrder savedWorkOrder = workOrderRepository.save(workOrder);
        return convertToDto(savedWorkOrder);
    }

    public Optional<WorkOrderDTO> update(int workOrderID, WorkOrderDTO workOrderDTO) {
        return workOrderRepository.findById(workOrderID).map(existingWorkOrder -> {
            existingWorkOrder.setProductID(workOrderDTO.getProductID());
            existingWorkOrder.setOrderQty(workOrderDTO.getOrderQty());
            // existingWorkOrder.setStockedQty(workOrderDTO.getStockedQty()); // Exclude this line
            existingWorkOrder.setScrappedQty(workOrderDTO.getScrappedQty());
            existingWorkOrder.setStartDate(workOrderDTO.getStartDate());
            existingWorkOrder.setEndDate(workOrderDTO.getEndDate());
            existingWorkOrder.setDueDate(workOrderDTO.getDueDate());
            existingWorkOrder.setScrapReasonID(workOrderDTO.getScrapReasonID());
            existingWorkOrder.setModifiedDate(workOrderDTO.getModifiedDate());
            WorkOrder updatedWorkOrder = workOrderRepository.save(existingWorkOrder);
            return convertToDto(updatedWorkOrder);
        });
    }

    public void delete(int workOrderID) {
        workOrderRepository.deleteById(workOrderID);
    }

    private WorkOrderDTO convertToDto(WorkOrder workOrder) {
        return modelMapper.map(workOrder, WorkOrderDTO.class);
    }
}
