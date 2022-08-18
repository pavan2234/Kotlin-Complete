val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val ktorm_core: String by project
val hikari_CP_version: String by project
val ktorm_jackson: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
}

group = "com.example"
version = "0.0.1"
application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("mysql:mysql-connector-java:8.0.28")
    implementation("org.ktorm:ktorm-core:$ktorm_core")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")

    implementation("com.zaxxer:HikariCP:$hikari_CP_version")
    implementation("org.ktorm:ktorm-jackson:$ktorm_jackson")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("com.intuit.karate:karate-core:1.2.0")
    implementation("com.intuit.karate", "karate-apache", "0.9.4")
    implementation("com.intuit.karate", "karate-junit5", "0.9.4")
}