A Demo of a Jenkins GlobalConfiguration
====

The goal is to understand how to set default values in the UI of our
plugin, using a `GlobalConfiguration`. The `GlobalConfiguration` let
us share the global configuration between multiple extension points
(e.g. a legacy plugin and a Pipeline Step plugin).

Run Jenkins using `hpi::run`

```
mvn hpi:run
```

Watch the Jenkins log. You should see the following message from the
plugin:


```
DescriptorImpl::load()
```

The plugin in its current state prints a lot of debug messages to the
terminal.

Visit the Jenkins global configuration page, look for the section called
"Demo Global Config".

* Set a value for the the "Global Var"
* Set a couple of values for the "String List" (click the Add button)

Save the configuration page. Reopen it. The global value is present,
but the list of strings is not. Why?

Note that the config.xml was saved and does contain all the values,
as shown here:

```
$ cat work/org.jenkins.plugins.demo.DemoGlobalConfig.xml
<?xml version='1.0' encoding='UTF-8'?>
<org.jenkins.plugins.demo.DemoGlobalConfig plugin="jenkins-plugin-demo1@1.0-SNAPSHOT">
  <globalVar>a global value</globalVar>
  <myStrings>
    <org.jenkins.plugins.demo.MyString>
      <value>value1</value>
    </org.jenkins.plugins.demo.MyString>
    <org.jenkins.plugins.demo.MyString>
      <value>value2</value>
    </org.jenkins.plugins.demo.MyString>
  </myStrings>
</org.jenkins.plugins.demo.DemoGlobalConfig>
```
