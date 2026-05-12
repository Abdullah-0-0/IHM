package ihm.td4.calculatriceMVC.controleur

import ihm.td4.calculatriceMVC.modele.Model
import ihm.td4.calculatriceMVC.tools.Expression
import ihm.td4.calculatriceMVC.vue.Vue
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.control.Button

class ControleurBoutonChiffreOperateur(model : Model , vue : Vue) : EventHandler<ActionEvent>{
    private var vue : Vue
    private var model : Model
    init {
        this.model = model
        this.vue = vue
    }
     override fun handle(event : ActionEvent){
         var chif = event.source as Button
         var exp : Expression = Expression(vue.getTexte()+chif.text)
         if (exp.isValidExpression()){
             this.vue.ajoutTexte(chif.text)
             println("je passe dans le controleur, ajout de la variable ${chif.text} effectuer")
         }
         else{
             this.vue.setTexte("")
         }


    }

}
