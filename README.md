# 🚀 AWS Lambda Java 21 with LocalStack
![Java](https://img.shields.io/badge/Java-21-orange)
![AWS Lambda](https://img.shields.io/badge/AWS-Lambda-FF9900)
![LocalStack](https://img.shields.io/badge/LocalStack-AWS%20Local-blue)
![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED)
![Maven](https://img.shields.io/badge/Maven-Build-red)
![License](https://img.shields.io/badge/License-MIT-green)

A hands-on project demonstrating how to build and run an **AWS Lambda locally** using **Java 21**, **LocalStack**, **Docker**, and **Maven**, simulating an AWS environment without deploying to the cloud.

The goal of this project is to provide a practical guide for developers who want to learn **Serverless Architecture**, **AWS Lambda**, and **Cloud Computing** locally and cost-effectively.

---

## 📌 Project Goal

This project was created to practice **Serverless development** using AWS Lambda while running everything locally through LocalStack.

Main concepts covered:

- AWS Lambda with Java 21
- Local AWS environment simulation
- IAM Role configuration
- Maven Shade Plugin (fat jar packaging)
- Lambda deployment through `.jar` upload
- Local execution and testing
- Troubleshooting common LocalStack issues

---
## 🧪 Testing the Lambda

After uploading the `.jar` file, the Lambda can be tested directly inside LocalStack.

This function was designed to simulate a simple authentication flow.

### Valid request payload.

Example request:

```json
{
  "body": "{\"username\":\"admin\",\"password\":\"123\"}",
  "httpMethod": "POST"
}
```

### Expected response

```json
{
  "isAuthorized": true
}
```

---

### Invalid request payload

```json
{
  "body": "{\"username\":\"john\",\"password\":\"wrongPassword\"}",
  "httpMethod": "POST"
}
```

### Expected response

```json
{
  "isAuthorized": false
}
```

---

## ✅ Expected Result

If everything is configured correctly:

- The Lambda should execute successfully
- The HTTP response status should be:

```text
200 OK
```

- The response body should contain the expected JSON payload

Execution logs can also be inspected directly in LocalStack.

---

## ⚠️ Troubleshooting

During the development of this project, several real-world issues were encountered and solved.

### Problem 1: Maven command not recognized

Error:

```text
mvn : The term 'mvn' is not recognized
```

#### Cause

Maven was not configured in the Windows `PATH`.

#### Solution

The Maven bundled with IntelliJ IDEA was used to build the project.

Build command:

```bash
mvn package
```

---

### Problem 2: HTTP 500 error in Postman

Error:

```text
Status Code: 500
```

#### Cause

An internal LocalStack snapshot URL was used incorrectly.

Incorrect URL example:

```text
/awslambda-us-east-1-tasks/snapshots/
```

This URL is used internally by LocalStack and should not be called directly.

#### Solution

Understanding that the Lambda must be invoked through:

- Lambda Invoke
- API Gateway

instead of using LocalStack internal snapshot URLs.

---

### Problem 3: Lambda disappearing after restarting Docker

After restarting Docker Desktop, created resources disappeared.

Affected resources:

- Lambda Functions
- IAM Roles
- API Gateway

#### Cause

LocalStack was running without persistence enabled.

#### Solution

Recreate resources during learning sessions and understand LocalStack's ephemeral behavior when persistence is not configured.

---

## 🏗️ Architecture Overview

This project follows a simple Serverless flow running locally.

```text
Java 21 Application
        ↓
Maven Package
        ↓
Fat Jar (Maven Shade Plugin)
        ↓
LocalStack (AWS Simulation)
        ↓
AWS Lambda
        ↓
JSON Response
```

### Flow Explanation

1. The application is developed using **Java 21**
2. Maven packages the application into a **fat jar**
3. LocalStack simulates the AWS environment locally
4. The Lambda function is deployed into LocalStack
5. Requests are processed by the Lambda Handler
6. A JSON response is returned

---

## 📸 Project Evidence

Below are some screenshots of the project running locally.

### LocalStack Running

Add a screenshot of:

- LocalStack container running
- Docker Desktop

Example:

```text
images/localstack-running.png
```

---

### Lambda Created Successfully

Add a screenshot showing:

- Lambda Function
- Runtime `java21`
- Handler configuration
- Lambda status

Example:

```text
images/lambda.png
```

---

### Successful Lambda Execution

Add a screenshot showing:

- Status `200`
- Successful invocation
- JSON response

Example:

```text
images/invoke-success.png
```

---

## 📂 Project Structure

```text
aws-lambda-java21-localstack/
│── app/
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── tech/
│   │               └── buildrun/
│   │                   └── lambda/
│   │                       ├── Handler.java
│   │                       ├── request/
│   │                       │   └── LoginRequest.java
│   │                       └── response/
│   │                           └── LoginResponse.java
│   │
│   ├── pom.xml
│
│── images/
│── README.md
│── .gitignore
```

---

## 🚀 Future Improvements

Planned next steps for this project:

- [ ] Configure API Gateway
- [ ] Test requests through Postman
- [ ] Add DynamoDB Local
- [ ] Integrate with SQS
- [ ] Improve error handling
- [ ] Add persistence to LocalStack
- [ ] Create a complete serverless flow

---

## 💡 Key Learnings

Through this project, the following concepts were practiced:

- Running AWS services locally using LocalStack
- Creating AWS Lambda with Java 21
- Lambda Handler implementation
- Maven packaging with Shade Plugin
- IAM Role configuration
- Troubleshooting LocalStack issues
- Understanding Serverless Architecture fundamentals

---

## 👨‍💻 Author

**João Estevão Camilo**

Junior Backend Developer | Java | Cloud | AWS | Salesforce

### Connect with me

- LinkedIn: *(www.linkedin.com/in/joãoestevaocamilo)*


