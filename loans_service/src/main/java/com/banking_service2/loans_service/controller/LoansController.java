package com.banking_service2.loans_service.controller;

import com.banking_service2.loans_service.model.Customer;
import com.banking_service2.loans_service.model.Loans;
import com.banking_service2.loans_service.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;


    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer)
    {
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());

        if(loans != null)
        {
            return loans;
        }else{
            return null;
        }
    }
}
