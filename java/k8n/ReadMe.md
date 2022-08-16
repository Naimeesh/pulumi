start docker for windows on local machine</br>
kubectl get all</br>
kubectl config get-contexts</br>  
kubectl get nodes</br>
kubectl get pods</br>
kubectl cluster-info</br> 
kubectl cluster-info dump</br>  

set KUBECONFIG=%UserProfile%\.kube\config</br>  
minikube start --kubernetes-version=v1.24.3</br>  this works
  
minikube start --driver=docker</br>

minikube start --vm-driver hyperv --hyperv-virtual-switch "Minikube Switch" does not work</br>  

pulumi new kubernetes-java</br>
pulumi up</br>

