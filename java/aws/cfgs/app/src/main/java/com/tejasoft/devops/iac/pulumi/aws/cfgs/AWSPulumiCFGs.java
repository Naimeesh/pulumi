package com.tejasoft.devops.iac.pulumi.aws.cfgs;

import com.pulumi.Pulumi;

import java.util.Map;

public final class AWSPulumiCFGs
{
    public static void main(final String[] aArgs)
    {
	Pulumi.run(aContext -> {
	    var lConfig = aContext.config();
	    var name = lConfig.require("name");
	    var lucky = lConfig.getInteger("lucky")
			       .orElse(42);
	    aContext.log()
		    .info(String.format("Hello, %s -- I see your lucky number is %s!", name, lucky));
	    var data = lConfig.requireObject("data", Map.class);
	    aContext.log()
		    .info(String.format("Active: %s", data.get("active")));
	    aContext.stackName();
	    aContext.log()
		    .info(String.format("Password: %s", lConfig.require("dbPassword")));
	});
    }
}
