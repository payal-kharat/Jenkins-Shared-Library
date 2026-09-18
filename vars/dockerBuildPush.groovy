def call(String imageName, String imageTag, String dockerfile, String context) {

    def image = "${imageName}:${imageTag}"

    sh """
        docker build \
            -f ${dockerfile} \
            -t ${image} \
            ${context}
    """
    sh """
        docker push ${image}
    """

    echo "Image successfully built and pushed:"
    echo "${image}"
}
