[//]: # (MAP)
pulumi config set --path 'data.active' true
pulumi config set --path 'data.nums[0]' 1
pulumi config set --path 'data.nums[1]' 2
pulumi config set --path 'data.nums[2]' 3


pulumi config set dbPassword S3cr37 --secret
