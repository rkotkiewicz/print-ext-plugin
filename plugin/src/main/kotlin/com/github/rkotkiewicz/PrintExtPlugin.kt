package com.github.rkotkiewicz

import org.gradle.api.Project
import org.gradle.api.Plugin

/**
 * A simple 'hello world' plugin.
 */
class PrintExtPlugin: Plugin<Project> {
    override fun apply(project: Project) {

        val extension = project.extensions.create("printExt", PrintExtPluginExtension::class.java)

        project.afterEvaluate {
            project.extensions
                .extraProperties
                .properties
                .filter { it.key != null }
                .forEach {
                    registerPrintTask(project, it.key)
                }
        }
    }

    companion object {
        private fun registerPrintTask(project: Project, propertyName: String) {
            val taskName = "print${capitalize(propertyName)}"
            project.tasks.register(taskName) {
                it.doLast {
                    println(project.extensions.extraProperties.get(propertyName))
                }
            }
        }

        private fun capitalize(str: String): String {
            return str.replaceFirstChar {it.uppercase()}
        }
    }
}
