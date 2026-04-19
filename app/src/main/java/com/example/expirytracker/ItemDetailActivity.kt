package com.example.expirytracker

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val name      = intent.getStringExtra("ITEM_NAME")   ?: "Item"
        val status    = intent.getStringExtra("ITEM_STATUS") ?: "Unknown"
        val date      = intent.getStringExtra("ITEM_DATE")   ?: "-"
        val category  = intent.getStringExtra("CATEGORY")    ?: "-"
        val isExpired = intent.getBooleanExtra("IS_EXPIRED", false)

        findViewById<TextView>(R.id.tvToolbarTitle).text = name
        findViewById<TextView>(R.id.tvItemName).text     = name
        findViewById<TextView>(R.id.tvCategory).text     = category
        findViewById<TextView>(R.id.tvExpiryDate).text   = date

        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val tvEmoji  = findViewById<TextView>(R.id.tvItemEmoji)

        if (isExpired) {
            tvEmoji.text = "⚠️"
            tvStatus.text = "❌ $status"
            tvStatus.setTextColor(Color.parseColor("#D32F2F"))
        } else {
            tvEmoji.text = "✅"
            tvStatus.text = "⚠ $status"
            tvStatus.setTextColor(Color.parseColor("#E65100"))
        }

        findViewById<ImageView>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<MaterialButton>(R.id.btnEdit).setOnClickListener {
            Toast.makeText(this, "Edit coming soon!", Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialButton>(R.id.btnDelete).setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Delete Item")
                .setMessage("Delete '$name'?")
                .setPositiveButton("Delete") { _, _ ->
                    Toast.makeText(this, "'$name' deleted", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
    }
<<<<<<< HEAD
}

=======
}
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
