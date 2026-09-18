def call(
    String namespace,
    String deploymentName,
    String containerName,
    String image
) {

    sh """
        kubectl -n ${namespace} set image \
            deployment/${deploymentName} \
            ${containerName}=${image}

        kubectl -n ${namespace} rollout status \
            deployment/${deploymentName}
    """

    echo "Deployment completed successfully."
}
