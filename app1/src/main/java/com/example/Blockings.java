package com.example;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Blockings {
    Long id;
    Boolean isBlockedForDebit;
    Boolean isBlockedForCredit;
    Boolean active;
    String type;
    BigDecimal amountRub;
    BigDecimal amountCc;
    String orderReferenceNumber;
    String orderDate;
    String reason;
    String orderCancellationDate;
    String orderCancellationReferenceNumber;
    String startDate;
    String endDater;
    Source source;




}
