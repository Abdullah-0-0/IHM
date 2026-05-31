package ihm.td5.vue

import ihm.td5.librairie.Auteur
import ihm.td5.librairie.Livre
import ihm.td5.modele.Bibliotheque
import javafx.geometry.Insets
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color


class TitledPaneLivreModification : TitledPaneLivre("modifier livre"){
    override fun update(numero: Int, livre: Livre?) {
        super.update(numero, livre)
        this.text= "modification livre"
        this.textFill= Color.BLUE
        this.textFieldTitre.isEditable = true
        this.comboBoxCategorie.items.clear()
        this.comboBoxCategorie.items.addAll(Livre.SF, Livre.FANTASY, Livre.HORROR)
    }

    override fun setBoutons() {
        this.bouton1.text ="modifier"
        this.bouton2.text= "Annuler"
        val bord = BorderPane()
        bord.left = this.bouton1
        bord.right = this.bouton2
        bord.padding = Insets(20.0)
        this.grille.add(bord,0,4,2,1)
    }
}