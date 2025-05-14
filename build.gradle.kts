plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "net.momirealms"
version = "1.2"

repositories {
    mavenCentral()
    maven("https://maven.aliyun.com/repository/public/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.momirealms.net/releases")
    maven("https://jitpack.io/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("net.momirealms:custom-fishing:2.3.8")
    implementation("com.github.iqtesterrr:ParticleLib:1.5.4")
}

tasks {
    shadowJar {
        relocate ("top.zoyn.particlelib", "net.momirealms.customfishing.expansion.libraries.particlelib")
    }
}

tasks.named("build").get().dependsOn("shadowJar").doLast {
    println("Deleting: "+ "build/libs/"+project.name+"-"+project.version+".jar")
}