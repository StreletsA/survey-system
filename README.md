# Survey system
## Solution Fabric Task 

## Run the app

    ./mvnw spring-boot:run

# REST API

The REST API

## Get list of all surveys

### Request

`GET /api/surveys`

### Response

    ```json
    {
      "id": string,
      "name": string,
      "startTime": string,
      "finishTime": string,
      "description": string,
      "questions": [
        {
           "id": string,
           "text": string,
           "type": string,
           "answers": [
              {
                "id": string,
                "text": string,
                "userIds": [string]
              },
              ...
        },
        ...
      ]
    }
    ```json

## Get list of all surveys for this user

### Request

`GET /api/surveys/my/?userId={User Id}`

### Response

   ```json
    {
      "id": string,
      "name": string,
      "startTime": string,
      "finishTime": string,
      "description": string,
      "questions": [
        {
           "id": string,
           "text": string,
           "type": string,
           "answers": [
              {
                "id": string,
                "text": string,
                "userIds": [string]
              },
              ...
        },
        ...
      ]
    }
    ```json
    
## Create a new Survey

### Request

`PUT /api/surveys`

# Header includes 
Authorization: string


## To answer for a question

### Request

`POST /api/surveys

    ```json
    {
      "userId": string,
      "surveyId": string,
      "questionId": string,
      "userAnswer": string,
    }
    ```json

