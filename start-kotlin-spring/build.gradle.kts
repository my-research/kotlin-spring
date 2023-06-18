import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21" //  Kotlin 으로 작성된 코드를 JVM 에서 실행하기 위한 플러그인
	/**
	 * all-open
	 * spring bean 을 주입시키는데 필요한 여러 옵션 클래스에 대해 자동으로 all-open 을 만들어줌
	 * - kotlin 은 기본적으로 final class 이기 때문에, 해당 플러그인이 없으면 class 에 open 을 직접 해줘야 함
	 * - 왜 open 이 필요한가?
	 * 	- spring 은 bean 객체를 생성하기 위해서 proxy 로 bean 객체를 만드는데,
	 * 	- spring bean 은 AOP 를 지원하기 위해 proxy 객체로 만들어져야함
	 */
	kotlin("plugin.spring") version "1.8.21"
}

group = "com.github.dhslrl321"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_11
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}


/**
 * 코들린의 컴파일 옵션
 */
tasks.withType<KotlinCompile> {
	kotlinOptions { // 컴파일 옵션
		freeCompilerArgs += "-Xjsr305=strict" // null-safe 를 위한 표준, jsr-305 주석을 strict 하게 적용하도록 함
		jvmTarget = "11" // 생성된 byte code 의 target jvm 버전 설정
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
