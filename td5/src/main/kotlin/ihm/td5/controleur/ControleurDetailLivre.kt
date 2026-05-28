package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import javafx.scene.control.Label
import javafx.scene.layout.GridPane

class ControleurDetailLivre(vue: MainVue, model : Bibliotheque) : EventHandler<MouseEvent>{
    var vue : MainVue
    var model : Bibliotheque
    init {
        this.vue = vue
        this.model = model
    }
    override fun handle(event: MouseEvent) {
        var label = event.source as Label
        var idx = GridPane.getRowIndex(label)
        model.courant = idx
        vue.effacerSelectionPanneauGauche()
        vue.selectionnerLignePanneauGauche(idx)
        vue.updateContenuPanneauDroit(idx,model.donneLivre())

        vue.activerBouton1PanneauDroit(model.ilYaLivrePrecedent())
        vue.activerBouton2PanneauDroit(model.ilYaLivreSuivant())

    }

}
