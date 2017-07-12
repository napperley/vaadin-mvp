val KOTLIN_VER = "1.1.3-2"
val VAADIN_VER = "8.0.6"

group = "org.example"
version = "0.1-SNAPSHOT"

buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.3-2")
    }
}

plugins {
    id("com.devsoap.plugin.vaadin").version("1.2.0.beta1")
}

apply {
    plugin("kotlin")
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:$KOTLIN_VER")
    compile("org.jetbrains.kotlin:kotlin-runtime:$KOTLIN_VER")
}