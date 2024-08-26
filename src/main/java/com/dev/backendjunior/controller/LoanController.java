package com.dev.backendjunior.controller;

import com.dev.backendjunior.dto.CustomerRequestDTO;
import com.dev.backendjunior.dto.LoansResponseDTO;
import com.dev.backendjunior.services.LoansService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {
    @Autowired
    private LoansService loansService;

    @PostMapping()
    public Map<String, Object> getAvailableLoans(@RequestBody CustomerRequestDTO request) {

        List<LoansResponseDTO> loans = loansService.determineLoans(request);

        Map<String, Object> response = new HashMap<>();
        response.put("customer", request.getName());
        response.put("loans", loans);

        return response;
    }
}
