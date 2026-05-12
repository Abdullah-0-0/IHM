package ihm.td4.calculatriceMVC


import ihm.td4.calculatriceMVC.controleur.ControleurBoutonChiffreOperateur
import ihm.td4.calculatriceMVC.controleur.ControleurEfface
import ihm.td4.calculatriceMVC.modele.Model
import ihm.td4.calculatriceMVC.vue.Vue

import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage


class Calculatrice: Application(){

        override fun start(primaryStage: Stage) {
            var vue = Vue()
            var modele = Model()
            var contro_chi = ControleurBoutonChiffreOperateur(modele, vue)
            var contro_efface = ControleurEfface(modele,vue)
            vue.contr_chfi(contro_chi)
            vue.contr_effacer(contro_efface)
            var scene = Scene(vue,500.0,400.0)
            primaryStage.scene = scene
            primaryStage.show()
        }
    }


        fun main(){
            Application.launch(Calculatrice::class.java)
        }
