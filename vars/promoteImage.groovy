def call(
    String imageName,
    String imageTag,
    String environment
) {

    def sourceImage = "${imageName}:${imageTag}"
    def targetImage = "${imageName}:${environment}-${imageTag}"

    echo "========================================"
    echo "PROMOTING IMAGE"
    echo "Source : ${sourceImage}"
    echo "Target : ${targetImage}"
    echo "========================================"

    sh """
        docker pull ${sourceImage}

        docker tag \
            ${sourceImage} \
            ${targetImage}

        docker push ${targetImage}
    """

    echo "Image promoted successfully:"
    echo "${targetImage}"
}
