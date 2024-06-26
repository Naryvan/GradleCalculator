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
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    implementation(project(":module-core"))
    implementation(project(":module-math"))
    testImplementation("org.assertj:assertj-core:3.25.1")
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

abstract class SetAppName : DefaultTask() {
    @Option(option="name", description="set app name")
    @Input
    var appName: String = "Calculator"

    @TaskAction
    fun action() {
        val filePath = "module-ui/src/main/resources/build_config.txt"
        val file = File(filePath)
        file.writeText(appName)
    }
}

tasks.register<SetAppName>("setAppName")
tasks.register<ValidateMain>("validateMain")