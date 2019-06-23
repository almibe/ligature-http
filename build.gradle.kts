plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.40")
    application
}

repositories {
    mavenLocal()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("io.vertx:vertx-web:3.7.1")
    compile("io.vertx:vertx-rx-java2:3.7.1")
    compile("org.apache.jena:jena-tdb2:3.12.0")
    compile("org.jetbrains.xodus:xodus-entity-store:1.3.0")
    compile("com.google.inject:guice:4.2.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "org.libraryweasel.LibraryWeasel"
}
