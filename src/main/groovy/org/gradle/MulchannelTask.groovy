package org.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MulchannelTask extends DefaultTask {
    @TaskAction
    def greet() {
        ConfigExtension config = project.mulchannel
        def ant = new AntBuilder();
        ant.unzip(src: config.inputFile, dest: config.tempDir)
        config.channels.each { item ->
            File file = new File(new File(config.tempDir, "META-INF"), "mulchannel_" + item)
            file.createNewFile()
            ant.zip(destfile: new File(config.outputDir, item + ".apk"), basedir: "temp");
            file.delete()
        }
    }
}
