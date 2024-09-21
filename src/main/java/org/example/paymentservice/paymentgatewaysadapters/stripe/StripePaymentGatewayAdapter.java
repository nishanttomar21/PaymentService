// Stripe create payment link api - https://docs.stripe.com/payment-links/api?lang=java&shell=true&api=true&resource=payment_links&action=create
// Stripe API keys - https://dashboard.stripe.com/apikeys
// Stripe SDK - https://github.com/stripe/stripe-java
// Fake Credit Cards - https://docs.stripe.com/testing

package org.example.paymentservice.paymentgatewaysadapters.stripe;

import org.example.paymentservice.paymentgatewaysadapters.PaymentGatewayAdapter;
import com.stripe.StripeClient;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.example.paymentservice.paymentgatewaysadapters.PaymentGatewayAdapter;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGatewayAdapter implements PaymentGatewayAdapter {
//    private final StripeClient stripeClient;
//
//    public StripePaymentGatewayAdapter(StripeClient stripeClient) {
//        this.stripeClient = stripeClient;
//    }

    
    @Override
    public String createPaymentLink(Long price) throws Exception {
        //  [Important] Create the product and price object not during runtime but rather at the time of creation of the product or when price of the product is changed. Hence not use this in the createPaymentLink method during production. Hence create a table in your codebase called "StripeProductOrder" table with columns "stripeProductId", "stripePriceId" and "productId".
        // So now to do this on the fly, whenever a new product is created or a price is updated you will call payment service to update the table with the new stripeProductId and stripePriceId.
        //  ProductCreateParams params =
        //   ProductCreateParams.builder()
        //     .setDescription("(created by Stripe Shell)")
        //     .setName("Scaler Academy Course")
        //     .setActive(true)
        //     .setDefaultPriceData(
        //       ProductCreateParams.DefaultPriceData.builder()
        //         .setCurrency("inr")
        //         .setUnitAmount(999999L)
        //         .build()
        //     )
        //     .build();

        // Product product = Product.create(params);    // Object: prod_QtFBN5gVi0iVXR is saved in the Stripe database

        // PriceCreateParams params =
        //   PriceCreateParams.builder()
        //     .setCurrency("inr")
        //     .setProduct("prod_QoQyJDl6Jf0JGx")
        //     .setUnitAmount(999999L)
        //     .build();

        // Price price = Price.create(params);      // Object: price_1Q1SjsL2mh7C3fSjPSTmqEIu

        // Hierarchy of Payment Links: Product --> Price --> Payment Link
        PaymentLinkCreateParams params =
            PaymentLinkCreateParams.builder()
                .setCurrency("inr")
                .addLineItem(
                PaymentLinkCreateParams.LineItem.builder()
                    .setPrice("price_1Q1SjsL2mh7C3fSjPSTmqEIu")     // To create the link on the fly retrieve stripePriceId from StripeProductOrder table
                    .setQuantity(1L)
                    .build()
                )
                .setAfterCompletion(
                PaymentLinkCreateParams.AfterCompletion.builder()
                    .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                    .setRedirect(
                    PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                        .setUrl("https://scaler.com")
                        .build()
                    )
                    .build()
                )
                .setInvoiceCreation(
                PaymentLinkCreateParams.InvoiceCreation.builder().setEnabled(true).build()
                )
                .setPhoneNumberCollection(
                PaymentLinkCreateParams.PhoneNumberCollection.builder().setEnabled(false).build()
                )
                .build();

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.getUrl();
    }

}
