import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val ktor_version: String by project
val logback_version: String by project
val junit_version: String by project
val hamcrest_version: String by project

plugins {
    kotlin("jvm") version "1.7.0"
    application
}

group = "me.d1"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-logging:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
}
tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}