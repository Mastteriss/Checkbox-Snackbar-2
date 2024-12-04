package com.example.pdd

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private  lateinit var checkBox: CheckBox
    private lateinit var infoTextView: TextView
    private lateinit var rulesTextView: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }
        checkBox = findViewById(R.id.checkBox)
        infoTextView = findViewById(R.id.infoTextView)
        rulesTextView = findViewById(R.id.rulesTextView)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                infoTextView.text = "Правила дорожного движения"
                displayRules()
            }else{
                infoTextView.text = ""
                rulesTextView.text = ""
            }
        }
    }

    private fun displayRules() {
        val rules = """
            1. Соблюдайте разметку.
            2. Не превышайте скорость.
            3. Используйте ремни безопасности.
            4. Не управляйте автомобилем в нетрезвом виде.
            5. Не отвлекайтесь на телефон во время вождения.""".trimIndent()
        rulesTextView.text = rules
    }
}