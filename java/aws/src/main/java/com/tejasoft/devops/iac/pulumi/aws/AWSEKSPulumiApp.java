package com.tejasoft.devops.iac.pulumi.aws;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.eks.Cluster;

import java.util.Map;

public final class AWSEKSPulumiApp
{
    public static void main(final String[] aArgs) {
	Pulumi.run(AWSEKSPulumiApp::stack);
    }

    private static void stack(final Context aContext) {
	final var cluster = new Cluster("eks-cluster");
	aContext.export("kubeconfig", cluster.kubeconfig());

	aContext.log().info("message");
	//aContext.log().info("message", resource);
	aContext.log().debug("hidden by default");
	aContext.log().warn("warning");
	aContext.log().error("fatal error");
	aContext.projectName();

	var lConfig = aContext.config();
	var name = lConfig.require("name");
	var lucky = lConfig.getInteger("lucky").orElse(42);
	aContext.log().info(String.format("Hello, %s -- I see your lucky number is %s!", name, lucky));
	var data = lConfig.requireObject("data", Map.class);
	aContext.log().info(String.format("Active: %s", data.get("active")));
	aContext.stackName();
	aContext.log().info(String.format("Password: %s", lConfig.require("dbPassword")));
    }
}
