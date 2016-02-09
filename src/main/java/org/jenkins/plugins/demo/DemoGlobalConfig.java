package org.jenkins.plugins.demo;

import hudson.Extension;
import jenkins.model.GlobalConfiguration;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundSetter;
import org.kohsuke.stapler.StaplerRequest;

@Extension
public class DemoGlobalConfig extends GlobalConfiguration {

     private String globalVar;

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
         // Code commented out is from RobotConfig.java, it works
         //o = o.getJSONObject("demoGlobalConfig");
         //globalVar = o.getString("globalVar");
         //save();
         //return super.configure(req, o);

         // Code below is from DockerPluginConfig.java, it does not seem to work :-(
         System.out.println("DemoGlobalConfig.configure()");
         req.bindJSON(this, o);
         return true;
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

}
