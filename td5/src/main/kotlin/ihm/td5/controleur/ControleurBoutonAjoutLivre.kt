package ihm.td5.controleur


import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import ihm.td5.vue.TitledPaneLivreAjout
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurBoutonAjoutLivre(vue : MainVue , model : Bibliotheque) : EventHandler<ActionEvent>{
    private val model : Bibliotheque
    private val vue : MainVue
    init {
        this.model = model
        this.vue = vue
    }
    override fun handle(p0: ActionEvent?) {
        vue.boutonAjout.isDisable = true
        vue.boutonModification.isDisable = true
        vue.boutonSuppression.isDisable = true

        val panneauAjout = TitledPaneLivreAjout()

        vue.updatePanneauDroit(panneauAjout)

        vue.updateContenuPanneauDroit(
            model.donneNbLivres(),
            null
        )

        panneauAjout.comboBoxAuteur.items.clear()
        panneauAjout.comboBoxAuteur.items.addAll(model.donneTousLesAuteurs())

        vue.updateContenuPanneauGauche(
            model.donneTousLesLivres(),
            -1
        )

        vue.fixeControleurBouton(
            vue.getBouton1PanneauDroit(),
            ControleurAjouterPanneauDroit(vue, model)
        )

        vue.fixeControleurBouton(
            vue.getBouton2PanneauDroit(),
            ControleurAnnulerPanneauDroit(vue, model)
        )
    }
}
