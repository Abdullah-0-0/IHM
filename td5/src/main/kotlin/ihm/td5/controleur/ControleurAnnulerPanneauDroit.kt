package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurAnnulerPanneauDroit(vue : MainVue, model : Bibliotheque): EventHandler<ActionEvent> {
private val model : Bibliotheque
private val vue : MainVue
init {
    this.vue = vue
    this.model = model
}

    override fun handle(p0: ActionEvent?) {
        val panne_orig = TitledPaneLivre("information livre")
        vue.boutonAjout.isDisable = false
        vue.boutonModification.isDisable = false
        vue.boutonSuppression.isDisable = false
        vue.updatePanneauDroit(panne_orig)
        vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
        vue.activerBouton1PanneauDroit(model.ilYaLivrePrecedent())
        vue.activerBouton2PanneauDroit(model.ilYaLivreSuivant())
    }
}