package com.interview.payment;

import org.mapstruct.Mapper;

@Mapper
public interface PaymentMapper {
    Payment toEntity(PaymentDto dto);
}
