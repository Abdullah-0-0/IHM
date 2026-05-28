package ihm.td6.exo1.controleur

import ihm.td6.exo1.modele.Modele
import ihm.td6.exo1.vue.Vue

class ControleurConcateneur(vue:Vue) {
    private val vue: Vue
    private val modele = Modele()


    init{
        this.vue=vue


    }
    fun bindVue() {
        vue.textFieldResultat.textProperty().bind(
            vue.textFieldChaine1.textProperty().concat(
                vue.textFieldChaine2.textProperty()
            )
        )
    }


}