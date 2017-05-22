# Text Decarator with Integrations

A simple utility for manipulating text

# Description

This Repo is based off of the [Text Decarator](https://github.com/birds-of-a-feather/dc-summit-integration-workshop-ci-java) App but has a number of different external integrations already set up:
- JIRA - When you commit to GitHub, JIRA also detects the changes and marks the development in JIRA
- Jenkins - After a commit or PR, a Jenkins CI build runs
- SonarQube - SonarQube reports back the status using the Status API
- CircleCI - After a commit or PR, a CircleCI build runs
- Slack - Branches and commits are sent to a slack channel
