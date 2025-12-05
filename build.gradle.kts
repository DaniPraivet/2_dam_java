plugins {
    id("java")
}

group = "dev.danipraivet"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Valkryst:VTerminal:2025.10.1")
    implementation("com.formdev:flatlaf:3.6.2")
    implementation("com.mysql:mysql-connector-j:8.0.31")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}