val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kgraphql_version: String by project
val ktor_gson: String by project
val ktor_client: String by project

plugins {
    application
    kotlin("jvm") version "1.7.10"
}

group = "techouts.com"
version = "0.0.1"
application {
    mainClass.set("techouts.com.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {

    implementation("io.ktor:ktor-server-core:$ktor_version")

    implementation("io.ktor:ktor-gson:$ktor_gson")
    implementation("io.ktor:ktor-serialization:$ktor_gson")
    implementation("io.ktor:ktor-client-gson:$ktor_gson")

    implementation("io.ktor:ktor-server-tomcat:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("com.apurebase:kgraphql:$kgraphql_version")
    implementation("com.apurebase:kgraphql-ktor:$kgraphql_version")

    implementation("io.ktor:ktor-client-core:$ktor_client")
    implementation("io.ktor:ktor-client-okhttp:$ktor_client")
    implementation("io.ktor:ktor-client-cio:$ktor_client")

    testImplementation("io.ktor:ktor-server-tests:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}