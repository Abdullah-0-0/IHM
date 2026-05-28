package ihm.td6.exo2.controleur

import ihm.td6.exo2.modele.Cercle
import ihm.td6.exo2.vue.Vue
import javafx.css.converter.ColorConverter
import javafx.scene.paint.Color
import javafx.util.converter.NumberStringConverter
import javax.swing.text.StyleConstants


class ControleurBinding(vue: Vue, modele: Cercle) {
    private val vue: Vue
    private val modele : Cercle
    init {
        this.vue = vue
        this.modele = modele
    }
    fun bindModeleVue(){
        val conv = NumberStringConverter()
        vue.slider.valueProperty().bindBidirectional(modele.rayon)
        vue.textField.textProperty().bindBidirectional(modele.rayon,conv)
        vue.cercle.radiusProperty().bind(modele.rayon)
        //vue.colorPicker.valueProperty().bindBidirectional(vue.)
    }

}