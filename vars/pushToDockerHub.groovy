// vars/pushToDockerHub.groovy

def call(String imageName, String credentialsId) {
    echo "Pushing image to Docker Hub"

    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {

        sh """
            docker login -u $DOCKER_USER -p $DOCKER_PASS
            docker tag ${imageName} $DOCKER_USER/${imageName}
            docker push $DOCKER_USER/${imageName}
        """
    }

    echo "Push completed"
}
