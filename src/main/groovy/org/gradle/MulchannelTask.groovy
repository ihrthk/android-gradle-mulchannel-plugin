package org.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MulchannelTask extends DefaultTask {
    String greeting = 'hello from GreetingTask'

    @TaskAction
    def greet() {
        println greeting
    }
}
