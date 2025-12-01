package com.bajaj.finserv.controller;

import com.bajaj.finserv.model.WebhookRequest;
import com.bajaj.finserv.model.WebhookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hiring")
public class WebhookController {

    /**
     * POST endpoint to generate webhook URL and access token
     * URL: /hiring/generateWebhook/JAVA
     * Method: POST
     * Request Body: JSON with name, regNo, email
     * Response: JSON with webhookUrl and accessToken
     */
    @PostMapping("/generateWebhook/JAVA")
    public ResponseEntity<WebhookResponse> generateWebhook(@RequestBody WebhookRequest request) {
        // Create response object
        WebhookResponse response = new WebhookResponse();

        // Generate webhook URL based on request data
        String webhookUrl = "https://bfhldevapigw.healthrx.co.in/webhook/" +
                request.getRegNo() + "/" +
                System.currentTimeMillis();

        // Generate a simple access token (in production, use proper JWT or OAuth)
        String accessToken = "BHFL_" + request.getRegNo() + "_" +
                generateRandomToken();

        response.setWebhookUrl(webhookUrl);
        response.setAccessToken(accessToken);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * GET endpoint for testing
     * URL: /hiring/generateWebhook/JAVA
     * Method: GET
     * Response: Simple message confirming endpoint is working
     */
    @GetMapping("/generateWebhook/JAVA")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok(
                "Webhook endpoint is working! Use POST method with request body containing name, regNo, and email.");
    }

    /**
     * Helper method to generate a random token
     */
    private String generateRandomToken() {
        return Long.toHexString(Double.doubleToLongBits(Math.random())).toUpperCase();
    }
}
