package com.example.manufacturingwebservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manufacturingwebservice.dto.WorkOrderRoutingDTO;
import com.example.manufacturingwebservice.entities.WorkOrderRouting;
import com.example.manufacturingwebservice.entities.WorkOrderRoutingId;
import com.example.manufacturingwebservice.repositories.WorkOrderRoutingRepository;

@Service
public class WorkOrderRoutingService {
    @Autowired
    private WorkOrderRoutingRepository workOrderRoutingRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<WorkOrderRoutingDTO> getAll() {
        List<WorkOrderRouting> products = workOrderRoutingRepository.findAll();
        return products.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<WorkOrderRouting> getWorkOrderRoutingById(Integer workOrderID, Integer productID, Short operationSequence) {
        WorkOrderRoutingId id = new WorkOrderRoutingId(workOrderID, productID, operationSequence);
        return workOrderRoutingRepository.findById(id);
    }

    public WorkOrderRoutingDTO create(WorkOrderRoutingDTO workOrderDTO) {
        try {
            WorkOrderRouting workOrder = modelMapper.map(workOrderDTO, WorkOrderRouting.class);
            WorkOrderRouting savedWorkOrderRouting = workOrderRoutingRepository.save(workOrder);
            return convertToDto(savedWorkOrderRouting);
        } catch (Exception e) {
            System.out.println("Objeto Nulo");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delete(Integer workOrderID, Integer productID, Short operationSequence) {
        WorkOrderRoutingId id = new WorkOrderRoutingId(workOrderID, productID, operationSequence);
        workOrderRoutingRepository.deleteById(id);
    }

    public List<WorkOrderRoutingDTO> getAllByWorkOrderID(Integer workOrderID) {
        List<WorkOrderRouting> workOrders = workOrderRoutingRepository.findAllByWorkOrderID(workOrderID);
        return workOrders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private WorkOrderRoutingDTO convertToDto(WorkOrderRouting workOrder) {
        return modelMapper.map(workOrder, WorkOrderRoutingDTO.class);
    }
}
