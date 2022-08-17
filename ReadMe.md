CLI install - https://www.pulumi.com/docs/get-started/install/
Complete Reference : https://www.pulumi.com/docs/reference/cli/

Examples at https://www.pulumi.com/resources/advanced-infrastructure-as-code-2020-04-16/ (AWS, K8N, GCP, Azure) 

pulumi login

pulumi new java</br>
pulumi new java-gradle</br>

pulumi up -y</br>

pulumi stack</br>
pulumi stack ls</br>
pulumi stack init staging</br>
pulumi stack init broomllc/staging</br>
pulumi stack select jane-dev</br>
pulumi destroy</br>
pulumi stack rm --force</br>
pulumi stack export --file stack.json</br>
pulumi stack import --file stack.json</br>

pulumi refresh