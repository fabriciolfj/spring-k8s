#!/usr/bin/env bash


cd "$(dirname "$0")/.."

IMAGE_NAME="product-service"
IMAGE_TAG="0.0.1-SNAPSHOT"
FULL_IMAGE="${IMAGE_NAME}:${IMAGE_TAG}"

echo ">> Building image ${FULL_IMAGE} with Spring Boot Buildpacks..."
./gradlew bootBuildImage --imageName="${FULL_IMAGE}"

echo ">> Importing ${FULL_IMAGE} into microk8s..."
docker save "${FULL_IMAGE}" | microk8s ctr image import -

echo ">> Done. '${FULL_IMAGE}' is now available inside microk8s (imagePullPolicy: IfNotPresent)."