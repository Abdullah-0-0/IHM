package ihm.td6.exo2


import ihm.td6.exo1.modele.Modele
import ihm.td6.exo2.controleur.ControleurBinding
import ihm.td6.exo2.modele.Cercle
import ihm.td6.exo2.vue.Vue
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Cell
import javafx.stage.Stage

class MainCercle: Application() {
    override fun start(primaryStage: Stage) {
        val vue = Vue()
        val modele = Cercle()
        val controleur = ControleurBinding(vue,modele)
        controleur.bindModeleVue()
        vue.slider.value= 50.0

        val scene = Scene(vue, 500.0, 550.0)
        primaryStage.title="Binding Cercle en javaFX"
        primaryStage.scene=scene
        primaryStage.show()
    }

}

fun main(){
    Application.launch(MainCercle::class.java)
}

