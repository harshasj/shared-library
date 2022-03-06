import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call(body){

    def config = [:]
    body.resolveStrategy = Closure.DElEGATE_FIRST
    body.delegate = config
    body ()
    def params = [:]
    params = config 
    println("the library started")
    pipeline{
        agent any 
        stages {
            stage("library"){
                steps {
                    def my_name= config.name
                    sh """
                    echo "the library loaded ${my_name} "
                    """
                }
            }
        }
    }
}
