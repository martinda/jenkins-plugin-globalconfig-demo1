package org.jenkins.plugins.demo;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

public class MyString extends AbstractDescribableImpl<MyString>
{

    private static final long serialVersionUID = 1L;
    private String value;

    @DataBoundConstructor
    public MyString(String value) {
        System.out.println("MyString("+value+")");
        this.value = value;
    }

    public String getValue() {
        System.out.println("MyString.getValue() -> "+value);
        return value;
    }

    @Extension
    public static class DescriptorImpl extends Descriptor<MyString> {
        public String getDisplayName() {
            return "String value";
        }
    }

}
