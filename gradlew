#!/bin/sh
# Gradle wrapper - download Gradle if needed and run
GRADLE_WRAPPER_JAR="gradle/wrapper/gradle-wrapper.jar"
exec java -classpath "$GRADLE_WRAPPER_JAR" org.gradle.wrapper.GradleWrapperMain "$@"
