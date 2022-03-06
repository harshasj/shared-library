def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    
    println("the pipeline is loaded")
    // This is where the magic happens - put your pipeline snippets in here, get variables from config.
    node {
        stage("Code checkout"){
        checkout scm
        }
        stage("Build"){
            sh( script: "${config.buildCommand}" , returnStdout: true).trim()
        }
        stage("clean up"){
        cleanWs()
        }
    }
}
