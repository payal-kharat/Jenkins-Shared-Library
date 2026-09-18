def call(
    String namespace,
    String deploymentName,
    String containerName,
    String image,
    String manifest
) {

    def serviceManifest = manifest.replace(
        '-deployment.yaml',
        '-service.yaml'
    )

    sh """
        kubectl apply \
            -f ${manifest} \
            -n ${namespace}

        if [ -f "${serviceManifest}" ]; then
            kubectl apply \
                -f ${serviceManifest} \
                -n ${namespace}
        fi

        kubectl -n ${namespace} set image \
            deployment/${deploymentName} \
            ${containerName}=${image}

        kubectl -n ${namespace} rollout status \
            deployment/${deploymentName}
    """
}
