package ihm.td1

import javafx.application.Application
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


class TD1_1: Application() {
        override fun start(primaryStage: Stage?) {
                primaryStage?.title = "Première application"
                var borderp = VBox()
                borderp.spacing = 0.0
                var tex= Text("mon premier programme en javaFx")
                var bouton1 = Button("bouton1")
                var bouton2 = Button("bouton2")
                var button3 = Button("bouton3")
                var input = FileInputStream("/var/home/E257390X/reseau/Perso/Documents/IHM/td1/image/fleur.jpg")
                var image = Image(input)
                button3.graphic = ImageView(image)
                var date = DatePicker()
                var rose = ColorPicker(Color.PINK)


                tex.font = Font.font("Verdana", FontWeight.BOLD, 20.0, )
                bouton1.font = Font.font(20.0)
                bouton1.textFill = Color.RED
                bouton2.style ="-fx-background-color : #b1fffd"
                bouton2.textFill = Color.RED
                button3.textFill = Color.BLUE

                borderp.children.add(tex)
                borderp.children.add(bouton1)
                borderp.children.add(bouton2)
                borderp.children.add(button3)
                borderp.children.add(date)
                borderp.children.add(rose)

                var scene = Scene(borderp, 1000.0, 800.0)
                primaryStage?.scene = scene
                primaryStage?.show()
        }

        /*override fun init() : String {
                return "je suis dans la méthode x"
        }

        override fun stop() : String{
                return "je suis dans la méthode x"
        }
*/


}

fun main() {

        println("main avant launch")
        Application.launch(TD1_1::class.java)
        println("main après launch")
}




