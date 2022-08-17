package com.tejasoft.devops.iac.pulumi.gradle;

import com.pulumi.Pulumi;
import com.pulumi.core.Output;

public final class GradlePulumiApp
{
    public static void main(final String[] aArgs)
    {
	Pulumi.run(ctx -> {
	    ctx.export("exampleOutput", Output.of("example"));
	});
    }
}
