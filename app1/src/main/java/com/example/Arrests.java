package com.example;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Arrests {
    Long id;
    Boolean isBlockedForDebit;
    Boolean isBlockedForCredit;
    Boolean active;
    String type;
    BigDecimal amountRub;
    BigDecimal amountCcy;
    String orderReferenceNumber;
    String orderDate;
    String reason;
    String orderCancellationDate;
    String orderCancellationReferenceNumber;
    String startDate;
    String endDate;
    Source source;
}
