package ihm.td5.vue

import ihm.td5.librairie.Livre
import javafx.geometry.Insets
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color


class TitledPaneLivreModification : TitledPaneLivre("modification livre"){
    override fun update(numero: Int, livre: Livre?) {
        super.update(numero, livre)
        this.text = "modification livre"
        this.textFill = Color.BLUE

        this.textFieldTitre.isEditable = true

        this.comboBoxCategorie.items.clear()
        this.comboBoxCategorie.items.addAll(
            Livre.SF,
            Livre.FANTASY,
            Livre.HORROR
        )
        this.comboBoxCategorie.selectionModel.select(livre?.categorie)
    }

    override fun setBoutons() {
        this.bouton1.text = "modifier"
        this.bouton2.text = "annuler"

        val borderPaneBoutons = BorderPane()
        borderPaneBoutons.left = bouton1
        borderPaneBoutons.right = bouton2
        borderPaneBoutons.padding = Insets(20.0)

        this.grille.add(borderPaneBoutons, 0, 4, 2, 1)
    }

}