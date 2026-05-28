package ihm.td5.controleur

import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert

class ControleurModifierPanneauDroit(vue : MainVue, modele : Bibliotheque): EventHandler<ActionEvent>{
    private val modele : Bibliotheque
    private val vue : MainVue
    init {
        this.vue = vue
        this.modele = modele

    }

    override fun handle(p0: ActionEvent?) {
        val titre = vue.getContenuTextFieldPanneauDroit().trim()
        val categorie = vue.getCategorieComboBoxPanneauDroit()
        val auteur = vue.getAuteurComboBoxPanneauDroit()

        if (titre.isEmpty()) {
            val dialog = Alert(Alert.AlertType.INFORMATION)
            dialog.title = "Information"
            dialog.headerText = "Titre manquant"
            dialog.contentText = "Veuillez saisir un titre."
            dialog.showAndWait()
            return
        }

        val livreModifie = Livre(titre, categorie, auteur)

        modele.modifierLivre(livreModifie)

        vue.updateContenuPanneauGauche(
            modele.donneTousLesLivres(),
            ControleurDetailLivre(vue, modele),
            modele.courant
        )

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
