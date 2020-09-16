# Log Aggregation with Springboot, Elastic and Docker

## Components
- Blog Appliation : A simple springboot application which manages posts and comments. Spring Cloud Slueth is used to manage distributed tracing of api calls. LogstashEncoder is used to generate logs in json format.
- Beats : An open source data shippers that can be installed as agents on servers to send operational data to Elasticsearch via Logstash
- Logstash : Collects log data through Filebeat agents, add additional tags and pushes the messages to Elastic.
- Elastic : Storage of log data and indexes.
- Kibaana : A visualization tool to view data from elastic datasource

## Running on Docker
![SpringbootDocker](SpringbootELK.png)

## Local Setup
- Clean and build the spring boot application using gradle.
  ```
  $ cd blog
  $ ./gradlew clean build
  ```
- Build all the docker images required for the application using docker-compose commands
  ```
  $ docker-compose build
  ```
- Start all the application using docker-compose.
  ```
  $ docker-compose up -d
  ```
