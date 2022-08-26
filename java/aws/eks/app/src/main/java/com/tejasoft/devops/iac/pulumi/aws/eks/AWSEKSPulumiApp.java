package com.tejasoft.devops.iac.pulumi.aws.eks;

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
    }
}