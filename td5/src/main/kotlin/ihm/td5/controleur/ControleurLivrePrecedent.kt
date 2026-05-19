package ihm.td5.controleur

import ihm.td5.Main
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.layout.GridPane
import  javafx.scene.control.Label


class ControleurLivrePrecedent(model : Bibliotheque, vue : MainVue) : EventHandler<ActionEvent>{
    private var model : Bibliotheque
    private var vue : MainVue

    init {
        this.model = model
        this.vue = vue
    }
    override fun handle(event: ActionEvent) {
        if (model.ilYaLivrePrecedent()){
            --model.courant
            vue.effacerSelectionPanneauGauche()
            vue.selectionnerLignePanneauGauche(model.courant)
            vue.updateContenuPanneauDroit(model.courant,model.donneLivre(model.courant))
            vue.activerBouton2PanneauDroit(true)
        }
        else{
            vue.activerBouton1PanneauDroit(false)
        }

    }
}
