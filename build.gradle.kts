import java.nio.file.Files.exists

plugins {
    id("java")
    id("java-library")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(project(":module-core"))
}

tasks.test {
    useJUnitPlatform()
}

abstract class ValidateMain : DefaultTask() {
    @TaskAction
    fun action() {
        val filePath = "src/main/java/org/example/Main.java"
        val file = File(filePath)

        if (file.exists()) {
            println("The file '$filePath' exists.")
        } else {
            println("The file '$filePath' does not exist.")
        }
    }
}

tasks.register<ValidateMain>("ValidateMain")