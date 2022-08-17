package com.tejasoft.devops.iac.pulumi.gcp;

import com.pulumi.Pulumi;
import com.pulumi.gcp.storage.Bucket;
import com.pulumi.gcp.storage.BucketArgs;

public class GCPPulumiApp
{
    public static void main(String[] args) {
        Pulumi.run(ctx -> {
            var bucket = new Bucket("1nag234my-bucket",
                                    BucketArgs.builder()
                                    .location("US")
                                    .build());
            ctx.export("bucketName", bucket.url());
        });
    }
}
