//  [Important] Create the product and price object not during runtime but rather at the time of creation of the product or when price of the product is changed. Hence, not use this in the createPaymentLink method during production. Hence create a table in your codebase called "StripeProductOrder" table with columns "stripeProductId", "stripePriceId" and "productId".
// So now to do this on the fly, whenever a new product is created or a price is updated you will call payment service to update the table with the new stripeProductId and stripePriceId.

package org.example.paymentservice.models;

// import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

// @Entity
@Getter
@Setter
public class StripeProductOrder extends BaseModel {
    private Long productId;
    private String stripePriceId;
    private String stripeProductId;

}
