package com.tejasoft.devops.iac.pulumi.docker;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.docker.RemoteImage;
import com.pulumi.docker.RemoteImageArgs;

public final class DockerPullImagePulumiApp
{
    public static void main(final String[] aArgs)
    {
	Pulumi.run(com.tejasoft.devops.iac.pulumi.docker.DockerPullImagePulumiApp::stack);
    }

    private static void stack(final Context aContext)
    {
	final var stackName = aContext.stackName();

	//final String backendImageName = "backend";
	//var backendImage = new RemoteImage(
	//	backendImageName,
	//	RemoteImageArgs.builder()
	//		       .name(String.format("pulumi/tutorial-pulumi-fundamentals-%s:latest",backendImageName))
	//		       .build());
    }
}