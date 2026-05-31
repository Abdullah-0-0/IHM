package ihm.td5.controleur

import ihm.td5.Main
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivreModification
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurBoutonModificationLivre(vue : MainVue , model : Bibliotheque): EventHandler<ActionEvent>{
    private val model : Bibliotheque
    private val vue : MainVue

    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(p0: ActionEvent) {
        if (!model.estVide()){
            val panneau_modif= TitledPaneLivreModification()
            vue.updatePanneauDroit(panneau_modif)
            vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
            panneau_modif.comboBoxAuteur.items.clear()
            panneau_modif.comboBoxAuteur.items.addAll(model.donneTousLesAuteurs())
            vue.getBouton2PanneauDroit()
            vue.boutonSuppression.isDisable = true
            vue.boutonAjout.isDisable = true
            vue.boutonModification.isDisable = true
            vue.fixeControleurBouton(vue.getBouton2PanneauDroit(), ControleurAnnulerPanneauDroit(vue,model))
            vue.fixeControleurBouton(vue.getBouton1PanneauDroit(), ControleurModifierPanneauDroit(vue,model))
        }
    }

}