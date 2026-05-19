package ihm.td5.controleur

import ihm.td5.Main
import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Label
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane


class ControleurBoutonSuppressionLivre(model: Bibliotheque,vue : MainVue) : EventHandler<ActionEvent> {
    private var modele : Bibliotheque
    private var vue : MainVue
    var comp : Int =0

    init {
        this.vue = vue
        this.modele = model
    }
    var liv : ArrayList<Livre> = arrayListOf<Livre>()
    override fun handle(event: ActionEvent) {

        if (!modele.estVide()) {
            modele.courant = modele.donneTousLesLivres().size - 1

            modele.suppressionLivre()

            vue.updateContenuPanneauGauche(
                modele.donneTousLesLivres()
            )
        }
        else{
            println("plus de livre à supprimé")
        }
    }

}
