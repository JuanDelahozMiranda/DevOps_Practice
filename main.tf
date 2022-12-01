resource "null_resource" "deploy-yaml" {

    provisioner "local-exec"{
        command = "kubectl apply -f kubernetefile.yml"
    }
}