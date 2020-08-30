FROM maven as BUILDER
RUN mkdir -p /app
WORKDIR /app
COPY . /app
RUN mvn package -Dmaven.test.skip=true
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM openjdk:11.0.8-jdk
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring
ARG DEPENDENCY=/app/target/dependency
COPY --from=BUILDER ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=BUILDER ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=BUILDER ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]