package ihm.td5.vue

import ihm.td5.librairie.Livre
import javafx.geometry.Insets
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color


class TitledPaneLivreAjout: TitledPaneLivre("ajoute livre"){
    override fun update(numero: Int, livre: Livre?) {
        super.update(numero, livre)
        this.textFill = Color.RED
        this.textFieldTitre.text = null
        this.textFieldTitre.isEditable = true
        this.comboBoxCategorie.items.clear()
        this.comboBoxCategorie.items.addAll(Livre.SF, Livre.FANTASY, Livre.HORROR)
        this.comboBoxAuteur.items.clear()
        this.comboBoxAuteur.items.add(livre?.auteur)

    }

    override fun setBoutons() {
        this.bouton1.text="ajouter"
        this.bouton2.text="annuler"
        var borde = BorderPane()
        borde.left = this.bouton1
        borde.right = this.bouton2
        borde.padding = Insets(10.0)
        this.grille.add(borde,0,4,2,1)
    }
}
