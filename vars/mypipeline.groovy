def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    
    println("the pipeline is loaded")
    // This is where the magic happens - put your pipeline snippets in here, get variables from config.
    node {
        stage("Test"){
            
            println("the value paased is ${config.name}")
        
        }
    }
}
