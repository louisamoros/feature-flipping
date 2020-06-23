# Feature Flipping POC

## admin-console
FF4j admin console plugged to redis datasource.
```shell script
cd admin-console
mvn spring-boot:run
```

## service-a
Service A that uses redis datasource for feature flipping.
```shell script
cd service-a
mvn spring-boot:run
```