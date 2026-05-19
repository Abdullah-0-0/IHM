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
    private var compte = 0
    val livresAffiches = arrayListOf<Livre>()



    init {
        this.model = model
        this.vue = vue
        model.preremplir()
    }


    var liv : ArrayList<Livre> = arrayListOf<Livre>()


    override fun handle(event: ActionEvent ) {
        val tousLesLivres = model.donneTousLesLivres()

        if (compte < tousLesLivres.size) {
            val livre = tousLesLivres[compte]
            livresAffiches.add(livre)

            vue.updateContenuPanneauGauche(livresAffiches)

            compte++
        }
        else{
            println("livre complete")
        }

    }


}
