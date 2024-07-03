package com.example;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Controller {

    @GetMapping("/fccs/api/v3/aggregate/{absCode}/{accountId}")
    FinalAggregate getAccountByAbsCode(
                                       @PathVariable(name = "absCode") String absCode,
                                       @PathVariable(name = "accountId") String accountId,
                                       @RequestParam(required = false , defaultValue = "false") Boolean needExtendedInfo) {

        FinalAggregate finalAggregate = new FinalAggregate();
        finalAggregate.setBalance(BigDecimal.valueOf(23.00));
        finalAggregate.setBalanceRub(BigDecimal.valueOf(23.00));
        finalAggregate.setTotalAmountOfBlockingsRub(BigDecimal.valueOf(23.00));
        finalAggregate.setAccountId("76849806");
        finalAggregate.setAbsCode("14345");


        return finalAggregate;
    }
}
