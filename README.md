# Introduction

This project is a poc using gradle and dropwizard to build a REST service. The implemented service is
a palindromic testing algorithm which simply determines whether the input word is palindromic or not.

# Before running
The project is builded using dropwizard 0.8.1 and gradle 2.4. Gradle must be installed before attempting to run this project. Once gradle is installed, `gradle run` command will set up a simple http server publishing <b>/palindrome/test/</b> path in the host, so it should be accessible at something such as `http://localhost:8080/palindrome/test/wordToTest`. The *wordToTest* is parsed as a parameter and is checked whether it is palindromic or not. If the word does not contain only alphabetic characters the service will return an error.

Endpoint Example 1: <br/>
URL: http://localhost:8080/palindrome/test/racecar <br/>
Response: HTTP 200 - OK `{ "success" : true, "result" : { "isAPalindrome" : true } }`<br/><br/>
Endpoint Example 2: <br/>
URL: http://localhost:8080/palindrome/test/banana <br/>
Response: HTTP 200 - OK `{ "success" : true, "result" : { "isAPalindrome" : false } }`<br/><br/>
Endpoint Example 3: <br/>
URL: http://localhost:8080/palindrome/test/6500 <br/>
Response: HTTP 400 - Bad Request `{ "success" : false, "result" : { "error" : "The parameter must be a string of characters A-Z only." } }` <br/>

You may also configure some other settings referring to dropwizard in the file
`src/dist/config/palindrome.yml`