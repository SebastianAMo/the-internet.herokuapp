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
    testImplementation("org.seleniumhq.selenium:selenium-java:4.25.0")

    // Dependencia de TestNG
    testImplementation("org.testng:testng:7.9.0")
}

tasks.test {
    useTestNG()

    // Habilitar ejecución en paralelo
    maxParallelForks = Runtime.getRuntime().availableProcessors() / 2

    // Configurar propiedades del sistema para Selenium Grid
    systemProperty("SELENIUM_GRID_URL", System.getProperty("SELENIUM_GRID_URL", "http://10.147.20.27:4444/wd/hub"))

    // Configurar propiedades del sistema para el navegador
    systemProperty("browser", System.getProperty("browser", "chrome"))
}
