plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.7.0")

}

tasks.test {
    useJUnitPlatform()

    // Set system properties from command line arguments
    systemProperty("browser", System.getProperty("browser", "chrome"))

}