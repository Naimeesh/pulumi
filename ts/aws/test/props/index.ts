// Copyright 2016-2020, Pulumi Corporation.  All rights reserved.

import * as awsx from "@pulumi/awsx";
import * as eks from "@pulumi/eks";

// Create a custom VPC.
const vpc = new awsx.ec2.Vpc("my-vpc", {
    cidrBlock: "10.0.0.0/16",
});

// Create a basic EKS cluster.
const cluster = new eks.Cluster("my-cluster", {
    desiredCapacity: 2,
    minSize: 1,
    maxSize: 2,
    storageClasses: "gp2",
    deployDashboard: false,
    version: "1.23",
    vpcId: vpc.id,
    subnetIds: vpc.publicSubnetIds,
});
