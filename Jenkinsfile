node {
    def scmVars
    stage('build') {
      // Use Maven Tool
      env.PATH="${tool 'M3'}/bin:${env.PATH}"
      scmVars = checkout scm
      sh 'mvn clean install'
    }

    stage('Deploy') {

      def environment = "Prod"
      def description = "Deploying my branch"
      def ref = scmVars.GIT_COMMIT
      def url = scmVars.GIT_URL
      def owner = ""
      def repo = ""
      def deployURL = "https://api.github.com/repos/${owner}/${repo}/deployments"
      def deployBody = '{"ref": "' + ref +'","environment": "' + environment  +'","description": "' + description + '"}'
      def matcher = url =~ /(?:[^\/]*\/){3}(.*)\/(.*)/;
      println matcher[0][1]
      println matcher[0][2]

      println ref
      println url
      /*
      // Create new Deployment using the GitHub Deployment API
      def response = httpRequest authentication: 'issc29-GH', httpMode: 'POST', requestBody: deployBody, responseHandle: 'STRING', url: deployURL
      if(response.status != 201) {
          error("Deployment API Create Failed: " + response.status)
      }

      // Get the ID of the GitHub Deployment just created
      def responseJson = readJSON text: response.content
      def id = responseJson.id
      if(id == "") {
          error("Could not extract id from Deployment response")
      }

      // Execute Deployment
      // mvn deploy:deploy

      //def result = 'failure'
      def result = 'success'

      def deployStatusBody = '{"state": "' + result + '","target_url": "http://github.com/deploymentlogs"}'
      def deployStatusURL = "https://api.github.com/repos/${owner}/${repo}/deployments/${id}/statuses"
      def response2 = httpRequest authentication: 'issc29-GH', httpMode: 'POST', requestBody: deployStatusBody , responseHandle: 'STRING', url: deployStatusURL
      if(response2.status != 201) {
        error("Deployment Status API Update Failed: " + response2.status)
      }
      */

   }
}
