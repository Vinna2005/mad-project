package com.example.expirytracker

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class CategoryItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_items)

        val catName = intent.getStringExtra("CATEGORY_NAME") ?: "Category"
        findViewById<TextView>(R.id.tvTitle).text = catName
        findViewById<ImageView>(R.id.btnBack).setOnClickListener { finish() }

        val items = when (catName) {
            "Food" -> listOf(
                ExpiryItem("Milk",         "2 days left",  false, catName, "Apr 14, 2026"),
                ExpiryItem("Bread",        "5 days left",  false, catName, "Apr 17, 2026"),
                ExpiryItem("Yogurt",       "Expired",      true,  catName, "Apr 10, 2026"),
                ExpiryItem("Eggs",         "10 days left", false, catName, "Apr 22, 2026"),
                ExpiryItem("Butter",       "Expired",      true,  catName, "Apr 08, 2026")
            )
            "Medicine" -> listOf(
                ExpiryItem("Paracetamol",  "30 days left", false, catName, "May 12, 2026"),
                ExpiryItem("Cough Syrup",  "Expired",      true,  catName, "Mar 01, 2026"),
                ExpiryItem("Vitamin C",    "60 days left", false, catName, "Jun 11, 2026"),
                ExpiryItem("Antacid",      "3 days left",  false, catName, "Apr 15, 2026"),
                ExpiryItem("Bandages",     "1 year left",  false, catName, "Apr 12, 2027")
            )
            "Cosmetics" -> listOf(
                ExpiryItem("Face Cream",   "Expired",      true,  catName, "Jan 01, 2026"),
                ExpiryItem("Sunscreen",    "20 days left", false, catName, "May 02, 2026"),
                ExpiryItem("Shampoo",      "45 days left", false, catName, "May 27, 2026"),
                ExpiryItem("Lip Balm",     "5 days left",  false, catName, "Apr 17, 2026"),
                ExpiryItem("Moisturizer",  "Expired",      true,  catName, "Apr 01, 2026")
            )
            "Drinks" -> listOf(
                ExpiryItem("Orange Juice", "1 day left",   false, catName, "Apr 13, 2026"),
                ExpiryItem("Energy Drink", "15 days left", false, catName, "Apr 27, 2026"),
                ExpiryItem("Coconut Water","Expired",      true,  catName, "Apr 05, 2026"),
                ExpiryItem("Green Tea",    "90 days left", false, catName, "Jul 11, 2026"),
                ExpiryItem("Protein Shake","7 days left",  false, catName, "Apr 19, 2026")
            )
            else -> emptyList()
        }

        val rv = findViewById<RecyclerView>(R.id.rvItems)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = ItemAdapter(this, items) { item ->
            startActivity(
                Intent(this, ItemDetailActivity::class.java)
                    .putExtra("ITEM_NAME",   item.name)
                    .putExtra("ITEM_STATUS", item.status)
                    .putExtra("ITEM_DATE",   item.expiryDate)
                    .putExtra("CATEGORY",    item.category)
                    .putExtra("IS_EXPIRED",  item.isExpired)
            )
        }

        findViewById<MaterialButton>(R.id.btnAddItem).setOnClickListener {
            startActivity(Intent(this, AddCategoryActivity::class.java))
        }
    }
}

