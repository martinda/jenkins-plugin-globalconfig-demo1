package org.jenkins.plugins.demo;

import hudson.model.FreeStyleBuild;
import hudson.model.FreeStyleProject;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.jvnet.hudson.test.JenkinsRule;

public class Demo1Test {

    @Rule
    public JenkinsRule j = new JenkinsRule();

    @Test
    public void demoTest() throws Exception {

        Demo1 demo1 = new Demo1("text");

        // Run build
        FreeStyleProject project = j.createFreeStyleProject();
        project.getBuildersList().add(demo1);
        FreeStyleBuild build = project.scheduleBuild2(0).get();

        // Check expectations
        j.assertBuildStatusSuccess(build);

    }
}
