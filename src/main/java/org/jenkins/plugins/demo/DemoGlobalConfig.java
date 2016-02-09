package org.jenkins.plugins.demo;

import hudson.Extension;
import java.util.List;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

@Extension
public class DemoGlobalConfig extends GlobalConfiguration {

    private String globalVar;

    private List<MyString> myStrings;

    public static DemoGlobalConfig get() {
        System.out.println("DemoGlobalConfig.get()");
        return GlobalConfiguration.all().get(DemoGlobalConfig.class);
    }

    public DemoGlobalConfig() {
        System.out.println("DemoGlobalConfig()");
        load();
    }

    @Override
    public boolean configure(StaplerRequest req, JSONObject o)
    throws FormException
    {
        System.out.println("DemoGlobalConfig.configure()");
        // Code commented out is from RobotConfig.java, it works
        // Is the next line necessary to save the globalVar value? YES
        // if not present, causes net.sf.json.JSONException: JSONObject["myStrings"]
        // The json object is
        // {"demoGlobalConfig":{"globalVar":"g","myStrings":[{"value":"h"},{"value":"t"}]}}
        System.out.println(o);
        o = o.getJSONObject("demoGlobalConfig");
        // after json looks like
        // {"globalVar":"j","myStrings":[{"value":"k"},{"value":"l"}]}
        System.out.println(o);
        // Is next line necessary to save the local value? -> NO!!! IT IS NOT NEEDED!!!
        //globalVar = o.getString("globalVar");
        // The string is [{"value":"a"},{"value":"b"}]
        System.out.println(o.getString("myStrings"));
        // when comment out next line, the complex object is not saved
        req.bindJSON(this, o);
        save();
        // Next line calls super, do we rally need to call the super?
        //   -> No we don't. it works without it
        //return super.configure(req, o);
        return true;

        // Code below is from DockerPluginConfig.java, it does not seem to work :-(
        //System.out.println("DemoGlobalConfig.configure()");
        //req.bindJSON(this, o);
        //return true;
    }

    public String getGlobalVar() {
        System.out.println("DemoGlobalConfig.getGlobalVar()");
        return globalVar;
    }

    @DataBoundSetter
    public void setGlobalVar(String globalVar) {
        System.out.println("DemoGlobalConfig.setGlobalVar()");
        this.globalVar = globalVar;
    }

    public List<MyString> getMyStrings() {
        System.out.println("DemoGlobalConfig.getMyStrings() -> "+myStrings);
        if (myStrings != null) {
            for (MyString s : myStrings)  {
                System.out.println("value: "+s.getValue());
            }
        }
        return myStrings;
    }

    @DataBoundSetter
    public void setMyStrings(List<MyString> myStrings) {
        System.out.println("DemoGlobalConfig.setMyStrings("+myStrings+")");
        this.myStrings = myStrings;
    }
}
