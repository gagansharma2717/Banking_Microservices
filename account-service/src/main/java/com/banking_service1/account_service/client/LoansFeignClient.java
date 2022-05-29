package com.banking_service1.account_service.client;
import java.util.List;

import com.banking_service1.account_service.model.Customer;
import com.banking_service1.account_service.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("loans")
public interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "myLoans", consumes = "application/json")
    List<Loans> getLoansDetails(@RequestHeader("yeezybank-correlation-id") String correlationid, @RequestBody Customer customer);
}
