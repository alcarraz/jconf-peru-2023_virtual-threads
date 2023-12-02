# Steps to setup this app

`code-with-cuarkus` contains the example code

`presentacion` contains beamer presentation: [virtual-threads.pdf](presentacion/virtual-threads.pdf)

## Requirements

- Quarkus
- Java 21

## quarkus

See https://es.quarkus.io/get-started/

```shell-session
quarkus create --gradle
cd code-with-quarkus		
# start the application
quarkus dev
```

## Java version level

In `build.gradle` set java compatibility to 21:

```gradle
java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
```

