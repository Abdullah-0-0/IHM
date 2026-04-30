package ihm.td2

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.awt.TextArea


class TD2_1: Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title = "TD2_2 en javaFX"
        var borderp = BorderPane()
        var texte = javafx.scene.control.TextArea("voici mon texte")
        borderp.center = texte
        var formule = VBox()
        var bienv = Label("Bienvnue")
        formule.children.add(bienv)
        borderp.right = formule

            //borderp.children.add(texte)
        var scene = Scene(borderp, 1000.0, 800.0)
        primaryStage.scene = scene
        primaryStage.show()
    }
}


fun main() {
    Application.launch(TD2_1::class.java)
}

