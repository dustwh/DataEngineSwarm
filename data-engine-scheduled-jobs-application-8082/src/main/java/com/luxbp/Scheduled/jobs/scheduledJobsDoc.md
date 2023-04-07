## Important features
This file lists other important features that spring scheduling supports but I don't provide a show case:

###
##### Delaying the First Execution with Initial Delay
With both fixedDelay and fixedRate, the first invocation of the method starts immediately after the application context is initialized. However, we can choose to delay the first execution of the method by specifying the interval using the initialDelay attribute

###
##### Specifying Intervals in ISO Duration Format
So far in our examples, we have specified the time interval in milliseconds. Specifying higher values of an interval in hours or days which is most often the case in real situations is difficult to read.

So instead of specifying a large value like 7200000 for 2 hours, we can specify the time in the ISO duration format like PT02H.

The @Scheduler annotation provides the attributes fixedRateString and fixedDelayString which take the interval in the ISO duration format

###
##### Externalizing the Interval to a Properties File (application.yml)
We can also reference a property value from our properties file as the value of fixedDelayString or fixedRateString attributes to externalize the interval values. In the code, we can get interval using: ` @Scheduled(fixedDelayString = "${interval}")`

###
##### Using Cron Expressions to Define the Interval
We can also specify the time interval in UNIX style cron-like expression for more complex scheduling requirements: `@Scheduled(cron = "${interval-in-cron}")`

## Other libs that are usually working togther with scheduler

###
##### Deploying Multiple Scheduler Instances with ShedLock
As we have seen so far with Spring Scheduler, it is very easy to schedule jobs by attaching the @Scheduler annotation to methods in Spring Beans. However, in distributed environments when we deploy multiple instances of our application, it cannot handle scheduler synchronization over multiple instances. Instead, it executes the jobs simultaneously on every node.

ShedLock is a library that ensures our scheduled tasks when deployed in multiple instances are executed at most once at the same time. It uses a locking mechanism by acquiring a lock on one instance of the executing job which prevents the execution of another instance of the same job.

ShedLock uses an external data store shared across multiple instances for coordination. like Mongo, any JDBC database, Redis, Hazelcast, ZooKeeper, or others for coordination.

ShedLock is designed to be used in situations where we have scheduled tasks that are not ready to be executed in parallel but can be safely executed repeatedly. Moreover, the locks are time-based and ShedLock assumes that clocks on the nodes are synchronized.

###
##### Conditions for using Distributed Job Scheduler Quartz
Quartz Scheduler (http://www.quartz-scheduler.org/) is an open-source distributed job scheduler that provides many enterprise-class features like support for JTA transactions and clustering.

Among its main capabilities is job persistence support to an external database that is very useful for resuming failed jobs as well as for reporting purposes.

Clustering is another key feature of Quartz that can be used for Fail-safe and/or Load Balancing.

Spring Scheduler is preferred when we want to implement a simple form of job scheduling like executing methods on a bean every X seconds, or on a cron schedule without worrying about any side-effects of restarting jobs after failures.

On the other hand, if we need clustering along with support for job persistence then Quartz is a better alternative.