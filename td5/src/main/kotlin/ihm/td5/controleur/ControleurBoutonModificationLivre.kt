package ihm.td5.controleur

import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivreModification
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurBoutonModificationLivre(vue: MainVue , modele : Bibliotheque): EventHandler<ActionEvent> {
    private val vue : MainVue
    private val modele: Bibliotheque
    init {
        this.vue = vue
        this.modele = modele
    }

    override fun handle(p0: ActionEvent) {
        val panneauModification = TitledPaneLivreModification()

        vue.updatePanneauDroit(panneauModification)

        vue.updateContenuPanneauDroit(
            modele.courant,
            modele.donneLivre()
        )

        panneauModification.comboBoxAuteur.items.clear()
        panneauModification.comboBoxAuteur.items.addAll(modele.donneTousLesAuteurs())
        panneauModification.comboBoxAuteur.selectionModel.select(modele.donneLivre().auteur)

        vue.boutonModification.isDisable = true
        vue.boutonAjout.isDisable = true
        vue.boutonSuppression.isDisable = true

        vue.fixeControleurBouton(
            vue.getBouton1PanneauDroit(),
            ControleurModifierPanneauDroit(vue, modele)
        )

        vue.fixeControleurBouton(
            vue.getBouton2PanneauDroit(),
            ControleurAnnulerPanneauDroit(vue, modele)
        )
    }
}