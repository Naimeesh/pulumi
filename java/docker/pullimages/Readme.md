Pulls Images of Docker Hub and Launches them on local Docker for Desktop

https://www.pulumi.com/learn/pulumi-fundamentals/configure-and-provision/
https://www.pulumi.com/learn/pulumi-fundamentals/create-docker-images/
https://github.com/pulumi/tutorial-pulumi-fundamentals/

pulumi plugin install resource docker


https://docs.docker.com/get-started/02_our_app/

pulumi config set docker:host "npipe:////.//pipe//docker_engine" 
on windows

This example works both on windows and wsl too, it  had challenges but all got fixed now
