FROM java:8
WORKDIR /
COPY target/springboot-microservice-careawarepubsub-0.0.1-SNAPSHOT-sources.jar springboot-microservice-careawarepubsub.jar
ENV JAVA_OPTS="-Xmx512m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /springboot-microservice-careawarepubsub.jar" ]