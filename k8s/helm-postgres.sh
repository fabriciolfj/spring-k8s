#!/usr/bin/env bash
# Installs a PostgreSQL instance into microk8s via Helm (bitnami chart),
# configured with the same credentials/database the app expects.

RELEASE_NAME="${RELEASE_NAME:-postgres}"
NAMESPACE="${NAMESPACE:-default}"
POSTGRES_USER="${POSTGRES_USER:-root}"
POSTGRES_PASSWORD="${POSTGRES_PASSWORD:-root}"
POSTGRES_DB="${POSTGRES_DB:-product}"
POSTGRES_NODE_PORT="${POSTGRES_NODE_PORT:-30432}"

echo ">> Enabling required microk8s addons (helm3, hostpath-storage)..."
microk8s enable helm3
microk8s enable hostpath-storage || microk8s enable storage

echo ">> Adding bitnami helm repo..."
microk8s helm3 repo add bitnami https://charts.bitnami.com/bitnami
microk8s helm3 repo update

echo ">> Installing/upgrading '${RELEASE_NAME}' in namespace '${NAMESPACE}'..."
microk8s helm3 upgrade --install "${RELEASE_NAME}" bitnami/postgresql \
  --namespace "${NAMESPACE}" --create-namespace \
  --set auth.username="${POSTGRES_USER}" \
  --set auth.password="${POSTGRES_PASSWORD}" \
  --set auth.database="${POSTGRES_DB}" \
  --set primary.persistence.size=1Gi \
  --set primary.service.type=NodePort \
  --set primary.service.nodePorts.postgresql="${POSTGRES_NODE_PORT}"

NODE_IP=$(microk8s kubectl get nodes -o jsonpath='{.items[0].status.addresses[?(@.type=="InternalIP")].address}')

echo ">> Done. Postgres is reachable at:"
echo "   - inside the cluster: ${RELEASE_NAME}-postgresql.${NAMESPACE}.svc.cluster.local:5432 (db=${POSTGRES_DB}, user=${POSTGRES_USER})"
echo "   - outside the cluster: ${NODE_IP}:${POSTGRES_NODE_PORT} (db=${POSTGRES_DB}, user=${POSTGRES_USER})"