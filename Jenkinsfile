node {
    def scmVars

    stage('build') {

      // Use Maven Tool
      env.PATH="${tool 'M3'}/bin:${env.PATH}"
      scmVars = checkout scm

      // Run Build
      sh '_JAVA_OPTIONS=-Djdk.net.URLClassPath.disableClassPathURLCheck=true mvn clean install'
    }

    stage('Deploy') {

   }
    
}
