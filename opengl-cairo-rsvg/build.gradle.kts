plugins {
    id("org.jetbrains.kotlin.multiplatform") version "1.3.70-dev-1231-17"
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
            val glfw by creating {
                includeDirs {
                    allHeaders("C:/msys64/mingw64/include")
                }
            }
            val rsvg by creating {
                includeDirs {
                    allHeaders(
                        "C:\\msys64\\mingw64\\include",
                        "C:\\msys64\\mingw64\\lib\\glib-2.0\\include",
                        "C:\\msys64\\mingw64\\include\\glib-2.0",
                        "C:\\msys64\\mingw64\\include\\glib-2.0\\include",
                        "C:\\msys64\\mingw64\\include\\glib-2.0\\glib",
                        "C:\\msys64\\mingw64\\include\\gdk-pixbuf-2.0",
                        "C:\\msys64\\mingw64\\include\\cairo",
                        "C:\\msys64\\mingw64\\include\\librsvg-2.0"
                    )
                }
            }
            val glew by creating {
                includeDirs {
                    allHeaders(
                        "C:\\msys64\\mingw64\\include\\GL",
                        "C:\\msys64\\mingw64\\include"
                    )
                }
            }
        }
    }
}