plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Selenium para pruebas automatizadas en navegadores
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")

    // JUnit Jupiter (JUnit 5) usando BOM para manejar las versiones de manera coherente
    testImplementation (platform("org.junit:junit-bom:5.9.1"))
    testImplementation ("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    // Usar JUnit Platform para las pruebas
    useJUnitPlatform()

    // Pasar propiedades del sistema, útil para configurar el navegador en pruebas Selenium
    systemProperty( "browser", System.getProperty("browser", "chrome"))
}
