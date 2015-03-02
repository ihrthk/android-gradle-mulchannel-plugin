package me.zhangls.mulchannel

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class MulChannelPluginTest {
    @Test
    public void mulchannelPluginAddsMulchannelTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'mulchannel'

        assertTrue(project.tasks.mulchannel instanceof MulchannelTask)
    }
}
