FROM openjdk:8-jre-alpine

EXPOSE 8080

# add application to container

# Add jar file application to the container (just the executable jar)
ADD target/InvoiceTracker-0.0.1-SNAPSHOT.jar app.jar

# what commands to run inside of the container when it starts, 
# entrypoint for your application (what happens when it runs)
ENTRYPOINT ["java" , "-jar", "app.jar"]