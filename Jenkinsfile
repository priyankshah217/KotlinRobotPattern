def restult_fail = false
pipeline {
    agent any
    stages {
        stage("A") {
            options {
                timeout(time: 3, unit: "SECONDS")
            }

            steps {
                script {
                    catchError(buildResult: 'ABORTED', stageResult: 'ABORTED') {
                        echo "Started stage A"
                        restult_fail = true
                        sleep(time: 5, unit: "SECONDS")
                    }
                }
            }
        }

        stage("B") {
            steps {
                script {
                    catchError(buildResult: 'ABORTED', stageResult: 'ABORTED') {
                        if (restult_fail) {
                            error "Error occurred"
                        }
                        echo "Started stage B"
                        sleep(time: 5, unit: "SECONDS")
                    }
                }
            }
        }
    }
}