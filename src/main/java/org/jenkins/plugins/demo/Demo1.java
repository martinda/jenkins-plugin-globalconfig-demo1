package org.jenkins.plugins.demo;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;

import java.io.IOException;
import java.lang.InterruptedException;

import jenkins.model.GlobalConfiguration;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class Demo1 extends Builder {

    private DemoGlobalConfig demoGlobalConfig;

    private String input1;
    private String globalVar;

    @DataBoundConstructor
    public Demo1(String input1)
    {
        System.out.println("Demo1()");
        this.input1 = input1;
    }

    public String getInput1() {
        System.out.println("getInput1()");
        return input1;
    }

    public void setGlobalVar(String globalVar) {
        System.out.println("setGlobalVar()");
        this.globalVar = globalVar;
    }

    public String getGlobalVar() {
        System.out.println("getGlobalVar()");
        return globalVar;
    }

    @Override
    public boolean perform(
        AbstractBuild<?,?> build,
        Launcher launcher,
        BuildListener listener
    ) throws IOException, InterruptedException
    {
        demoGlobalConfig = GlobalConfiguration.all().get(DemoGlobalConfig.class);
        System.out.println("Input 1: "+input1);
        System.out.println("Global Var: "+demoGlobalConfig.getGlobalVar());
        return true;
    }

    @Extension
    public static final class DescriptorImpl extends BuildStepDescriptor<Builder> {

        public DescriptorImpl() {
            System.out.println("DescriptorImpl::load()");
            load();
        }

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> aClass) {
            return true;
        }

        @Override
        public String getDisplayName() {
            return "Demo1";
        } 
    }
}
