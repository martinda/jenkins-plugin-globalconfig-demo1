package org.jenkins.plugins.demo;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;

public class MyString extends AbstractDescribableImpl<MyString>
{

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

        // Does this ctor cause the loading of the values in the UI? NO
        // Is this ctor needed? Do not know. taking it out.
        //public DescriptorImpl() {
        //    System.out.println("MyString::DescriptorImpl.load()");
        //    load();
        //}
        // no call to configure(), why?
        //@Override
        //public boolean configure(StaplerRequest req, JSONObject o)
        //throws FormException
        //{
        //    System.out.println("MyString.configure()");
        //    req.bindJSON(this, o);
        //    save();
        //    return true;
        //}

        public String getDisplayName() {
            return "String value";
        }
    }

}
