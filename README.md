# gradle-labs

Gradle learning labs.

Made with:
- **IntelliJ IDEA 2023.1 (Ultimate Edition)**
- **openjdk 11.0.17**
- **Gradle 7.6.1**


---


## Install & build


<details>
<summary>Build the JAR using Gradle</summary>

```shell
./gradlew clean build
```

```shell
./gradlew clean build -x test
```

```shell
./gradlew clean build testClasses -x test
```

</details>


<details>
<summary>Add manifest file</summary>

```shell
jar -cmvf \
  ./build/tmp/jar/MANIFEST.MF \
  ./build/libs/gradle-labs-0.0.1-SNAPSHOT.jar \
  ./build/classes/java/main/org/squidmin/gradlelabs/GradleLabsApplication.class
```

</details>


<details>
<summary>Build a container image</summary>

```shell
docker build \
  --build-arg GCP_PROJECT_ID=PROJECT_ID \
  -t gradle-labs .
```

Example:

```shell
docker build -t \
  --build-arg GCP_PROJECT_ID=lofty-root-305785 \
  gradle-labs .
```

</details>


<details>
<summary>Run an interactive container instance</summary>

```shell
docker run \
  --rm -it \
  -e GOOGLE_APPLICATION_CREDENTIALS=$GOOGLE_APPLICATION_CREDENTIALS \
  -v $HOME/.config/gcloud:/root/.config/gcloud \
  -v $HOME/.m2:/root/.m2 \
  gradle-labs
```

</details>


<details>
<summary>Run the JAR using Gradle</summary>

Run the following commands either:
- from the `ENTRYPOINT` in the `Dockerfile`, or
- at the terminal prompt in an interactive container instance.

Use `-P=args` to set Gradle project properties.

```shell
./gradlew cmdLineJavaExec -Pargs="ARG_1 ARG_2 [...] ARG_N"
```

**Replace the following**:
- `ARG_1 ARG_2 [...] ARG_N`: the values of the arguments expected by the application's `main` method.

Example:

```shell
./gradlew cmdLineJavaExec -Pargs="lorem ipsum dolor"
```

</details>


<details>
<summary>Run the JAR without Gradle</summary>


### `exec java` command

```shell
exec java -jar \
  -Dspring.profiles.active=local \
  -DGOOGLE_APPLICATION_CREDENTIALS=$GOOGLE_APPLICATION_CREDENTIALS \
  ./build/libs/spring-rest-labs-0.0.1-SNAPSHOT.jar
```


### `java` command

Set system properties using `-Darg`, where `arg` is the argument name.

Pass additional arguments to the application's `main` method by placing them after the name of the `jar`.

```shell
java -Dkey_1=ARG_A -Dkey_2=ARG_B [...] -Dkey_n=ARG_N -jar gradle-labs-0.0.1-SNAPSHOT.jar [ ARG_1 ARG_2 [...] ARG_N ]
```

**Replace the following**:
- `-Dkey_1=ARG_A -Dkey_2=ARG_B [...] -Dkey_n=ARG_N`: the system property keys and values.
- `ARG_1 ARG_2 [...] ARG_N`: the main method arguments.

Example:

```shell
java -Dfirst=val_a -Dsecond=val_b -Dspring.profiles.active=local -jar \
  gradle-labs-0.0.1-SNAPSHOT.jar arg_1 arg_2 arg_3
```


</details>


---

## Tasks


### Build tasks

<details>
<summary>Delete the build directory</summary>

```shell
./gradlew clean
```

</details>


<details>
<summary>Assemble and test the project</summary>

```shell
./gradlew build
```

</details>


<details>
<summary>Assemble the project and skip tests</summary>

```shell
./gradlew build -x test
```

or

```shell
./gradlew build testClasses -x test
```

</details>


<details>
<summary>Run the project as a Spring Boot application</summary>

```shell
./gradlew bootRun
```

</details>


<details>
<summary>Resolve the name of the application's main class for the bootRun task</summary>

```shell
./gradlew bootRunMainClassName
```

</details>


<details>
<summary>Assemble an executable jar archive containing the main classes and their dependencies</summary>

```shell
./gradlew bootJar
```

</details>


<details>
<summary>Resolve the name of the application's main class for the bootJar task</summary>

```shell
./gradlew bootJarMainClassName
```

</details>


<details>
<summary>Assemble a jar archive containing the main classes</summary>

```shell
./gradlew jar
```

</details>


<details>
<summary>Assemble test classes</summary>

```shell
./gradlew testClasses
```

</details>


### Build setup tasks

<details>
<summary>Initialize a new Gradle build</summary>

```shell
./gradlew init
```

</details>


<details>
<summary>Generate Gradle wrapper files</summary>

```shell
./gradlew wrapper
```

</details>


### Application tasks

<details>
<summary>List the tasks available</summary>

```shell
./gradlew tasks
```

</details>


### Documentation tasks

<details>
<summary>Generate Javadoc API documentation for the main source code</summary>

```shell
./gradlew javadoc
```

</details>


#### Help tasks

<details>
<summary>Display the properties of the root project</summary>

```shell
./gradlew properties
```

</details>


<details>
<summary>Display the tasks runnable from the root project</summary>

```shell
./gradlew tasks
```

Pass the option `--all` to see the tasks in more detail:

```shell
./gradlew tasks --all
```

To see more detail about a task, run:

```shell
./gradlew help --task TASK
```

**Replace the following**:
- `TASK`: the name of the task.

</details>


### Verification tasks

<details>
<summary>Run all checks</summary>

```shell
./gradlew check
```

</details>


<details>
<summary>Run the test suite</summary>

```shell
./gradlew test
```

</details>


<details>
<summary>Recompile the project and run the test suite</summary>

```shell
./gradlew clean test
```

</details>


<details>
<summary>Run a specific test class</summary>

```shell
./gradlew test --tests TestClassName
```

</details>


<details>
<summary>Run a specific test method of a specific test class</summary>

```shell
./gradlew clean test --tests TestClassName.methodName
```

</details>


<details>
<summary>Run a specific test method of a specific test class, passing command line arguments</summary>

```shell
./gradlew clean test -Darg_1=example --tests CliArgumentsExampleTest.basicExample
```

</details>


---


## Guides


### Gradle

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Gradle CLI](https://docs.gradle.org/current/userguide/command_line_interface.html)
* [Gradle Command Line Arguments](https://www.baeldung.com/gradle-command-line-arguments)
* [Java Testing](https://docs.gradle.org/current/userguide/java_testing.html)
* [Gradle Testing](https://www.tutorialspoint.com/gradle/gradle_testing.htm)
* [JUnit 5 Tutorial: Running Unit Tests with Gradle](https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-running-unit-tests-with-gradle/)
* [Gradle: How to Run a Single Unit Test Class](https://mkyong.com/gradle/gradle-how-to-run-a-single-unit-test-class/)
* [Gradle: How to Show Standard Output or Error Output from Tests](https://blog.mrhaki.com/2014/10/gradle-goodness-show-standard-out-or.html)
* [Gradle Usage with Spring Framework](https://spring.io/guides/gs/gradle/#scratch)


### Spring

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


---


### Other references

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.10/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.10/gradle-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.7.10/reference/htmlsingle/#appendix.configuration-metadata.annotation-processor)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/2.7.10/reference/htmlsingle/#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.10/reference/htmlsingle/#web)
