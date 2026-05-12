package ihm.td4.calculatriceMVC.controleur

import ihm.td4.calculatriceMVC.modele.Model
import ihm.td4.calculatriceMVC.vue.Vue
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Button

class ControleurResultat(model : Model, vue: Vue): EventHandler<ActionEvent>{
    private var model : Model
    private var vue : Vue
    init {
        this.vue = vue
        this.model = model
    }
    override fun handle(event: ActionEvent) {
        var source = event.source as Button
        var text = source.text
        var exp = vue.getTexte()
        val match = Regex("[+\\-*/]").find(exp)
        val parties = exp.split(Regex("[+\\-*/]"))
        for (i in text){
            if (i.toString() == "+"){
                model.operation2 = parties[1].toInt()
                model.operation1 = parties[0].toInt()
                var res = model.addiction()
                vue.ajoutTexte(res.toString())
            }
        }
    }
}











