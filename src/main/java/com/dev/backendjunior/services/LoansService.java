package com.dev.backendjunior.services;

import com.dev.backendjunior.dto.CustomerRequestDTO;
import com.dev.backendjunior.dto.LoansResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LoansService {

    public List<LoansResponseDTO> determineLoans(CustomerRequestDTO dto) {
        int age =  dto.getAge();
        double income =  dto.getIncome();
        String location =  dto.getLocation();
        String name =  dto.getName();

       List<LoansResponseDTO> loans = new ArrayList<>();

        if (income <= 3000) {
            loans.add(new LoansResponseDTO("PERSONAL", 4));
            loans.add(new LoansResponseDTO("GUARANTEED", 3));
        }

        if (income <= 5000) {
            loans.add(new LoansResponseDTO("CONSIGNMENT", 2));
        }

        if (income > 3000 && income <= 5000 && age < 30 && "SP".equalsIgnoreCase(location)) {
            loans.add(new LoansResponseDTO("PERSONAL", 4));
            loans.add(new LoansResponseDTO("GUARANTEED", 3));
        }

        return loans;
    }
}
