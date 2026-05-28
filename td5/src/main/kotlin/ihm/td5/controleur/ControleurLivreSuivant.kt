package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurLivreSuivant(vue: MainVue, model : Bibliotheque) : EventHandler<ActionEvent>{
    private val model : Bibliotheque
    private val vue : MainVue

    init {
        this.model = model
        this.vue = vue
    }
    override fun handle(p0: ActionEvent) {
        if (model.ilYaLivreSuivant()){
            ++model.courant
            vue.effacerSelectionPanneauGauche()
            vue.selectionnerLignePanneauGauche(model.courant)
            vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
            vue.activerBouton2PanneauDroit(true)
            vue.activerBouton1PanneauDroit(true)
        }
        else{
            vue.activerBouton2PanneauDroit(false)
            vue.activerBouton1PanneauDroit(true)
        }

    }

}