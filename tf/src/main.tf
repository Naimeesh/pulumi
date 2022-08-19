// Specify the provider and access details
provider "aws" {
    region = var.aws_region
}
resource "aws_eip" "default" {
    instance = aws_instance.web.id
    vpc = true
}
// Our default security group to access
// the instances over SSH and HTTP
resource "aws_security_group" "default" {
    description = "Used in the terraform"
    // outbound internet access
    egress = [{
        cidr_blocks = ["0.0.0.0/0"]
        from_port = 0
        protocol = "-1"
        to_port = 0
    }]
    ingress = [
        // SSH access from anywhere
        {
            cidr_blocks = ["0.0.0.0/0"]
            from_port = 22
            protocol = "tcp"
            to_port = 22
        },
        // HTTP access from anywhere
        {
            cidr_blocks = ["0.0.0.0/0"]
            from_port = 80
            protocol = "tcp"
            to_port = 80
        },
    ]
    name = "eip_example"
}
resource "aws_instance" "web" {
    // Lookup the correct AMI based on the region
    // we specified
    ami = lookup(var.aws_amis, var.aws_region)
    instance_type = "t2.micro"
    // Our Security group to allow HTTP and SSH access
    security_groups = [aws_security_group.default.name]
    //Instance tags
    tags = {
        Name = "eip-example"
    }
    // We run a remote provisioner on the instance after creating it.
    // In this case, we just install nginx and start it. By default,
    // this should be on port 80
    user_data = file("userdata.sh")
}
