package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
 import  javafx.scene.control.Label
import javafx.scene.layout.GridPane

class ControleurDetailLivre(model : Bibliotheque , vue : MainVue) : EventHandler<MouseEvent> {
    val modele : Bibliotheque
    val vue : MainVue
    init {
        this.modele = model
        this.vue = vue
    }
    override fun handle(event: MouseEvent) {
        val label = event.source as Label
        modele.preremplir()
        var livres = modele.donneTousLesLivres()

        val ind = GridPane.getRowIndex(label)
        vue.updateContenuPanneauGauche(livres,this, ind)
    }
}
