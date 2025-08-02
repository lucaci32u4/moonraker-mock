FROM eclipse-temurin:21
RUN apt update -y && apt install maven -y
RUN mkdir -p /opt/moonraker-mock-temp /opt/moonraker-mock
COPY ./pom.xml /opt/moonraker-mock-temp
COPY ./src /opt/moonraker-mock-temp/src
RUN mvn -B -f /opt/moonraker-mock-temp package
RUN ls /opt/moonraker-mock-temp/target | grep -E 'moonraker-mock-[-.0-9a-zA-Z]+.jar' | grep -vE 'sources|original|javadoc' | xargs -I '{}' mv '/opt/moonraker-mock-temp/target/{}' /opt/moonraker-mock/moonraker-mock.jar
RUN rm -rf /opt/moonraker-mock-temp

CMD ["java", "-jar", "/opt/moonraker-mock/moonraker-mock.jar"]


