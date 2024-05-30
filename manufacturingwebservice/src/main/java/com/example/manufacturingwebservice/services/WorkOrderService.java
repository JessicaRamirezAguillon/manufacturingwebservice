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
        try {
            WorkOrder workOrder = modelMapper.map(workOrderDTO, WorkOrder.class);
            WorkOrder savedWorkOrder = workOrderRepository.save(workOrder);
            return convertToDto(savedWorkOrder);
        } catch (Exception e) {
            System.out.println("Objeto Nulo");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delete(int workOrderID) {
        workOrderRepository.deleteById(workOrderID);
    }

    private WorkOrderDTO convertToDto(WorkOrder workOrder) {
        return modelMapper.map(workOrder, WorkOrderDTO.class);
    }
}
