package com.example.stlstudioai

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLoad = findViewById<Button>(R.id.btnLoadStl)
        val btnSave = findViewById<Button>(R.id.btnSaveStl)
        val btnGenerate = findViewById<Button>(R.id.btnGenerateAi)
        val inputPrompt = findViewById<EditText>(R.id.etAiPrompt)

        btnLoad.setOnClickListener {
            Toast.makeText(this, "Funkce pro načtení souboru spuštěna", Toast.LENGTH_SHORT).show()
        }

        btnSave.setOnClickListener {
            val file = File(filesDir, "model_export.stl")
            saveBinaryStl(file, emptyList())
            Toast.makeText(this, "Uloženo do: ${file.absolutePath}", Toast.LENGTH_LONG).show()
        }

        btnGenerate.setOnClickListener {
            val promptText = inputPrompt.text.toString()
            if (promptText.isNotEmpty()) {
                Toast.makeText(this, "Odesílám požadavek na AI: $promptText", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nejprve zadejte textový popis!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
