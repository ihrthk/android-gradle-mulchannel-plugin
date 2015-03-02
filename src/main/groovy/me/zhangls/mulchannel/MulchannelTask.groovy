package me.zhangls.mulchannel

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MulchannelTask extends DefaultTask {
    @TaskAction
    def mulchannel() {
        //1.get config extension
        ConfigExtension config = project.mulchannel
        //2.decompression zip file to tempDir
        def ant = new AntBuilder();
        ant.unzip(src: config.inputFile, dest: config.tempDir)
        //3.iterater channels
        config.channels.each { item ->
            //3.1.new a channel file
            File file = new File(new File(config.tempDir, "META-INF"), "mulchannel_" + item)
            file.createNewFile()
            //3.2.zip the temp dir
            ant.zip(destfile: new File(config.outputDir, item + ".apk"), basedir: "temp");
            //3.3.delete channel file
            file.delete()
        }
    }
}
