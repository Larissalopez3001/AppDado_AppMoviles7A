package com.example.appdado
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
/**
 * Esta actividad permite que el usuario tiré un dado y ver su resultado por pantalla.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Se procede a llamar al método cuando se crea la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Se encarga de buscar el botón en el diseño
        val rollButton: Button = findViewById(R.id.button)

        // Dar clic en el botón de tirar los dados
        rollButton.setOnClickListener { rollDice() }

        // Permite tirar los dados cuando se inicie la aplicación
        rollDice()
    }
    /**
     * Permite lanzar los dados y luego actualiza la pantalla con el resultado.
     */
    private fun rollDice() {
        // Se crea un nuevo objeto Dice con 6 lados
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Busca ImageView en el diseño
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Determina qué ID de recurso extraíble usa de acuerdo de la tirada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Se encarga de actualizar ImageView con el ID de recurso extraíble correcto
        diceImage.setImageResource(drawableResource)

        // Se encarga de actualizar la descripción del contenido
        diceImage.contentDescription = diceRoll.toString()
    }
}
/**
 * Se define la clase Dice con un número fijo de lados.
 */
class Dice(private val numSides: Int) {

    /**
     * Permite al usuario tirar los dados al azar y devuelve el resultado.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}