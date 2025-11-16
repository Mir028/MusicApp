# Music App – DevOps Showcase

This is a **Spring Boot Music App** with a **PostgreSQL** database, developed and configured as a complete **DevOps solution**. The project demonstrates practical use of containerization, CI/CD, and Kubernetes orchestration.

---

## DevOps Features

- **Docker:** Both the application and database are containerized for easy deployment.
- **Docker Compose:** Orchestrates the app and database together.
- **CI/CD:**  
  - **GitHub Actions** pipeline automatically builds Docker images on every push.  
  - Images are pushed to DockerHub.  
- **Kubernetes:**  
  - Deployment with ConfigMaps and Secrets for the application  
  - Service and Ingress for external access  
  - StatefulSet for PostgreSQL database  
  - All resources deployed in a separate namespace for testing

