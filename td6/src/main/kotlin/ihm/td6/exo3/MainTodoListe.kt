package ihm.td6.exo3

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class MainTodoListe: Application() {
    override fun start(stage: Stage) {



       // val scene = Scene(vue,550.0,300.0)
        stage.title = "JavaFX TODO liste"
      //  stage.scene=scene
        stage.show()
    }
}

fun main(){
    Application.launch(MainTodoListe::class.java)
}