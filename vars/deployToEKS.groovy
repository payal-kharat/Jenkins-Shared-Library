def call(
    String namespace,
    String deploymentName,
    String containerName,
    String image,
    String manifest
) {

    sh """
        kubectl apply \
            -f ${manifest} \
            -n ${namespace}

        kubectl -n ${namespace} set image \
            deployment/${deploymentName} \
            ${containerName}=${image}

        kubectl -n ${namespace} rollout status \
            deployment/${deploymentName}
    """
}
