pulumi new java
pulumi new java-gradle

pulumi up -y (https://www.pulumi.com/docs/reference/cli/pulumi_up/)

pulumi stack
pulumi stack ls
pulumi stack init staging
pulumi stack init broomllc/staging
pulumi stack select jane-dev
pulumi destroy
pulumi stack rm --force
pulumi stack export --file stack.json
pulumi stack import --file stack.json