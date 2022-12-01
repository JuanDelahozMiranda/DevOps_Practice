# DevOps_Practice

## MundosE

Como parte del entregable final se iniciará por construir la arquitectura a continuación. 
En el presente proyecto se creará un proyecto Base (micrositio) utilizando Springboot + Java, gestionado las dependencias con Maven, el cual será alojado en un repositorio GitHub, luego este será orquestado utilizando Jenkins, también se utilizara Docker como herramienta de contenerización para compilar y desplegar más fácilmente el proyecto hacia otros ambientes. 
Sumado a ello se utilizara Kubernetes como herramienta para gestionar las imágenes creadas y diseñar estrategias de balanceo (replicas). 
También se utilizará Terraform para aprovisionar la infraestructura teniendo como base la configuración de kubernetes

## Herramientas

0. Windows (SO)
1. Git - V2.28.0
2. Java - JDK 8
3. Springboot
4. Maven - V3.8.6
5. Jenkins - V2.380
6. Docker Desktop - V4.14.1
7. Kubernetes - V1.25.2
8. Terraform - V1.3.5

## Comandos utiles

para ejecucion local
- git clone repo
- mvn clean install

para clonar la imagen docker
- docker pull juanphozm/devopspracticejuan:latest

para ejecutar utilizando kubernetes
- kubectl apply -f kubernetefile.yml

para ejecutar con terraform (verifique tener instaldo las herramientas) basado en el .yml de kubernete
- terraform init && terraform apply

Luego si esta todo bien configurado podra verificar su ejecucion en:
- localhost:8080