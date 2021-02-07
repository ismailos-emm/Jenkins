
def buildApp() {
    echo "Building Stage ..."
    echo "Build for version ${BUILD_VERSION}"
}

def testApp() {
    echo "Testing Stage ..."
}

def deployApp() {
    echo "Deploying Stage ..."
    echo "Deploying version ${params.Version}"    
}

return this

