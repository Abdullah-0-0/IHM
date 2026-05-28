package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType


class ControleurBoutonSuppressionLivre(vue: MainVue, model : Bibliotheque): EventHandler<ActionEvent>{
    private val vue : MainVue
    private val model : Bibliotheque
    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(p0: ActionEvent?) {
        var alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.title= "boîte de dialogue de confirmation"
        alert.contentText="Voulez vous vraiment supprimer ce livre"
        alert.showAndWait()
        if (alert.result== ButtonType.OK){
            if (!model.estVide()){
                model.suppressionLivre()
                vue.updateContenuPanneauGauche(model.donneTousLesLivres())
                vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
            }
            else{
                vue.updateContenuPanneauDroit(-1,null)
                println("plus de livre à supprimé")
            }
        }
        else{
            println("Annulation")
        }
        vue.activerBouton2PanneauDroit(model.ilYaLivreSuivant())
        vue.activerBouton1PanneauDroit(model.ilYaLivrePrecedent())
    }
}
