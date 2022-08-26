pulumi stack output kubeconfig --show-secrets > kubeconfig.yaml
set KUBECONFIG=%cd%\kubeconfig
kubectl version
kubectl cluster-info
kubectl get nodes


https://ap-south-1.console.aws.amazon.com/ec2/v2/home?region=ap-south-1#Instances:
https://ap-south-1.console.aws.amazon.com/ec2/v2/home?region=ap-south-1#SecurityGroups:


https://www.pulumi.com/registry/packages/aws/installation-configuration/
aws configure