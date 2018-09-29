cmake_minimum_required(VERSION 3.4.1)

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add.library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

ADD_LIBRARY( # Specifies the name of the library.
             crashtest

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/jni/crash_test.cpp)

TARGET_LINK_LIBRARIES(crashtest android log)

# Specifies a path to native header files.
INCLUDE_DIRECTORIES(src/main/jni/include/)