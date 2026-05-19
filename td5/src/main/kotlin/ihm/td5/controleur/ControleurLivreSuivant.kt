package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurLivreSuivant(model: Bibliotheque , vue : MainVue)  : EventHandler<ActionEvent>{
    private var model : Bibliotheque
    private var vue : MainVue

    init {
        this.model = model
        this.vue = vue
    }
    var n = model.donneNbLivres()
    override fun handle(event: ActionEvent) {
        if (model.ilYaLivreSuivant()){
            ++ model.courant
            vue.effacerSelectionPanneauGauche()
            vue.selectionnerLignePanneauGauche(model.courant)
            vue.updateContenuPanneauDroit(model.courant,model.donneLivre(model.courant))
            vue.activerBouton1PanneauDroit(true)
        }
        else{
            vue.activerBouton2PanneauDroit(false)
            vue.updateContenuPanneauDroit(model.courant,model.donneLivre(model.courant))
        }

    }
}