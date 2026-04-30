package ihm.td2

import javafx.application.Application
import javafx.stage.Stage



const val TEXT= ("voici un texte relativement long à "
        + "lire et qui n'a aucune sorte d'intérêt à part"
        + " celui de prendre beaucoup de place et donc "
        + "d'occuper de l'espace dans la TextArea... ")
const val ADMINISTRATOR = "Administrateur"
const val STUDENT = "Etudiant(e)"
const val TEACHER = "Enseignant(e)"
const val STATE = "Etat de l'application > en cours d'identification"


class TD2_2Css: Application() {

    override fun start(primaryStage: Stage) {
       //TODO
}
}


fun main() {
    Application.launch(TD2_2Css::class.java)
}





