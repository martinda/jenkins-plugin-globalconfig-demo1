package org.jenkins.plugins.demo;

import hudson.model.FreeStyleBuild;
import hudson.model.FreeStyleProject;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void globalConfig() throws Exception {

        Demo1 demo1 = new Demo1("text");

        DemoGlobalConfig cfg = DemoGlobalConfig.get();
        cfg.setGlobalVar("this is a global string");

        List<MyString> myStrings = new ArrayList<>();
        myStrings.add(new MyString("string 1"));
        myStrings.add(new MyString("string 2"));
        cfg.setMyStrings(myStrings);

        // Run build
        FreeStyleProject project = j.createFreeStyleProject();
        project.getBuildersList().add(demo1);
        FreeStyleBuild build = project.scheduleBuild2(0).get();

        // Check expectations
        j.assertBuildStatusSuccess(build);
        j.assertLogContains("Input 1: text", build);
        j.assertLogContains("Global Var: this is a global string", build);
        j.assertLogContains("String value: string 1", build);
        j.assertLogContains("String value: string 2", build);

    }

    @Test
    public void roundtrip() throws Exception {
        roundtrip(new Demo1("text"));
    }

    private void roundtrip(Demo1 before) throws Exception {
        Demo1 after = j.configRoundtrip(before);
        j.assertEqualBeans(before, after, "input1");
    }
}
