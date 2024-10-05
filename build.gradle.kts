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
    useJUnitPlatform()

    // Habilitar ejecución en paralelo
    maxParallelForks = Runtime.getRuntime().availableProcessors() / 2

    systemProperty ("SELENIUM_GRID_URL", System.getProperty("SELENIUM_GRID_URL", "http://localhost:4444/wd/hub"))
    // Configurar propiedades del sistema para el navegador
    systemProperty("browser", System.getProperty("browser", "chrome"))
}