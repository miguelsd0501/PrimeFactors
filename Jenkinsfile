node {
    stage 'Clone the project'
    git 'https://github.com/miguelsd0501/PrimeFactors.git'
   
        stage("Compilation and Analysis") {
            parallel 'Compilation': {
                sh "mvn clean install -DskipTests"
            }, 'Static Analysis': {
                stage("SonarQube Scanner") {
                    withSonarQubeEnv('sonarqube') {
                      sh 'mvn sonar:sonar'
                    } // SonarQube taskId is automatically attached to the pipeline context
                    // No need to occupy a node
                    stage("Quality Gate"){
                      timeout(time: 10, unit: 'MINUTES') {
                            waitForQualityGate abortPipeline: true
                       }
                    }
                }
            }
        }
         

            stage("Runing unit tests") {
                    try {
                        sh "mvn test -Punit"
                    } catch(err) {
                        step([$class: 'JUnitResultArchiver', testResults: 
                          '**/target/surefire-reports/TEST-*UnitTest.xml'])
                        throw err
                    }
                   step([$class: 'JUnitResultArchiver', testResults: 
                     '**/target/surefire-reports/TEST-*UnitTest.xml'])
             }

}