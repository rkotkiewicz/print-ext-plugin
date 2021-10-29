package com.github.rkotkiewicz

import org.gradle.testfixtures.ProjectBuilder
import kotlin.test.Test
import kotlin.test.assertTrue

class PrintExtPluginTest {
    @Test
    fun `plugin registers extension`() {
        //when
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("com.github.rkotkiewicz.print-ext")
        val config = project.extensions.getByName("printExt")

        // Verify the result
        assertTrue { config is PrintExtPluginExtension }
    }
}