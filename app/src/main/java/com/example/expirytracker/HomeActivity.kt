package com.example.expirytracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val rv = findViewById<RecyclerView>(R.id.rvCategories)
        rv.layoutManager = GridLayoutManager(this, 2)

        val list = mutableListOf(
            Category("Food",      "🍎", 3, "#FF7043"),
            Category("Medicine",  "💊", 2, "#42A5F5"),
            Category("Cosmetics", "💄", 1, "#AB47BC"),
            Category("Drinks",    "🥤", 4, "#26C6DA")
        )

        rv.adapter = CategoryAdapter(this, list) { cat ->
            startActivity(
                Intent(this, CategoryItemsActivity::class.java)
                    .putExtra("CATEGORY_NAME", cat.name)
            )
        }

        findViewById<MaterialButton>(R.id.btnAddCategory).setOnClickListener {
            startActivity(Intent(this, AddCategoryActivity::class.java))
        }
    }
}