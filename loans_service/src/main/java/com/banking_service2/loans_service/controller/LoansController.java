package com.banking_service2.loans_service.controller;

import java.util.List;
import java.util.logging.Logger;

import com.banking_service2.loans_service.config.LoansServiceConfig;
import com.banking_service2.loans_service.model.Customer;
import com.banking_service2.loans_service.model.Loans;
import com.banking_service2.loans_service.model.Properties;
import com.banking_service2.loans_service.repository.LoansRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
public class LoansController {
    @Autowired
    private LoansRepository loansRepository;
    @Autowired
    LoansServiceConfig loansConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestHeader("yeezybank-correlation-id") String correlationid, @RequestBody Customer customer) {
        System.out.println("Invoking Loans Service");
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if(loans != null) {
            return loans;
        } else {
            return null;
        }

    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
                loansConfig.getMailDetails(), loansConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}