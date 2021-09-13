def restult_fail=false
pipeline {
    agent any
    stages {
        stage("A") {
            options {
                timeout(time: 3, unit: "SECONDS")
            }

            steps {
                catchError(buildResult: 'ABORTED', stageResult: 'ABORTED') {
                    echo "Started stage A"
                    restult_fail = true
                    sleep(time: 5, unit: "SECONDS")
                }
            }
        }

        stage("B") {
            steps {
                catchError(buildResult: 'ABORTED', stageResult: 'ABORTED') {
                                    if("${myVariable}"){
                                     error "Error occured"
                                    }
                                    echo "Started stage B"
                                    sleep(time: 5, unit: "SECONDS")
                                }

            }
        }
    }
}