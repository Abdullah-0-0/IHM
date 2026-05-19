package ihm.td5


import ihm.td5.controleur.ControleurBoutonAjoutLivre
import ihm.td5.controleur.ControleurBoutonSuppressionLivre
import ihm.td5.controleur.ControleurDetailLivre
import ihm.td5.controleur.ControleurLivrePrecedent
import ihm.td5.controleur.ControleurLivreSuivant
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.input.MouseEvent

import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {

        val vue = MainVue()
        val bibliotheque = Bibliotheque()
        var idx : Int = 0
        var contenu_droite = TitledPaneLivre("")
        var detail_livre = ControleurDetailLivre(bibliotheque,vue)
        var contro_prec = ControleurLivrePrecedent(bibliotheque,vue)
        var contro_suiv = ControleurLivreSuivant(bibliotheque,vue)
        bibliotheque.preremplir()
        vue.updateContenuPanneauGauche(bibliotheque.donneTousLesLivres()
            , ControleurDetailLivre(bibliotheque,vue),idx)
        vue.updateContenuPanneauDroit(0,bibliotheque.donneLivre())
        vue.onMouseClicked= detail_livre
        vue.fixeControleurBouton(vue.getBouton1PanneauDroit(),contro_prec)
        vue.fixeControleurBouton(vue.getBouton2PanneauDroit(),contro_suiv)

        //val contro_ajou = ControleurBoutonAjoutLivre(bibliotheque, vue)
        //var contro_supp = ControleurBoutonSuppressionLivre(bibliotheque,vue)
        //vue.boutonAjout.onAction =contro_ajou
        //vue.boutonSuppression.onAction= contro_supp
        val scene = Scene(vue, 550.0, 350.0)
        primaryStage.title="TD5"
        primaryStage.scene=scene
        primaryStage.show()
    }
}

fun main(){
    Application.launch(Main::class.java)
}