package ihm.td5


import javafx.application.Application
import javafx.scene.Scene

import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {
       TODO()
        //val scene = Scene(vue, 550.0, 350.0)
        primaryStage.title="TD5"
        //primaryStage.scene=scene
        primaryStage.show()
    }
}

fun main(){
    Application.launch(Main::class.java)
}