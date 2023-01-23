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
(1, 'dev dept', 'bianchengbang_jdbc'),
(2, 'hr dept', 'bianchengbang_jdbc'),
(3, 'finance dept', 'bianchengbang_jdbc'),
(4, 'marketing dept', 'bianchengbang_jdbc'),
(5, 'admin dept', 'bianchengbang_jdbc');

And then
start service "micro-service-cloud-eureka-7001" by running the SpringBoot Application
at micro-service-cloud-eureka-7001/src/main/java/com/luxbp/MicroServiceCloudEureka7001Application.java

start service "micro-service-cloud-provider-dept-8001" by running the SpringBoot Application
at micro-service-cloud-provider-dept-8001/src/main/java/com/luxbp/MicroServiceCloudProviderDept8001Application.java