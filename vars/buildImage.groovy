// vars/buildImage.groovy

def call(String imageName = 'cicdproject:latest') {
    echo "This is building the code"

    sh "docker build -t ${imageName} ."

    echo "Build is completed"
}
