package ihm.td3.ecouteurs


import ihm.td3.MaFenetre
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.control.Label


class BoutonGoEcouteur(appli: MaFenetre) : EventHandler<ActionEvent> {
        private val appli: MaFenetre

        //--- Constructeur ---------------------------------
        init {
            this.appli=appli
        }
        var compt : Int = 0

        //--- Code exécuté lorsque l'événement survient ----
       override  fun handle(event: ActionEvent) {
            appli.labelNbClicBouton.text = "${++compt}"
        }
    }
