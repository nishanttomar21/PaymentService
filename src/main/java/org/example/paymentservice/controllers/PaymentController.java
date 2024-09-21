package org.example.paymentservice.controllers;

import org.example.paymentservice.dtos.CreatePaymentLinkRequestDto;
import org.example.paymentservice.dtos.CreatePaymentLinkResponseDto;
import org.example.paymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/")
    public CreatePaymentLinkResponseDto createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) {
        String url = paymentService.createPaymentLink(request.getOrderId());

        CreatePaymentLinkResponseDto response = new CreatePaymentLinkResponseDto();
        response.setUrl(url);

        return response;
    }

}
