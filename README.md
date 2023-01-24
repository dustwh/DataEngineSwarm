# DataEngineSwarm
 LBP Data Engine Based on Micro Services Architecture

rest api based on Microservices, test address:
http://localhost:8001/dept/list
http://localhost:8001/dept/get/1

In order to run this demo, you need a MySQL server (localhost:3306)
Create a db with name of "luxbp_demo_jdbc"

Then run:

DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
`dept_no` int NOT NULL AUTO_INCREMENT,
`dept_name` varchar(255) DEFAULT NULL,
`db_source` varchar(255) DEFAULT NULL,
PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `dept` (`dept_no`, `dept_name`, `db_source`) VALUES
(1, 'dev dept', 'jdbc1'),
(2, 'hr dept', 'jdbc1'),
(3, 'finance dept', 'jdbc1'),
(4, 'marketing dept', 'jdbc1'),
(5, 'admin dept', 'jdbc1');

And then
start service "micro-service-cloud-eureka-7001" by running the SpringBoot Application
at micro-service-cloud-eureka-7001/src/main/java/com/luxbp/MicroServiceCloudEureka7001Application.java

start service "micro-service-cloud-provider-dept-8001" by running the SpringBoot Application
at micro-service-cloud-provider-dept-8001/src/main/java/com/luxbp/MicroServiceCloudProviderDept8001Application.java


For Cluster version:

edit host file at
(for windows) C:/Windows/System/drivers/etc/hosts
(for Mac, may need sudo) vim /etc/hosts
add these lines below to host
#Spring Cloud eureka cluster
127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
127.0.0.1 eureka7003.com
this is to simulate that the three service is deployed on different server.

(service discover cluster:)
run MicroServiceCloudEureka7001Application
run MicroServiceCloudEureka7002Application
run MicroServiceCloudEureka7003Application

(service provider:)
run MicroServiceCloudProviderDept8001Application

then 8001 will be registered to the three discover server cluster.

for test functions, still visit:
http://localhost:8001/dept/list
http://localhost:8001/dept/get/1

please visit
http://eureka7001.com:7001/
http://eureka7002.com:7002/
http://eureka7003.com:7003/
to check the status of each discover server respectively.