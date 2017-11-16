# Jenkins - GitHub Deployment API

This repo demonstrates how to post back to the [GitHub Deployment API](https://developer.github.com/v3/repos/deployments/) from a [Jenkins Pipeline](https://jenkins.io/doc/book/pipeline/). See the [Jenkinsfile](Jenkinsfile) for the exact Pipeline.

## Requirements

1. Create a Multibranch Pipeline (or use GitHub Organization Folders) within Jenkins that references this repository.
2. Install the [HTTP Request Plugin](https://plugins.jenkins.io/http_request) and the [Pipeline Utility Steps](https://plugins.jenkins.io/pipeline-utility-steps) on Jenkins.
3. Add a branch, make a modification, and create a Pull Request in GitHub.
4. Run the pipeline jobs again and you should see the deployment recorded in the Pull Request

## How it Works

The Jenkins pipeline has 2 stages: build and deploy.
    - Build Stage:
      - Maven command is run to build the project.
     - Deploy Stage
       - Creates a GitHub Deployment via API using the HTTP Request Plugin
       - Saves the deployment id of the deployment just created
       - Executes the deployment
       - Creates a GitHub Deployment Status based on the outcome of the deployment via API using the HTTP Request Plugin

## License

The project is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
