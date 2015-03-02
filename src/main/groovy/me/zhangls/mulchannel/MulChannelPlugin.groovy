package me.zhangls.mulchannel

import org.gradle.api.Plugin
import org.gradle.api.Project

class MulChannelPlugin implements Plugin<Project> {
    void apply(Project target) {
        target.task('mulchannel', type: MulchannelTask)
        target.extensions.create('mulchannel', ConfigExtension)
    }
}
