package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType


class ControleurBoutonSuppressionLivre(vue : MainVue, model : Bibliotheque) : EventHandler<ActionEvent>{
    private val vue : MainVue
    private val model : Bibliotheque

    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(p0: ActionEvent?) {
        val alerte = Alert(Alert.AlertType.CONFIRMATION)
        alerte.title="Boite de dialogue de confirmation"
        alerte.contentText = "Voulez vous vraiment supprimer ce livre"
        alerte.showAndWait()
        if (!model.estVide()){
            if (alerte.result == ButtonType.OK){
                vue.effacerSelectionPanneauGauche()
                model.suppressionLivre()
                vue.updateContenuPanneauGauche(model.donneTousLesLivres(),ControleurDetailLivre(vue, model),
                    model.courant)
                vue.selectionnerLignePanneauGauche(model.courant)
                vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
                vue.activerBouton1PanneauDroit(model.ilYaLivrePrecedent())
                vue.activerBouton2PanneauDroit(model.ilYaLivreSuivant())

            }
        }
        else{
            vue.boutonSuppression.isDisable = true
            vue.activerBouton1PanneauDroit(false)
            vue.activerBouton2PanneauDroit(false)
            vue.updateContenuPanneauGauche(model.donneTousLesLivres(), -1)
            vue.updateContenuPanneauDroit(-1, null)



        }


    }
}
