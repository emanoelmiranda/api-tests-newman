# Postman tests

### Reference Documentation
Implementation with postman tests and newman execution for CI/CD

#### Executing application
```
mvn spring-boot:run
```

#### Executing test by newman
Obs.: Export postman test before
```
newman run "postman_collection.json"
```

#### Executing test by newman with reporters
Obs.: Export postman test before
```
newman run "ApiPostmanTests.postman_collection.json" -r htmlextra --reporter-htmlextra-displayProgressBar 
```