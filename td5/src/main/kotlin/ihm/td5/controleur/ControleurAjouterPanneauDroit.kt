package ihm.td5.controleur

import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler

class ControleurAjouterPanneauDroit(vue : MainVue , model : Bibliotheque): EventHandler<ActionEvent>{
    private val model : Bibliotheque
    private val vue : MainVue
    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(p0: ActionEvent) {
        val titre = vue.getContenuTextFieldPanneauDroit().trim()
        val categorie = vue.getCategorieComboBoxPanneauDroit()
        val auteur = vue.getAuteurComboBoxPanneauDroit()


        model.ajoutLivre(
            Livre(titre, categorie, auteur)
        )

        val panneauNormal = TitledPaneLivre("information livre")
        vue.updatePanneauDroit(panneauNormal)

        vue.updateContenuPanneauGauche(
            model.donneTousLesLivres(),
            ControleurDetailLivre(vue, model),
            model.courant
        )

        vue.updateContenuPanneauDroit(
            model.courant,
            model.donneLivre()
        )

        vue.fixeControleurBouton(
            vue.getBouton1PanneauDroit(),
            ControleurLivrePrecedent(vue, model)
        )

        vue.fixeControleurBouton(
            vue.getBouton2PanneauDroit(),
            ControleurLivreSuivant(vue, model)
        )

        vue.activerBouton1PanneauDroit(model.ilYaLivrePrecedent())
        vue.activerBouton2PanneauDroit(model.ilYaLivreSuivant())

        vue.boutonAjout.isDisable = false
        vue.boutonModification.isDisable = false
        vue.boutonSuppression.isDisable = false

    }
}