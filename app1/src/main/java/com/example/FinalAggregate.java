package com.example;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class FinalAggregate {
    String accountId;
    String accountNumber;
    Boolean active;
    List<ArrestOrSuspention> arrestOrSuspention;
    String currency;
    BigDecimal balance;
    BigDecimal balanceRub;
    BigDecimal outSaldoCredit;
    BigDecimal outSaldoCreditRub;
    BigDecimal outSaldoOwn;
    BigDecimal outSaldoOwnRub;
    BigDecimal incomingBalance;
    BigDecimal incomingBalanceRub;
    BigDecimal lastMovementDate;
    BigDecimal totalAmountOfBlockings;
    BigDecimal totalAmountOfBlockingsRub;
    BigDecimal overdraftAmount;
    BigDecimal availableOverdraftAmount;
    BigDecimal maxOverdraftAmount;
    BigDecimal debetTurnover;
    BigDecimal debetTurnoverRub;
    BigDecimal creditTurnover;
    BigDecimal creditTurnoverRub;
    List<Arrests> arrests;
    List<Blockings> blockings;
    Boolean hasDocsInFileQueues;
    String absCode;
}
