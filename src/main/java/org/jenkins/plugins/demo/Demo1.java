package org.jenkins.plugins.demo;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.Builder;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.lang.InterruptedException;

import jenkins.model.GlobalConfiguration;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.DataBoundSetter;

public class Demo1 extends Builder {

    private String input1;

    @DataBoundConstructor
    public Demo1(String input1)
    {
        System.out.println("Demo1("+input1+")");
        this.input1 = input1;
    }

    public String getInput1() {
        System.out.println("getInput1() -> "+input1);
        return input1;
    }

    @Override
    public boolean perform(
        AbstractBuild<?,?> build,
        Launcher launcher,
        BuildListener listener
    ) throws IOException, InterruptedException
    {
        final PrintStream logger = listener.getLogger();
        DemoGlobalConfig demoGlobalConfig = GlobalConfiguration.all().get(DemoGlobalConfig.class);
        logger.println("Input 1: "+input1);
        logger.println("Global Var: "+demoGlobalConfig.getGlobalVar());
        List<MyString> strings = demoGlobalConfig.getMyStrings();
        logger.println("Strings: "+strings);
        if (strings != null) {
          for (MyString s : strings) {
              logger.println("String value: "+s.getValue());
          }
        }
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
