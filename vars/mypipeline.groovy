import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def call (body){

    def config = [:]
    body.resolveStrategy = Closure.DElEGATE_FIRST
    body.delegate = config
    body ()
    pipeline{
        agent any 
        stages {
            stage("library"){
                steps {
                    sh """
                    echo "the library loaded "
                    """
                }
            }
        }
    }
}
