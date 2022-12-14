package com.tejasoft.devops.iac.pulumi;

import com.pulumi.Pulumi;
import com.pulumi.azurenative.resources.ResourceGroup;
import com.pulumi.azurenative.storage.StorageAccount;
import com.pulumi.azurenative.storage.StorageAccountArgs;
import com.pulumi.azurenative.storage.StorageFunctions;
import com.pulumi.azurenative.storage.enums.Kind;
import com.pulumi.azurenative.storage.enums.SkuName;
import com.pulumi.azurenative.storage.inputs.ListStorageAccountKeysArgs;
import com.pulumi.azurenative.storage.inputs.SkuArgs;
import com.pulumi.core.Output;
import com.pulumi.deployment.InvokeOptions;

public final class AzureStoragePulumiApp
{
    public static void main(final String[] aArgs)
    {
	Pulumi.run(ctx -> {
	    var resourceGroup = new ResourceGroup("azhw");
	    var storageAccount = new StorageAccount("sea", StorageAccountArgs.builder()
									     .resourceGroupName(resourceGroup.name())
									     .sku(SkuArgs.builder()
											 .name(SkuName.Standard_LRS)
											 .build())
									     .kind(Kind.StorageV2)
									     .build());

	    var primaryStorageKey = getStorageAccountPrimaryKey(resourceGroup.name(),
								storageAccount.name());

	    ctx.export("primaryStorageKey", primaryStorageKey);
	});
    }

    private static Output<String> getStorageAccountPrimaryKey(final Output<String> aResourceGroupName,
							      final Output<String> aAccountName)
    {
	return Output.tuple(aResourceGroupName, aAccountName)
		     .apply(tuple -> {
			 var actualResourceGroupName = tuple.t1;
			 var actualAccountName = tuple.t2;
			 var invokeResult = StorageFunctions
				 .listStorageAccountKeys(ListStorageAccountKeysArgs
								 .builder()
								 .resourceGroupName(actualResourceGroupName)
								 .accountName(actualAccountName)
								 .build(),
							 InvokeOptions.Empty);
			 return Output.of(invokeResult)
				      .applyValue(r -> r.keys()
							.get(0)
							.value())
				      .asSecret();
		     });
    }
}
