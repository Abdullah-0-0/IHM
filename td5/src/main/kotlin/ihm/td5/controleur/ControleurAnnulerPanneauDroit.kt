package ihm.td5.controleur

import ihm.td5.Main
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler


class ControleurAnnulerPanneauDroit(vue : MainVue, modele : Bibliotheque): EventHandler<ActionEvent>{
    private val modele : Bibliotheque
    private val vue : MainVue
    init {
        this.vue = vue
        this.modele = modele

    }

    override fun handle(p0: ActionEvent?) {
        val panneauNormal = TitledPaneLivre("information Livre")

        vue.updatePanneauDroit(panneauNormal)

        vue.updateContenuPanneauDroit(
            modele.courant,
            modele.donneLivre()
        )

        vue.fixeControleurBouton(
            vue.getBouton1PanneauDroit(),
            ControleurLivrePrecedent(vue, modele)
        )

        vue.fixeControleurBouton(
            vue.getBouton2PanneauDroit(),
            ControleurLivreSuivant(vue, modele)
        )

        vue.activerBouton1PanneauDroit(modele.ilYaLivrePrecedent())
        vue.activerBouton2PanneauDroit(modele.ilYaLivreSuivant())

        vue.boutonModification.isDisable = false
        vue.boutonAjout.isDisable = false
        vue.boutonSuppression.isDisable = false
    }
}