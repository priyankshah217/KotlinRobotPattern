pipeline {
    agent any
    def restult_fail=false
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
                                    if(restult_fail){
                                     error "Error occured"
                                    }
                                    echo "Started stage B"
                                    sleep(time: 5, unit: "SECONDS")
                                }

            }
        }
    }
}