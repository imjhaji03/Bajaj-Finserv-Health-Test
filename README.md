
# 🏥 Bajaj Finserv Health Challenge - Webhook Generator API

A Spring Boot REST API application for generating webhook URLs and access tokens. This project provides endpoints to create secure webhook configurations for the Bajaj Finserv Health platform.

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Project Structure](#-project-structure)
- [Testing with Postman](#-testing-with-postman)
- [Example Requests](#-example-requests)
- [Contributing](#-contributing)

## ✨ Features

- ✅ RESTful API for webhook generation
- ✅ Generates unique webhook URLs with timestamps
- ✅ Creates secure access tokens
- ✅ Clean MVC architecture
- ✅ Easy to test with Postman or any HTTP client
- ✅ Built with Spring Boot 3.2.0

## 🛠 Tech Stack

- **Java**: 17
- **Framework**: Spring Boot 3.2.0
- **Build Tool**: Maven
- **Dependencies**:
  - Spring Web
  - Spring WebFlux
  - Jackson (JSON processing)
  - Lombok
  - JJWT (JWT support)

## 🚀 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- Your favorite IDE (IntelliJ IDEA, Eclipse, VS Code)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/BajajTest.git
   cd BajajTest
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Verify it's running**
   
   The application will start on `http://localhost:8080`
   
   You should see output indicating the server has started successfully.

## 📚 API Documentation

### Base URL
```
http://localhost:8080
```

### Endpoints

#### 1. Test Webhook Endpoint (GET)

**Endpoint**: `GET /hiring/generateWebhook/JAVA`

**Description**: Tests if the webhook endpoint is accessible and working.

**Response**:
```
200 OK
"Webhook endpoint is working! Use POST method with request body containing name, regNo, and email."
```



---

#### 2. Generate Webhook (POST)

**Endpoint**: `POST /hiring/generateWebhook/JAVA`

**Description**: Generates a unique webhook URL and access token for the provided user information.

**Request Headers**:
```
Content-Type: application/json
```

**Request Body**:
```json
{
  "name": "Amit Gunjan Jha",
  "regNo": "22BSA10090",
  "email": "amitgunjanjha799@gmail.com"
}
```

**Response**:
```json
{
  "webhookUrl": "https://bfhldevapigw.healthrx.co.in/webhook/12345678/1733057890123",
  "accessToken": "BHFL_12345678_A3F7E9D2C1B4"
}
```

**Status Code**: `201 CREATED`

## 📁 Project Structure

```
BajajTest/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── bajaj/
│                   └── finserv/
│                       ├── FinservHealthChallengeApplication.java  # Main application
│                       ├── config/
│                       │   └── AppConfig.java                      # Configuration
│                       ├── controller/
│                       │   └── WebhookController.java              # REST endpoints
│                       ├── model/
│                       │   ├── WebhookRequest.java                 # Request DTO
│                       │   ├── WebhookResponse.java                # Response DTO
│                       │   └── SolutionRequest.java
│                       └── service/
│                           ├── ChallengeService.java
│                           └── SqlProblemSolver.java
├── pom.xml                                                         # Maven config
└── README.md
```

## 🧪 Testing with Postman

### GET Request Test

1. Open Postman
2. Create a new request
3. Set method to **GET**
4. Enter URL: `http://localhost:8080/hiring/generateWebhook/JAVA`
5. Click **Send**
6. You should receive a success message

### POST Request Test

1. Open Postman
2. Create a new request
3. Set method to **POST**
4. Enter URL: `http://localhost:8080/hiring/generateWebhook/JAVA`
5. Go to **Headers** tab:
   - Add: `Content-Type` = `application/json`
6. Go to **Body** tab:
   - Select **raw**
   - Select **JSON** format
   - Enter the request body (see example below)
7. Click **Send**
8. You should receive a webhook URL and access token

## 📝 Example Requests

### Example 1: Basic Request
```json
{
  "name": "Amit Gunjan Jha",
  "regNo": "22BSA10090",
  "email": "amitgunjanjha799@gmail.com"
'''
**Response**:
```json
{
  "webhookUrl": "https://bfhldevapigw.healthrx.co.in/webhook/REG001/1733057890123",
  "accessToken": "BHFL_REG001_F8A2D7E4B1C9"
}
```
```

**Response**:
```json
{
  "webhookUrl": "https://bfhldevapigw.healthrx.co.in/webhook/REG002/1733057895678",
  "accessToken": "BHFL_REG002_C3E9A1F7D2B8"
}
```

## 🔧 Configuration

The application runs on the default port **8080**. To change the port, add the following to `application.properties`:

```properties
server.port=9090
```

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| **Connection Refused** | Ensure the Spring Boot app is running with `mvn spring-boot:run` |
| **404 Not Found** | Verify the URL is exactly `http://localhost:8080/hiring/generateWebhook/JAVA` |
| **415 Unsupported Media Type** | Add `Content-Type: application/json` header to POST requests |
| **400 Bad Request** | Check that your JSON is valid and contains all required fields |

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is created for the Bajaj Finserv Health Challenge.

## 👤 Author

**Your Name**
- GitHub: [@yourusername](https://github.com/imjhaji03)

## 📞 Support

For any queries or issues, please open an issue on GitHub.

---

**Made with ❤️ for Bajaj Finserv Health Challenge**



