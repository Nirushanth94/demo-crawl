# Springboot Demo Crawler APP

Sample application to demonstrate text search functionality for given set of web pages

## Requirements

For building and running the application you need:

- Java 8
- Maven

## Running the application locally
```shell
1. Build and run the application with maven
2. Invoke the search API (use the following sample cURL)
```
## Sample cURL
```shell
curl --location --request POST 'http://localhost:8080/api/crawl/search' \
--header 'Content-Type: application/json' \
--data-raw '{
    "key": "simple",
    "url": [
        "http://a.testaddressbook.com/",
        "https://ultimateqa.com/dummy-automation-websites/"
    ]
}'
```
## Sample Response
```shell
{
    "message": "SUCCESS",
    "resultList": [
        {
            "url": "http://a.testaddressbook.com/",
            "count": 1,
            "text": [
                "A simple web app for showing off your testing"
            ]
        },
        {
            "url": "https://ultimateqa.com/dummy-automation-websites/",
            "count": 4,
            "text": [
                "Web app, simple HTML elements, complicated HTML elements",
                "Work with simple HTML elements like buttons",
                "Very simple UI interactions",
                "This is a neat little website with simple elements to practice test automation with. It has:"
            ]
        }
    ]
}
```