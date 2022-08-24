CLI install - https://www.pulumi.com/docs/get-started/install/
Complete Reference : https://www.pulumi.com/docs/reference/cli/

Examples at https://www.pulumi.com/resources/advanced-infrastructure-as-code-2020-04-16/ (AWS, K8N, GCP, Azure) 

pulumi login
pulumi login --local
pulumi login s3://<bucket-name>
pulumi login file:///app/data

pulumi new java</br>
pulumi new java-gradle</br>

pulumi new yaml -f

pulumi up -y</br>
pulumi update -y
pulumi up --diff

pulumi stack</br>
pulumi stack ls</br>
pulumi stack init staging</br>
pulumi stack init dev</br>
pulumi stack init broomllc/staging</br>
pulumi stack select dev
pulumi stack select jane-dev</br>
pulumi destroy</br>
pulumi stack rm --force</br>
pulumi stack rm dev</br>
pulumi stack export --file stack.json</br>
pulumi stack import --file stack.json</br>

pulumi refresh
pulumi logs

https://github.com/pulumi/tutorial-pulumi-fundamentals

https://github.com/pulumi/examples

pulumi cancel

pulumi stack output

pulumi destroy -y
pulumi stack rm --yes

https://www.pulumi.com/registry/
https://www.pulumi.com/docs/intro/concepts/
https://github.com/jonashackt/pulumi-talk

pulumi preview --logtostderr -v=9

pulumi plugin install resource docker
pulumi plugin install resource docker v3.5.0-alpha.1660680787+9d280bb7

docker image rm 22b56b107300

https://www.pulumi.com/docs/guides/testing/


https://github.com/pulumi/examples/tree/74db62a03d013c2854d2cf933c074ea0a3bbf69d/testing-pac-ts

aws.amazon.com

pulumi convert --language python --out ./bucket-py

pulumi stack output kubeconfig --show-secrets > kubeconfig