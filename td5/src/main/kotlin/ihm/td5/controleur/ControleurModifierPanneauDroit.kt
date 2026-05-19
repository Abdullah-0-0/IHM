package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurModifierPanneauDroit(model : Bibliotheque , vue : MainVue): EventHandler<ActionEvent>{
    private var model : Bibliotheque
    private var vue : MainVue



    init {
        this.model = model
        this.vue = vue
    }

    override fun handle(event: ActionEvent?) {
        var livre_modif = model.donneLivre(model.courant)
        println(livre_modif)
    }
}
