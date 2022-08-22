package com.tejasoft.devops.iac.pulumi.docker;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.docker.RemoteImage;
import com.pulumi.docker.RemoteImageArgs;

public final class DockerPulumiApp
{
    public static void main(final String[] aArgs)
    {
	Pulumi.run(DockerPulumiApp::stack);
    }

    private static void stack(final Context aContext)
    {
	final var stackName = aContext.stackName();

	final String backendImageName = "backend";
	var backendImage =
		new RemoteImage(backendImageName,
				RemoteImageArgs.builder()
					       .name(String.format("fundamentals-%s:latest",
								   backendImageName))
					       .build());

	//final String frontendImageName = "frontend";
	//var frontendImage =
	//	new RemoteImage(frontendImageName,
	//			RemoteImageArgs.builder()
	//				       .name(String.format("fundamentals-%s:latest",
	//							   frontendImageName))
	//				       .build());
	//final String mongoImageName = "mongodb";
	//var mongoImage =
	//	new RemoteImage(mongoImageName,
	//			RemoteImageArgs.builder()
	//				       .name(String.format("fundamentals-%s:latest",
	//							   mongoImageName))
	//				       .build());
    }
}