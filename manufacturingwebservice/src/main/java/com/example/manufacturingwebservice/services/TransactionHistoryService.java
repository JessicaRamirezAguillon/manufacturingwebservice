package com.example.manufacturingwebservice.services;

import com.example.manufacturingwebservice.dto.TransactionHistoryDTO;
import com.example.manufacturingwebservice.entities.TransactionHistory;
import com.example.manufacturingwebservice.repositories.TransactionHistoryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TransactionHistoryDTO> getAll() {
        List<TransactionHistory> transactionHistories = transactionHistoryRepository.findAll();
        return transactionHistories.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<TransactionHistoryDTO> getById(Integer transactionID) {
        Optional<TransactionHistory> transactionHistory = transactionHistoryRepository.findById(transactionID);
        return transactionHistory.map(this::convertToDto);
    }

    public TransactionHistoryDTO create(TransactionHistoryDTO transactionHistoryDTO) {
        TransactionHistory transactionHistory = modelMapper.map(transactionHistoryDTO, TransactionHistory.class);
        TransactionHistory savedTransactionHistory = transactionHistoryRepository.save(transactionHistory);
        return convertToDto(savedTransactionHistory);
    }

    public TransactionHistoryDTO update(Integer transactionID, TransactionHistoryDTO transactionHistoryDTO) {
        Optional<TransactionHistory> optionalTransactionHistory = transactionHistoryRepository.findById(transactionID);
        if (optionalTransactionHistory.isPresent()) {
            TransactionHistory transactionHistory = optionalTransactionHistory.get();
            modelMapper.map(transactionHistoryDTO, transactionHistory);
            TransactionHistory updatedTransactionHistory = transactionHistoryRepository.save(transactionHistory);
            return convertToDto(updatedTransactionHistory);
        } else {
            return null;
        }
    }

    public void delete(Integer transactionID) {
        transactionHistoryRepository.deleteById(transactionID);
    }

    private TransactionHistoryDTO convertToDto(TransactionHistory transactionHistory) {
        return modelMapper.map(transactionHistory, TransactionHistoryDTO.class);
    }
}
