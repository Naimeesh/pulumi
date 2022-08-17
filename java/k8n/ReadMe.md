https://www.pulumi.com/docs/get-started/kubernetes/
https://kubernetes.io/docs/tasks/tools/

start docker for windows on local machine</br>
minikube start --kubernetes-version=v1.24.3</br>  this works, even when dockerdesktop is not enabled with k8n
kubectl get service
kubectl port-forward service/nginx-7fe19a05 8080:80
http://127.0.0.1:8080/


kubectl get all</br>
kubectl config get-contexts</br>  
kubectl get nodes</br>
kubectl get pods</br>
kubectl cluster-info</br> 
kubectl cluster-info dump</br>

set KUBECONFIG=%UserProfile%\.kube\config</br>

minikube start --driver=docker</br>

minikube start --vm-driver hyperv --hyperv-virtual-switch "Minikube Switch" does not work</br>  

pulumi new kubernetes-java</br>
pulumi up</br>
</br>
https://app.pulumi.com/nagkumar/k8n/dev/updates/17</br>


pulumi destroy -s nagkumar/k8n/dev
pulumi stack rm nagkumar/k8n/dev

kubectl version --client --output=yaml

pulumi config set isMinikube true

pulumi destroy