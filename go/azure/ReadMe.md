https://cuelang.org/docs/install/
https://go.dev/dl/
go install cuelang.org/go/cmd/cue@latest


az login
az account list
az account show --query id -o tsv
az account list --query '[].{subscriptionName:name,subscriptionId:id}' -o tsv

az account set --subscription=8e597356-9be8-4f38-bcb5-1805b8822559


pulumi convert --language python --out ./bucket-py
pulumi convert --language java --out ./bucket-java

pulumi up -y
