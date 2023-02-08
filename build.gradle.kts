plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("io.kotest.multiplatform") version "5.0.2"
}

val kotestVersion = "5.5.4"
val mockkVersion = "1.13.3"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")

}


tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}
