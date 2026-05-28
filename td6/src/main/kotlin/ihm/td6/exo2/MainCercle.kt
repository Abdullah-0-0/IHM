package ihm.td6.exo2


import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class MainCercle: Application() {
    override fun start(primaryStage: Stage) {

       // val scene = Scene(vue, 500.0, 550.0)
        primaryStage.title="Binding Cercle en javaFX"
       // primaryStage.scene=scene
        primaryStage.show()
    }

}

fun main(){
    Application.launch(MainCercle::class.java)
}

