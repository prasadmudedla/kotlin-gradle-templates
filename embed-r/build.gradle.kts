plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.3.60"
}

repositories {
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-dev" )
}

kotlin {
    mingwX64("libgnuplot") {
        binaries {
            executable {
                entryPoint = "plot.main"
            }
        }
        compilations["main"].cinterops {
            
            val R by creating {
                includeDirs {
                    allHeaders(
                        "C:/ROpen/R353/include"
                    )
                }
            }
            
        }
    }
}