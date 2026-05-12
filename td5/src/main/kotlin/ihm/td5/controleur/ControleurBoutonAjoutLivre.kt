package ihm.td5.controleur

import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane


class ControleurBoutonAjoutLivre(model : Bibliotheque, vue : MainVue) : EventHandler<ActionEvent>{
    val model : Bibliotheque
    val vue : MainVue
    var compte = 0


    init {
        this.model = model
        this.vue = vue

    }


    var liv : ArrayList<Livre> = arrayListOf<Livre>()

    override fun equals(other: Any?): Boolean {
        if (this == other) return true
        return false
    }
    override fun handle(event: ActionEvent ) {
        model.preremplir()
        val livre = model.donneTousLesLivres()
        var l : Livre

        l = livre[compte]
        if (compte<9){
            liv.add(l)
        }


        ++compte
        vue.updateContenuPanneauGauche(liv)
    }


}
