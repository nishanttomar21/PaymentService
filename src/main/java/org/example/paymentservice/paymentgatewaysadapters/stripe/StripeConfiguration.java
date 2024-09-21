// Create this configuration file even though you do not use the getStripeClient() bean that you created.
// Create this configuration file even though you do not use the getStripeClient() bean that you created.

// The Stripe API key is still being used because:
// 1. Spring's @Value annotation injects the API key from your configuration.
// 2. The @Bean method is executed during application startup.
// 3. Inside getStripeClient(), Stripe.apiKey is set globally.
// 4. Stripe's static methods use this global API key for authentication.
//
// So, even if you don't directly use the StripeClient bean,
// the API key is set and available for all Stripe API calls.
// This allows you to use Stripe's static methods like PaymentLink.create()
// without explicitly passing the API key each time.

package org.example.paymentservice.paymentgatewaysadapters.stripe;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class StripeConfiguration {
    @Value("${apikeys.stripe}")
    private String stripeApiKey;

    @Bean
    public StripeClient getStripeClient() {
        Stripe.apiKey = stripeApiKey;
        return new StripeClient(stripeApiKey);
    }
}
