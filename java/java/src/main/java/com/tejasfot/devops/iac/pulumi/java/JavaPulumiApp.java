package com.tejasfot.devops.iac.pulumi.java;

import com.pulumi.Pulumi;
import com.pulumi.core.Output;

public class JavaPulumiApp
{
    public static void main(String[] args) {
        Pulumi.run(ctx -> {
            ctx.export("exampleOutput", Output.of("example"));
        });
    }
}
