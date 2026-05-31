package ihm.td5.controleur

import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import ihm.td5.vue.MainVue
import ihm.td5.vue.TitledPaneLivre
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType

class ControleurModifierPanneauDroit(vue: MainVue , model : Bibliotheque): EventHandler<ActionEvent>{
    private val model : Bibliotheque
    private val vue : MainVue
    init {
        this.vue = vue
        this.model = model
    }

    override fun handle(p0: ActionEvent) {
        vue.boutonAjout.isDisable = false
        vue.boutonModification.isDisable = false
        vue.boutonSuppression.isDisable = false
        val title= vue.getContenuTextFieldPanneauDroit()
        val cate = vue.getCategorieComboBoxPanneauDroit()
        val auteur = vue.getAuteurComboBoxPanneauDroit()
        val alerte = Alert(Alert.AlertType.CONFIRMATION)
        alerte.title = "modifier livre"
        alerte.contentText = "voulez vous modifier ce livre"
        alerte.showAndWait()
        if (alerte.result == ButtonType.OK){
            val livre_maj = Livre(title,cate,auteur)
            model.modifierLivre(livre_maj)
        }
        val panneau_normal = TitledPaneLivre("information livre")
        vue.updatePanneauDroit(panneau_normal)
        vue.updateContenuPanneauDroit(model.courant,model.donneLivre())
        vue.updateContenuPanneauGauche(model.donneTousLesLivres())
    }
}
