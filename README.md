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

Watch the Jenkins log. You should messages that correspond to each
action performed under the hood by Jenkins when you access the global
configuration page or when you run the plugin. Use these messages to
trace the execution in the code and learn how Jenkins operate.

