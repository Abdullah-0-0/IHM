package ihm.td5.controleur

import ihm.td5.Main
import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import javafx.event.EventHandler
import javafx.scene.input.MouseEvent


class ControleurBoutonSuppressionLivre(model: Bibliotheque,vue : MainVue) : EventHandler<MouseEvent> {
    private var modele : Bibliotheque
    private var vue : MainVue
    var comp : Int =0

    init {
        this.vue = vue
        this.modele = model
    }
    var liv : ArrayList<Livre> = arrayListOf<Livre>()
    override fun handle(event: MouseEvent?) {
        val livre = modele.donneTousLesLivres()
        liv = livre
        comp = livre.size
        print("nombre de livre :$comp")
//        if (comp>0){
//            liv.removeAt(comp)
//        }
        //vue.updateContenuPanneauGauche(liv)
    }
}
