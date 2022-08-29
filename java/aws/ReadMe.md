Aws API are

HTTP API - Used by Terraform provider, this terraform driver is used by pulumi internally AWS Classic Provider
REST API
Cloud Formation
CDK
CCA - Cloud Control API - AWS Native Provider uses this, fast, however functionality is limited as AWS cca are not complete by aws itself – Native Drivers depend on this API
PULUMI

aws configure
aws --version
aws eks update-kubeconfig --region region-code --name my-cluster
kubectl get svc
aws eks update-kubeconfig --name eks-cluster-eksCluster-af6f0f3
https://docs.aws.amazon.com/eks/latest/userguide/create-kubeconfig.html

pulumi config set aws-native:region ap-south-1

aws s3 ls