package com.github.rkotkiewicz

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertNotNull

/**
 * A simple unit test for the 'gradle.plugins.greeting' plugin.
 */
class PrintExtPluginTest {
    @Test
    fun `plugin registers task`() {
        // Create a test project and apply the plugin
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("com.github.rkotkiewicz.print-ext")

        // Verify the result
        assertNotNull(project.tasks.findByName("greeting"))
    }
}