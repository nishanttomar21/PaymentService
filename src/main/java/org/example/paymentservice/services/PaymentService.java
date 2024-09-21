package org.example.paymentservice.services;

import org.example.paymentservice.paymentgatewaysadapters.PaymentGatewayAdapter;
import org.example.paymentservice.paymentgatewaysadapters.PaymentGatewayStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentGatewayStrategy paymentGatewayStrategy;

    public PaymentService(PaymentGatewayStrategy paymentGatewayStrategy) {
        this.paymentGatewayStrategy = paymentGatewayStrategy;
    }

    /**
     * Creates a payment link for a given order.
     * 
     * This method performs the following steps:
     *      1. Retrieves the order details from the order service (currently mocked).
     *      2. Selects an appropriate payment gateway using a strategy.
     *      3. Creates a payment link using the selected payment gateway.
     *      4. Returns the generated payment link.
     *
     * @param orderId The unique identifier of the order for which to create a payment link.
     * @return A String representing the URL of the created payment link. If an error occurs
     *         during the process, an empty string is returned.
     */
    public String createPaymentLink(Long orderId) {
        // 1. Get the order details from the order service
        // restTemplate.getForObject("http://orderservice.naman.dev/orders/{orderId}", Order.class, orderId);
        /// price = order.getPrice();
        Long price = 123L;

        // 2. Get a payment gateway based upon a `strategy`
        PaymentGatewayAdapter paymentGatewayAdapter = paymentGatewayStrategy.getPaymentGateway();


        String url = "";

        // 3. Call the payment gateway to create a payment link
        try {
            url = paymentGatewayAdapter.createPaymentLink(price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 4. Return the payment link
        return url;
    }
}
