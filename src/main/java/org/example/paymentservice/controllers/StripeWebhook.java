/*
    1. HTTP Request:
        This is a standard method for a client (like a web browser or application) to request data from or send data to a server.
        The client initiates the communication, sending a request to a specific URL.
        It's a one-time, synchronous operation: the client sends a request and waits for a response.

    2. Webhook:
        A webhook is a way for an application to provide real-time information to other applications.
        It's a form of reverse HTTP request, sometimes called an HTTP push API.
        Instead of the client polling for new information, the server sends data to the client when a specific event occurs.
        Webhooks are asynchronous and event-driven.

    To Illustrate:
        Making an HTTP request is like calling someone on the phone to ask for information.
        A webhook is like someone calling you back when they have new information, without you having to keep checking.
*/

package org.example.paymentservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stripe/webhook")
public class StripeWebhook {
}
