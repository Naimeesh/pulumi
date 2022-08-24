package com.tejasoft.devops.iac.pulumi.aws;


import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.aws.ec2.Instance;
import com.pulumi.aws.ec2.InstanceArgs;
import com.pulumi.aws.ec2.SecurityGroup;
import com.pulumi.aws.ec2.SecurityGroupArgs;
import com.pulumi.aws.ec2.inputs.SecurityGroupIngressArgs;

import java.util.List;

public final class AWSPulumiWebserver
{
    public static void main(String[] args)
    {
	Pulumi.run(AWSPulumiWebserver::stack);
    }

    public static void stack(Context ctx)
    {
	final var
		group =
		new SecurityGroup("web-sg", SecurityGroupArgs.builder()
							     .description("Enable HTTP access")
							     .ingress(SecurityGroupIngressArgs.builder()
											      .protocol("tcp")
											      .fromPort(80)
											      .toPort(80)
											      .cidrBlocks("0.0.0.0/0")
											      .build())
							     .build());
	final var
		server =
		new Instance("web-server", InstanceArgs.builder()
						       .ami("ami-0481144f8ac538ba7")
						       .instanceType("t2.micro")
						       .vpcSecurityGroupIds(group.name()
										 .applyValue(List::of))
						       .build());
	ctx.export("publicIp", server.publicIp());
	ctx.export("publicDns", server.publicDns());
    }
}
