package com.github.rkotkiewicz

import java.io.File
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.UnexpectedBuildFailure
import kotlin.test.Test
import kotlin.test.assertTrue

class PrintExtPluginFunctionalTest {
    @Test fun `can run task`() {
        // Setup the test build
        val projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('com.github.rkotkiewicz.print-ext')
            }
            
            ext {
                foo = 'foo value'
            }
            
           printExt {
                include 'foo'
            }
            
            
        """)

        // Run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("printFoo", "-q")
        runner.withProjectDir(projectDir)
        val result = runner.build();

        // Verify the result
        assertTrue(result.output.trim() == "foo value")
    }

    @Test(expected = UnexpectedBuildFailure::class)
    fun `can include only listed properties`() {
        // Setup the test build
        val projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('com.github.rkotkiewicz.print-ext')
            }
            
            ext {
                foo = 'foo value'
                bar = 'bar value'
                baz = 'baz value'
            }
            
            printExt {
                include 'bar', 'baz'
            }
            
        """)

        // Run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("printFoo", "-q")
        runner.withProjectDir(projectDir)
        runner.build()
    }

}
