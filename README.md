# Building Scalable Applications on AWS: A Journey from Configuration to Stress Testing 

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

 ![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(22).png "ALB")

## Auto Scaling Group (ASG)
### Configured an ASG with the following settings:
Desired Capacity: 2 instances.\
Minimum Capacity: 2 instances.\
Maximum Capacity: 4 instances.

# CloudWatch Metrics and Scaling Policies
## Chose RequestCountPerTarget as the scaling metric:
Added a policy to scale out when the number of requests per target exceeded 100 requests per minute per target.\
![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(36).png "Policy")
Linked the metric to the Auto Scaling Group.

# Stress Testing
## Stress Test Application
Developed a simple Java-based HTTP client to simulate heavy traffic: \
Sent GET requests to the ALB's DNS address. \
Configured the client to run continuously for 10 minutes. 
![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(38).png "Script")

Monitored response codes to verify successful requests (200 OK) and failures.
![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(32).png "Status")

# Observations During Stress Testing
Initially, CPU utilization was used as a metric for scaling, but it failed to trigger scaling actions effectively. \
Switched to RequestCountPerTarget, which accurately measured traffic per instance.

## Observations During Stress Testing
As part of validating the scalability of the architecture, stress testing was conducted using high volumes of HTTP requests.

## Initial Issues:
During the initial configuration, the Auto Scaling Group did not trigger as expected due to missing configurations in the CloudWatch alarm for RequestCountPerTarget.

## Resolution:
After linking the RequestCountPerTarget metric to the Auto Scaling Group and fine-tuning the scaling thresholds, the system responded perfectly to the stress tests.

## Scaling Behavior:
Once the adjustments were in place:

The scaling worked as expected.
The system automatically added EC2 instances when the request load exceeded the threshold (e.g., 100 requests per target).
![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(40).2.png "Provisions")
The additional instances were provisioned seamlessly, ensuring that the application maintained performance without downtime.

To test Auto Scaling's reliability, some EC2 instances were manually shut down. Auto Scaling promptly provisioned new instances to maintain the desired capacity, as specified in the scaling policies
![picture alt](https://github.com/Moeketsi-ThatITGuy/AWS_PROJECT/blob/main/Screenshot%20(40).png "Provisions")

## Result:
The architecture demonstrated its robustness by handling traffic spikes, maintaining performance, and adhering to the scaling policy even during manual disruptions. The system scaled back down when the traffic normalized, confirming the reliability and efficiency of the auto-scaling configuration.

# Challenges and Solutions
## Scaling Issues
Problem: Scaling did not trigger even under high CPU load.
Solution: Shifted to RequestCountPerTarget as a more reliable scaling metric. Verified its functionality by analyzing CloudWatch logs.
## Instance Capacity Confusion
Problem: Auto Scaling Group did not initially consider manually created EC2 instances.
Solution: Manually attached existing instances to the Auto Scaling Group using the “Attach Instances” feature.
## Stress Test Failure
Problem: Early versions of the stress test terminated prematurely or failed to generate sufficient load.
Solution: Optimized the Java code to ensure a steady stream of HTTP requests was sent continuously. Verified performance by logging successful requests.

# Conclusion
This project provided a hands-on experience with AWS Auto Scaling Groups, Application Load Balancers, and stress-testing techniques. It demonstrated the importance of iterative testing, thoughtful metric selection, and persistent troubleshooting in building scalable cloud applications.

