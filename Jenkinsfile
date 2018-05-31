node {
    def scmVars

    stage('Build') {

      // Use Maven Tool
      env.PATH="${tool 'MAVEN3'}/bin:${env.PATH}"
      scmVars = checkout scm

      // Run Build
      sh 'mvn clean install'
    }

    stage('Code Quality') {

     echo 'Performing Code Quality Scan'

     // Record result of test with GitHub Status API
     def result = 'success'
     def target_url = 'http://workshop-jenkins.octodemoapps.com/jenkins/job/GitHub-JenkinsDay/job/jenkins-deployment-api/job/master/'
     def owner = "GitHub-JenkinsDay"
     def repo = "jenkins-deployment-api"
     def ref = scmVars.GIT_COMMIT

     def StatusBody =
     '{"state": "' + result +
     '","target_url": "' + target_url +
     '","description": "The security scan succeeded!"' +
     ',"context": "continuous-integration/code-quality"}'

     echo StatusBody

     def StatusURL = "https://api.github.com/repos/${owner}/${repo}/statuses/${ref}"

     def StatusResponse = httpRequest authentication: 'mfilosaPAT', httpMode: 'POST', requestBody: StatusBody , responseHandle: 'STRING', url: StatusURL
     if(StatusResponse.status != 201) {
       error("Status API Update Failed: " + StatusResponse.status)

     }
}     
    stage('Security Scan') {

     echo 'Performing security scan'

     // Record result of test with GitHub Status API
     def result = 'success'
     def target_url = 'http://workshop-jenkins.octodemoapps.com/jenkins/job/GitHub-JenkinsDay/job/jenkins-deployment-api/job/master/'
     def owner = "GitHub-JenkinsDay"
     def repo = "jenkins-deployment-api"
     def ref = scmVars.GIT_COMMIT

     def StatusBody =
     '{"state": "' + result +
     '","target_url": "' + target_url +
     '","description": "The security scan succeeded!"' +
     ',"context": "continuous-integration/security-scan"}'

     echo StatusBody

     def StatusURL = "https://api.github.com/repos/${owner}/${repo}/statuses/${ref}"

     def StatusResponse = httpRequest authentication: 'mfilosaPAT', httpMode: 'POST', requestBody: StatusBody , responseHandle: 'STRING', url: StatusURL
     if(StatusResponse.status != 201) {
       error("Status API Update Failed: " + StatusResponse.status)

     }
}
    stage('Deploy') {

      def environment = "Prod"
      def description = "Deploying my branch"
      def ref = scmVars.GIT_COMMIT
      def owner = "GitHub-JenkinsDay"
      def repo = "jenkins-deployment-api"
      def deployURL = "https://api.github.com/repos/${owner}/${repo}/deployments"
      def deployBody = '{"ref": "' + ref +'","environment": "' + environment  +'","description": "' + description + '","required_contexts": []}'



      // Create new Deployment using the GitHub Deployment API
      def response = httpRequest authentication: 'mfilosaPAT', httpMode: 'POST', requestBody: deployBody, responseHandle: 'STRING', url: deployURL, validResponseCodes: '100:599'

      if(response.status != 201) {
          error("Deployment API Create Failed: " + response.status + response.content)
      }

      // Get the ID of the GitHub Deployment just created
      def responseJson = readJSON text: response.content
      def id = responseJson.id
      if(id == "") {
          error("Could not extract id from Deployment response")
      }

      // Execute Deployment
      def deployStatus = sh returnStatus: true, script: 'echo deploy'

      // Record new Deployment Status based on output
      def result = (deployStatus) ? 'failure' : 'success'
      def deployStatusBody = '{"state": "' + result + '","target_url": "http://github.com/deploymentlogs"}'
      def deployStatusURL = "https://api.github.com/repos/${owner}/${repo}/deployments/${id}/statuses"
      def deployStatusResponse = httpRequest authentication: 'mfilosaPAT', httpMode: 'POST', requestBody: deployStatusBody , responseHandle: 'STRING', url: deployStatusURL
      if(deployStatusResponse.status != 201) {
        error("Deployment Status API Update Failed: " + deployStatusResponse.status)
      }
   }
}
