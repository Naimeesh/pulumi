start docker for windows on local machine
kubectl get all
kubectl config get-contexts
kubectl get nodes
kubectl get pods
kubectl cluster-info
kubectl cluster-info dump

set KUBECONFIG=%UserProfile%\.kube\config
minikube start --kubernetes-version=v1.24.3

minikube start --driver=docker
minikube start --vm-driver hyperv --hyperv-virtual-switch "Minikube Switch" does not work


pulumi new kubernetes-java
pulumi up

