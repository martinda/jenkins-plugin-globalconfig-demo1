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

Visit the Jenkins global configuration page, look for the section called
"Demo Global Config". Set a value for the "Global Var". Save the page.

Go back to the global configuration page. The value is missing. Why?
