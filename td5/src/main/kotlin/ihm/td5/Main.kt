package ihm.td5


import ihm.td5.controleur.ControleurBoutonAjoutLivre
import ihm.td5.controleur.ControleurBoutonSuppressionLivre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.MouseEvent

import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {

        val vue = MainVue()
        val bibliotheque = Bibliotheque()
        val contro_ajou = ControleurBoutonAjoutLivre(bibliotheque, vue)
        var contro_supp = ControleurBoutonSuppressionLivre(bibliotheque,vue)
        bibliotheque.preremplir()
        vue.boutonAjout.onAction =contro_ajou
        vue.boutonSuppression.onMouseClicked= contro_supp
        val scene = Scene(vue, 550.0, 350.0)
        primaryStage.title="TD5"
        primaryStage.scene=scene
        primaryStage.show()
    }
}

fun main(){
    Application.launch(Main::class.java)
}