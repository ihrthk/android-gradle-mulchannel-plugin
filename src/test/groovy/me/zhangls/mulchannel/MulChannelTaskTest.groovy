package me.zhangls.mulchannel

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class MulChannelTaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('mulchannel', type: MulchannelTask)
        assertTrue(task instanceof MulchannelTask)
    }
}
