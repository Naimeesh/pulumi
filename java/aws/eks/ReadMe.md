pulumi stack output kubeconfig --show-secrets > kubeconfig.yaml
set KUBECONFIG=%cd%\kubeconfig
kubectl version
kubectl cluster-info
kubectl get nodes

https://ap-south-1.console.aws.amazon.com/ec2/v2/home?region=ap-south-1#Instances:
https://ap-south-1.console.aws.amazon.com/ec2/v2/home?region=ap-south-1#SecurityGroups:


https://www.pulumi.com/registry/packages/aws/installation-configuration/
aws configure

aws eks describe-cluster --cluster-name <cluster-name>  --query cluster.endpoint
kubectl edit -n kube-system configmap/aws-auth
curl -o aws-iam-authenticator.exe https://s3.us-west-2.amazonaws.com/amazon-eks/1.21.2/2021-07-05/bin/windows/amd64/aws-iam-authenticator.exe
https://docs.aws.amazon.com/eks/latest/userguide/create-cluster.html
