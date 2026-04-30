package ihm.td2

import javafx.application.Application
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.CheckBox
import javafx.scene.control.ChoiceBox
import javafx.scene.control.PasswordField
import javafx.scene.control.ProgressBar
import javafx.scene.control.RadioButton
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import javafx.stage.Stage


const val TEXTE= ("voici un texte relativement long à "
        + "lire et qui n'a aucune sorte d'intérêt à part"
        + " celui de prendre beaucoup de place et donc "
        + "d'occuper de l'espace dans la TextArea... ")
const val ADMINISTRATEUR = "Administrateur"
const val ETUDIANT = "Etudiant(e)"
const val ENSEIGNANT = "Enseignant(e)"
const val ETAT = "Etat de l'application > en cours d'identification"


class TD2_2: Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title="TD2_2 en javaFX"
        var borderp = BorderPane()
        var formule = VBox()
        var form_grid = GridPane()
        var bord_button = HBox()



        var form_bien = Text("bienvenue")
        var log = Text("Login:")
        var pwd = Text("Password:")
        var form_lab_log = TextField()
        var form_lab_pas = PasswordField()
        var boutt_connex = Button("Connexion")
        var etu  = ChoiceBox<String>()

        var barre_pro = ProgressBar()
        var V_1 = VBox()
        var Choix_f = Text("Choix formartion")
        var info1 = RadioButton("info1")
        var info2= RadioButton("info2")
        var info3 = RadioButton("info3")
        var V_2 = VBox()
        var choix_p = Text("Choix Parcours")
        var parcou1 = CheckBox("Parcours 1")
        var parcou2 = CheckBox("Parcours 2")
        var parcou3 = CheckBox("Parcours 3")
        //CSS
        form_bien.font =Font.font("verdana", FontWeight.BOLD,20.0)


        form_bien.style = "-fx-margin-top:300.0;"
        choix_p.font = Font.font("verdera", FontWeight.BOLD, 16.0)
        Choix_f.font = Font.font("verdera", FontWeight.BOLD, 16.0)

        V_1.children.add(Choix_f)
        V_1.children.add(info1)
        V_1.children.add(info2)
        V_1.children.add(info3)
        V_1.spacing= 10.0

        V_2.children.add(choix_p)
        V_2.children.add(parcou1)
        V_2.children.add(parcou2)
        V_2.children.add(parcou3)
        V_2.spacing = 10.0


        //CSS
        etu.items.addAll(ADMINISTRATEUR,ENSEIGNANT,ETUDIANT)
        etu.value = ETUDIANT
        var tex = TextArea(TEXTE)
        tex.isWrapText = true
        tex.isEditable = false

        borderp.center = tex
        borderp.right = formule
        borderp.bottom = bord_button

        bord_button.children.add(barre_pro)
        bord_button.children.add(Text(ETAT))
        bord_button.alignment = Pos.CENTER


        formule.children.add(form_grid)
        formule.children.add(V_1)
        formule.children.add(V_2)
        formule.spacing= 10.0
        VBox.setMargin(V_1, Insets(10.0))
        VBox.setMargin(V_2, Insets(10.0))
        formule.styleClass.add("bord_o")
        form_grid.styleClass.add("mygrid")
        V_2.styleClass.add("bord")
        V_1.styleClass.add("bord")

        form_grid.add(form_bien,0,0)
        form_grid.add(log,0,1)
        form_grid.add(form_lab_log,1,1)
        form_grid.add(pwd,0,2)
        form_grid.add(form_lab_pas,1,2)
        form_grid.add(boutt_connex,1,3)
        form_grid.add(etu,0,3)
        GridPane.setHalignment(boutt_connex, HPos.CENTER)
        form_grid.vgap= 10.0

        var scene = Scene(borderp,1000.0, 800.0)
        scene.stylesheets.add(TD2_2::class.java.getResource("css/style.css").toExternalForm())


        primaryStage.scene = scene
        primaryStage.show()
}
}


fun main() {
    Application.launch(TD2_2::class.java)
}





