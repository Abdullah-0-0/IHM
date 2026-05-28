package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurBoutonAjoutLivre(vue : MainVue, model : Bibliotheque): EventHandler<ActionEvent>{
    private val vue : MainVue
    private val model : Bibliotheque
    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(p0: ActionEvent) {

    }
}
