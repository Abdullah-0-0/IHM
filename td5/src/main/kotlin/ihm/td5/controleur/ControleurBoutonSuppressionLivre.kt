package ihm.td5.controleur

import ihm.td5.Main
import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane


class ControleurBoutonSuppressionLivre(model: Bibliotheque,vue : MainVue) : EventHandler<ActionEvent> {
    private var modele : Bibliotheque
    private var vue : MainVue

    init {
        this.vue = vue
        this.modele = model
    }
    override fun handle(event: ActionEvent) {

        var verif_sup = Alert(Alert.AlertType.CONFIRMATION)
        verif_sup.contentText= "Voulez vous vraiment supprimer ce livre"
        verif_sup.title= "boîte de dialogue de confirmation"
        var res = verif_sup.showAndWait()
        if (res.get()== ButtonType.OK){
            println("Bouton OK cliqué")
            println("courant: ${modele.courant}")
            if (!modele.estVide()) {

                modele.suppressionLivre()

                vue.updateContenuPanneauGauche(
                    modele.donneTousLesLivres()
                )
                vue.updateContenuPanneauDroit(modele.courant,
                    modele.donneLivre(modele.courant))
            }
            else{
                println("plus de livre à supprimé")
            }

        }


    }

}
