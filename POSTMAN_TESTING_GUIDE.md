# Postman Testing Guide for Webhook Endpoint

## Endpoint Details

**Base URL**: `http://localhost:8080`  
**Endpoint**: `/hiring/generateWebhook/JAVA`  
**Full URL**: `http://localhost:8080/hiring/generateWebhook/JAVA`

---

## Test 1: GET Request (Test Endpoint)

### Configuration:
- **Method**: `GET`
- **URL**: `http://localhost:8080/hiring/generateWebhook/JAVA`
- **Headers**: None required

### Expected Response:
```
Status: 200 OK
Body: "Webhook endpoint is working! Use POST method with request body containing name, regNo, and email."
```

---

## Test 2: POST Request (Generate Webhook)

### Configuration:
- **Method**: `POST`
- **URL**: `http://localhost:8080/hiring/generateWebhook/JAVA`
- **Headers**: 
  - `Content-Type: application/json`

### Request Body (JSON):
```json
{
  "name": "Your Name",
  "regNo": "12345678",
  "email": "your.email@example.com"
}
```

### Expected Response:
```json
Status: 201 CREATED
Body:
{
  "webhookUrl": "https://bfhldevapigw.healthrx.co.in/webhook/12345678/1234567890123",
  "accessToken": "BHFL_12345678_ABC123DEF456"
}
```

---

## Step-by-Step Instructions for Postman

### For GET Request:
1. Open Postman
2. Create a new request
3. Set method to **GET**
4. Enter URL: `http://localhost:8080/hiring/generateWebhook/JAVA`
5. Click **Send**

### For POST Request:
1. Open Postman
2. Create a new request
3. Set method to **POST**
4. Enter URL: `http://localhost:8080/hiring/generateWebhook/JAVA`
5. Go to **Headers** tab
   - Add: `Content-Type` = `application/json`
6. Go to **Body** tab
   - Select **raw**
   - Select **JSON** from dropdown
   - Paste the request body JSON
7. Click **Send**

---

## Sample Request Bodies

### Example 1:
```json
{
  "name": "John Doe",
  "regNo": "REG001",
  "email": "john.doe@example.com"
}
```

### Example 2:
```json
{
  "name": "Jane Smith",
  "regNo": "REG002",
  "email": "jane.smith@example.com"
}
```

---

## Troubleshooting

### Issue: Connection Refused
- **Solution**: Make sure the Spring Boot application is running (`mvn spring-boot:run`)

### Issue: 404 Not Found
- **Solution**: Verify the URL is exactly `http://localhost:8080/hiring/generateWebhook/JAVA`

### Issue: 415 Unsupported Media Type
- **Solution**: Add `Content-Type: application/json` header to your POST request

### Issue: 400 Bad Request
- **Solution**: Verify your request body is valid JSON with all required fields (name, regNo, email)

---

## Controller File Location

The controller is located at:
```
src/main/java/com/bajaj/finserv/controller/WebhookController.java
```

---

## Notes

- The `webhookUrl` includes the registration number and a timestamp
- The `accessToken` is generated using the registration number and a random token
- In production, you would use proper JWT tokens and secure webhook URLs
- The server runs on port 8080 by default
