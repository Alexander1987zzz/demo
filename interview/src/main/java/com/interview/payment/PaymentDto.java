package com.interview.payment;

import lombok.Data;


public record PaymentDto(
        String userId,
        double amount
) {
}
