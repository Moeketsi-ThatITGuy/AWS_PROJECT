# Building Scalable Applications on AWS: A Journey from Configuration to Stress TestingBuilding Scalable Applications on AWS: A Journey from Configuration to Stress Testing

 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(291).png "Scalable Architecture")

Scaling applications effectively is a cornerstone of cloud architecture. In this project, I set out to design, implement, and stress-test a scalable application using AWS services. From configuring an Application Load Balancer (ALB) and Auto Scaling Groups (ASG) to troubleshooting scaling triggers and optimizing performance, this journey was filled with lessons on building reliable and efficient cloud infrastructure.
This write-up captures the full process, including setup, challenges, solutions, and key takeaways, offering insights for anyone looking to explore AWS's scaling capabilities

## Project Overview
Setup & Configuration
1. Initial EC2 Instances and Load Balancer Setup
   
 Started with two running instances.
 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(23).png "EC2 Instances")

 Installed a basic Spring Boot application to handle HTTP GET requests and used the bash script to archieve that automatically when the instance is initialized.
 
 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(15).png "SpringBoot App")

 The bash script that automates the starting up of the application
 
 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(43).png "SpringBoot App")
  
## Application Load Balancer (ALB):
Configured the ALB to route traffic to EC2 instances using a target group.

 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(21).png "SpringBoot App")


To make sure that the ALB was set up correctly i then used the ALB DNS URL to check if it works.

 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(22).png "SpringBoot App")

## Auto Scaling Group (ASG)
### Configured an ASG with the following settings:
Desired Capacity: 2 instances.
Minimum Capacity: 2 instances.
Maximum Capacity: 4 instances.


