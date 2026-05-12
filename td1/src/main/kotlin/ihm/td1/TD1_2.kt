package ihm.td1

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.ColorPicker
import javafx.scene.control.DatePicker
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text
import javafx.stage.Stage
import java.io.FileInputStream


class TD1_2 : Application() {


    override fun start(stage: Stage) {
        stage.title = ("première application")
        var cadre = VBox()
        cadre.spacing=10.0
        var tex = Text("mon premier programme en javaFX")
        var bouton1 = Button("bouton1")
        var bouton2 = Button("bouton2")
        var bouton3 = Button("bouton3")
        var input = FileInputStream("/var/home/E257390X/reseau/Perso/Documents/IHM/td1/image/fleur.jpg")
        var image = Image(input)
        var date = DatePicker()
        var rose = ColorPicker(Color.PINK)


        tex.font = Font.font("Verdana",FontWeight.BOLD,30.0)
        bouton1.font = Font.font("Verdana",20.0)
        bouton1.textFill = Color.RED
        bouton1.setPrefSize(300.0,300.0)
        bouton1.style = "-fx-borgercolor : #b1fffd"
        bouton1.style = "-fx-margin-top : 300.0"
        bouton2.textFill = Color.RED
        bouton2.style = "-fx-background-color : #b1fffd"

        bouton3.graphic = ImageView(image)
        bouton3.textFill = Color.BLUE
        cadre.padding = Insets(40.0,20.0,40.0,20.0)


        cadre.children.add(tex)
        cadre.children.add(bouton1)
        cadre.children.add(bouton2)
        cadre.children.add(bouton3)
        cadre.children.add(date)
        cadre.children.add(rose)
        var scene = Scene(cadre,1000.0,800.0)
        stage.scene = scene
        stage.show()
    }

    override fun init() {
        super.init()
    }

    override fun stop() {
        super.stop()
    }
}

fun main() {
    Application.launch(TD1_2::class.java)
}