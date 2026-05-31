package ihm.td5


import ihm.td5.controleur.ControleurAjouterPanneauDroit
import ihm.td5.controleur.ControleurBoutonAjoutLivre
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
       val vue =  MainVue()
        val model = Bibliotheque()
        model.preremplir()
        val ControleDetail = ControleurDetailLivre(vue, model)
        val controle_suivant = ControleurLivreSuivant(vue,model)
        val controle_preced = ControleurLivrePrecedent(vue,model)
        val contro_supp = ControleurBoutonSuppressionLivre(vue,model)
        val contro_ajout = ControleurBoutonAjoutLivre(vue,model)
        val scene = Scene(vue, 550.0, 350.0)

        vue.updateContenuPanneauGauche(model.donneTousLesLivres(),ControleDetail,model.courant)
        vue.updateContenuPanneauDroit(model.courant, model.donneLivre())
        vue.fixeControleurBouton(vue.getBouton2PanneauDroit(),controle_suivant)
        vue.fixeControleurBouton(vue.getBouton1PanneauDroit(),controle_preced)
        vue.fixeControleurBouton(
            vue.boutonModification, ControleurBoutonModificationLivre(vue,model)
        )
        vue.boutonSuppression.onAction = contro_supp
        vue.boutonAjout.onAction = contro_ajout
        primaryStage.title="TD5"
        primaryStage.scene=scene
        primaryStage.show()
    }
}

fun main(){
    Application.launch(Main::class.java)
}