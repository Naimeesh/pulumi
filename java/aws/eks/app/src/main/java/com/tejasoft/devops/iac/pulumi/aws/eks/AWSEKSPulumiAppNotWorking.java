package com.tejasoft.devops.iac.pulumi.aws.eks;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.eks.Cluster;

public final class AWSEKSPulumiAppNotWorking
{
    public static void main(final String[] aArgs) {
	Pulumi.run(AWSEKSPulumiAppNotWorking::stack);
    }

    private static void stack(final Context aContext) {
	final var cluster = new Cluster("eks-cluster");
	aContext.export("kubeconfig", cluster.kubeconfig());
    }
}
