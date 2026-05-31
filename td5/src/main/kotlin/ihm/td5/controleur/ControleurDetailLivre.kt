package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane

class ControleurDetailLivre(vue: MainVue , model : Bibliotheque) : EventHandler<MouseEvent>{

    private val model : Bibliotheque
    private val vue : MainVue

    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(event: MouseEvent) {
        val label = event.source as Label
        val idx = GridPane.getRowIndex(label)
        model.courant = idx
        vue.effacerSelectionPanneauGauche()
        vue.selectionnerLignePanneauGauche(model.courant)
        vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
        if (model.ilYaLivreSuivant()){
            if (model.ilYaLivrePrecedent()){
                vue.activerBouton1PanneauDroit(true)
                vue.activerBouton2PanneauDroit(true)
            }
            else{
                vue.activerBouton1PanneauDroit(false)
                vue.activerBouton2PanneauDroit(true)
            }

        }
        else{
            vue.activerBouton2PanneauDroit(false)
            vue.activerBouton1PanneauDroit(true)
        }

    }
}
