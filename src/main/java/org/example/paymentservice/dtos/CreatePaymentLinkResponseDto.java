package org.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentLinkResponseDto {
    private String url;
}