package ihm.td4.calculatriceMVC.controleur

import ihm.td4.calculatriceMVC.modele.Model
import ihm.td4.calculatriceMVC.vue.Vue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button

class ControleurEfface(model: Model , vue: Vue): EventHandler<ActionEvent>{
    private var model : Model
    private var vue : Vue
    init {
        this.vue = vue
        this.model = model
    }
    override fun handle(event: ActionEvent) {
        var res = event.source as Button
        if (res.text == "C"){
            vue.setTexte("")
        }

    }

}
