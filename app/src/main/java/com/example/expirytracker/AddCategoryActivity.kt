package com.example.expirytracker

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class AddCategoryActivity : AppCompatActivity() {

    private var selectedEmoji = "📦"
    private val emojis = listOf(
        "🍎","💊","💄","🥤","🧁","🥛",
        "🍞","🧴","🥦","🍗","🥚","🧀",
        "🍫","🧹","📦","🌿","🧃","🍵"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        val etName = findViewById<TextInputEditText>(R.id.etCategoryName)
        val iconGrid = findViewById<GridLayout>(R.id.iconGrid)
        val tvSelected = findViewById<TextView>(R.id.tvSelectedEmoji)

        findViewById<ImageView>(R.id.btnClose).setOnClickListener { finish() }

        emojis.forEach { emoji ->
            val tv = TextView(this).apply {
                text = emoji
                textSize = 28f
                gravity = Gravity.CENTER
                setPadding(12, 12, 12, 12)
                setOnClickListener {
                    selectedEmoji = emoji
                    tvSelected.text = emoji
                }
            }
            val params = GridLayout.LayoutParams().apply {
                width = 0
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                height = GridLayout.LayoutParams.WRAP_CONTENT
            }
            tv.layoutParams = params
            iconGrid.addView(tv)
        }

        findViewById<MaterialButton>(R.id.btnSave).setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isEmpty()) {
                etName.error = "Please enter category name"
                return@setOnClickListener
            }
            Toast.makeText(this, "Category '$name' saved!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}