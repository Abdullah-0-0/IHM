package ihm.td6.exo1.vue

import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.layout.FlowPane
import javafx.scene.layout.VBox

class Vue: VBox() {
    val textFieldChaine1: TextField
    val textFieldChaine2: TextField
    val textFieldResultat: TextField

    init{

        val labelChaine1= Label("Chaine 1:")
        val labelChaine2= Label("Chaine 2:")
        this.textFieldChaine1= TextField()
        this.textFieldChaine2= TextField()
        this.textFieldResultat=TextField()
        val etiquetteLabelResultat=Label("Résultat: ")
        val flowPaneHaut=FlowPane()
        flowPaneHaut.children.addAll(labelChaine1,textFieldChaine1,labelChaine2, textFieldChaine2)
        flowPaneHaut.hgap=10.0
        flowPaneHaut.padding= Insets(20.0)
        val flowPaneBas=FlowPane()
        flowPaneBas.hgap=10.0
        flowPaneBas.padding= Insets(20.0)
        flowPaneBas.children.addAll(etiquetteLabelResultat,textFieldResultat)
        this.children.addAll(flowPaneHaut, flowPaneBas)
        this.spacing=10.0
        this.padding= Insets(20.0)
    }
}