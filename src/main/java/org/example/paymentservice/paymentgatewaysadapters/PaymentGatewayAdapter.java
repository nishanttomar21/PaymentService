package org.example.paymentservice.paymentgatewaysadapters;

public interface PaymentGatewayAdapter {

    String createPaymentLink(Long price) throws Exception;
}
