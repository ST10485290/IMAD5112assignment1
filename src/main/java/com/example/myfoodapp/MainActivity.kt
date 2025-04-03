package com.example.myfoodapp


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myfoodapp.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast" , "MissingInflatedId" , "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get UI components
        val timeText = findViewById<EditText>(R.id.timeText) // EditText for entering time of day
        val mealText = findViewById<TextView>(R.id.mealText) // TextView for displaying meal suggestions
        val resetButton = findViewById<Button>(R.id.resetButton) // Button to reset input and output
        val submitButton = findViewById<Button>(R.id.submitButton) // Button to submit input and get meal suggestions

        // Reset button functionality
        resetButton.setOnClickListener {
            timeText.text.clear()
            mealText.text = ""
        }

        // Meal suggestions
        val suggestions = mapOf(
            "Morning" to "Toasted cheese and bacon sandwich with fruit juice, Strawberry muffin and Banana smoothie, Cereal",
            "Mid-Morning" to "Jam and peanut butter bread, Blueberry muffin, pancakes with syrup, Fruit salad",
            "Afternoon" to "Grilled beef burger,Spicy Noodles, Greek salad, Chicken wrap",
            "Mid-Afternoon" to "Cheesy bread, Pizza, Sushi, stuffed potato fries, pie",
            "Night" to "Creamy pasta with sauce, Beef Stew With Rice, Ppa and Grilled Steak, Stir fry noodles",
            "Dessert" to "Chocolate cake, caramel ice cream, strawberry brownie, Tiramisu, Ice-Cream sundae, Cheesecake"
        )

        // Submit button functionality
        submitButton.setOnClickListener {
            val inputText = timeText.text.toString().trim()

            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (inputText in suggestions) {
                mealText.text = "Suggestions: ${suggestions[inputText]}"
            } else {
                Toast.makeText(this, "Invalid time of day. Try Morning, Mid-Morning, Afternoon, etc.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
