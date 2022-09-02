package com.tejasoft.devops.iac.pulumi.aws.ntve.ws;

import com.pulumi.Context;
import com.pulumi.Pulumi;
import com.pulumi.asset.FileAsset;
import com.pulumi.aws.s3.BucketObject;
import com.pulumi.aws.s3.BucketObjectArgs;
import com.pulumi.aws.s3.BucketPolicy;
import com.pulumi.aws.s3.BucketPolicyArgs;
import com.pulumi.awsnative.s3.Bucket;
import com.pulumi.awsnative.s3.BucketArgs;
import com.pulumi.awsnative.s3.inputs.BucketWebsiteConfigurationArgs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiConsumer;

public final class AWSNativePulumiWS
{
    public static void main(final String[] aArgs)
    {
	Pulumi.run(AWSNativePulumiWS::stack);
    }

    private static void stack(final Context aContext)
    {
	final var siteBucket = new Bucket("s3-website-bucket",
					  BucketArgs.builder()
						    .websiteConfiguration(
							    BucketWebsiteConfigurationArgs.builder()
											  .indexDocument("index.html")
											  .build())
						    .build());

	final String siteDir = "www/";
	forEachFileInTree(siteDir, (path, contentType) -> {
	    new BucketObject(path.toString().replace(siteDir, ""),
			     BucketObjectArgs.builder().bucket(siteBucket.getId())
					     .source(new FileAsset(path.toAbsolutePath().toString()))
					     .contentType(contentType).build()
	    );
	});

	final var bucketPolicy = new BucketPolicy("bucketPolicy",
						  BucketPolicyArgs.builder().bucket(siteBucket.getId())
								  .policy(siteBucket.arn()
										    .applyValue(bucketArn -> """
											        {
											            "Version":"2012-10-17",
											            "Statement":[{
											                "Effect":"Allow",
											                "Principal":"*",
											                "Action":["s3:GetObject"],
											                "Resource":["%s/*"]
											            }]
											        }
											    """.formatted(bucketArn))
									 ).build());

	aContext.export("bucketName", siteBucket.bucketName());
	aContext.export("websiteUrl", siteBucket.websiteURL());
    }

    private static void forEachFileInTree(final String aSiteDir, final BiConsumer<Path, String> aConsumer)
    {
	try (var paths = Files.walk(Paths.get(aSiteDir)).filter(Files::isRegularFile))
	{
	    paths.forEach(path -> {
		final String contentType;
		try
		{
		    contentType = Files.probeContentType(path);
		}
		catch (final IOException aIOException)
		{
		    throw new RuntimeException(String.format("Failed to probeContentType for path: '%s'", path),
					       aIOException);
		}
		aConsumer.accept(path, contentType);
	    });
	}
	catch (final IOException aIOException)
	{
	    throw new RuntimeException(String.format("Failed to walk a path: '%s'", aSiteDir), aIOException);
	}
    }
}
