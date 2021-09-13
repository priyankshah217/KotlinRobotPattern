def restult_fail = false
def random_no = 0
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
                        random_no = new Random().nextInt(100)
                        sleep(time: 5, unit: "SECONDS")
                    }
                }
            }
        }

        stage("B") {
            steps {
                script {
                    catchError(buildResult: 'ABORTED', stageResult: 'ABORTED') {
                        echo "Random no is ${random_no}"
                        if (random_no % 2 == 0) {
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