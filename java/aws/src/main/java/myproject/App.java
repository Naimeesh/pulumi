package myproject;

import com.pulumi.Pulumi;
import com.pulumi.aws.s3.Bucket;

import java.util.stream.IntStream;

public class App
{
    public static void main(String[] args)
    {
	String[] buckNames = {"eewwewewe","nage", "rajai", "ramesh"};

	Pulumi.run(ctx -> {
	    IntStream.range(0, buckNames.length)
		     .forEach(i -> {
			 var bucket = new Bucket(buckNames[i]);
			 ctx.export("bucketName" + i, bucket.bucket());
		     });
	});
    }
}
