# Gradle print ext plugin

This Gradle plugin creates tasks that print selected ext properties.

## How To Use

### Applying the plugin

Edit build.gradle file to apply the plugin:

    plugins {
        id 'com.github.rkotkiewicz.print-ext' version 0.0.1
    }


You can also use legacy plugin application

    buildscript {
        repositories {
            maven {
                url "https://plugins.gradle.org/m2/"
            }
        }

        dependencies {
            classpath  'com.github.rkotkiewicz:print-ext-plugin:0.0.1'
        }
    }

    apply plugin: 'com.github.rkotkiewicz.print-ext'

### Configuration

Create extra properties in `build.gradle`:


    project.ext {
        extProperty1 = 'foo1'
        extProperty2 = 'foo2'
        extProperty3 = 'foo3'
        extProperty4 = 'foo4'
        extProperty5 = 'foo5'
    }


You need also include selected properties in printExt configuration:

    printExt {
        include 'extProperty1', 'extProperty2', 'extProperty5'
    }


It will create tasks with names: `print<ExtPropertyName>`. The first letter of property name will be capitalized.
For the above configuration we will get three tasks:
`printExtProperty1`, `printExtProperty2`, `printExtProperty5`

### Usage

You can now run a print property task:

    ./gradlew -q printExtProperty2

It will print 'foo2'.


