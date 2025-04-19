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
    useTestNG {
        suites ("src/test/resources/testng.xml")  // Ruta al archivo testng.xml
    }

    // Configurar propiedades del sistema para Selenium Grid
    systemProperty("SELENIUM_GRID_URL", System.getProperty("SELENIUM_GRID_URL", "http://localhost:4444/wd/hub"))
    systemProperty("mode", System.getProperty("mode", "normal"))

}
