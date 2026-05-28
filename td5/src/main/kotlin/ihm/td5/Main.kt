package ihm.td5


import ihm.td5.controleur.ControleurBoutonModificationLivre
import ihm.td5.controleur.ControleurBoutonSuppressionLivre
import ihm.td5.controleur.ControleurDetailLivre
import ihm.td5.controleur.ControleurLivrePrecedent
import ihm.td5.controleur.ControleurLivreSuivant
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.application.Application
import javafx.scene.Scene

import javafx.stage.Stage

class Main: Application() {

    override fun start(primaryStage: Stage) {
        val model = Bibliotheque()
        val vue = MainVue()
        var contr_detail = ControleurDetailLivre(vue,model)
        model.preremplir()
        vue.updateContenuPanneauGauche(model.donneTousLesLivres(),contr_detail,model.courant)
        vue.updateContenuPanneauDroit(model.courant,model.donneLivre(model.courant))
        vue.fixeControleurBouton(vue.getBouton2PanneauDroit(), ControleurLivreSuivant(vue,model))
        vue.fixeControleurBouton(vue.getBouton1PanneauDroit(), ControleurLivrePrecedent(vue,model))
        vue.fixeControleurBouton(vue.boutonModification,ControleurBoutonModificationLivre(vue, model))
        vue.boutonSuppression.onAction = ControleurBoutonSuppressionLivre(vue,model)
        val scene = Scene(vue, 550.0, 350.0)
        primaryStage.title="TD5"
        primaryStage.scene=scene
        primaryStage.show()
    }
}

fun main(){
    Application.launch(Main::class.java)
}