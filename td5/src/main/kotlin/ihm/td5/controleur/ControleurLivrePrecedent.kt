package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurLivrePrecedent(vue: MainVue , model : Bibliotheque): EventHandler<ActionEvent>{
    private val model : Bibliotheque
    private val vue : MainVue

    init {
        this.vue = vue
        this.model = model
    }
    override fun handle(p0: ActionEvent) {
        if (model.ilYaLivrePrecedent()){
            --model.courant
            vue.effacerSelectionPanneauGauche()
            vue.selectionnerLignePanneauGauche(model.courant)
            vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
            vue.activerBouton1PanneauDroit(true)
            vue.activerBouton2PanneauDroit(true)
        }
        else{
            vue.activerBouton1PanneauDroit(false)
            vue.activerBouton2PanneauDroit(true)
        }

    }
}
