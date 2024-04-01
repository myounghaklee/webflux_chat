# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/gradle-plugin/reference/html/#build-image)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)


-------
## Reactor publisher
### Flux 
- 0-N개의 아이템을 가질 수 있는 데이터 스트림
- onNext(~N), onComplete, onError

### Mono
- 0-1개의 아이템을 가질 수 있는 데이터 스트림
- onNext(0-1), onComplete, onError