FROM openjdk:17
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
CMD ./mvnw '-Dtest=ru.pobedonostsev.library.integration.*Test' test
