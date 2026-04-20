package com.example.expirytracker

import android.content.Intent
<<<<<<< HEAD
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
=======
import android.os.Bundle
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

<<<<<<< HEAD
        // Android 13+ notification permission
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS)
                != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                requestPermissions(
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    101
                )
            }
        }

        // Profile icon click
        findViewById<ImageView>(R.id.ivProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

=======
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
        val rv = findViewById<RecyclerView>(R.id.rvCategories)
        rv.layoutManager = GridLayoutManager(this, 2)

        val list = mutableListOf(
<<<<<<< HEAD
            Category("Food",      "🍎", 5, "#FF7043"),
            Category("Medicine",  "💊", 5, "#42A5F5"),
            Category("Cosmetics", "💄", 5, "#AB47BC"),
            Category("Drinks",    "🥤", 5, "#26C6DA")
=======
            Category("Food",      "🍎", 3, "#FF7043"),
            Category("Medicine",  "💊", 2, "#42A5F5"),
            Category("Cosmetics", "💄", 1, "#AB47BC"),
            Category("Drinks",    "🥤", 4, "#26C6DA")
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
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
<<<<<<< HEAD

        // Auto check expiry when app opens
        checkExpiryAndNotify()
    }

    private fun checkExpiryAndNotify() {
        val items = listOf(
            ExpiryItem("Milk",        "2 days left", false, "Food",      "Apr 14, 2026"),
            ExpiryItem("Yogurt",      "Expired",     true,  "Food",      "Apr 10, 2026"),
            ExpiryItem("Cough Syrup", "Expired",     true,  "Medicine",  "Mar 01, 2026"),
            ExpiryItem("Face Cream",  "Expired",     true,  "Cosmetics", "Jan 01, 2026")
        )

        val expiredItems = items.filter { it.isExpired }
        val soonItems = items.filter { !it.isExpired }

        when {
            expiredItems.isNotEmpty() -> {
                NotificationHelper(this).showNotification(
                    "⚠️ Items Expired!",
                    "${expiredItems.size} item(s) expired: ${expiredItems.map { it.name }.joinToString(", ")}"
                )
            }
            soonItems.isNotEmpty() -> {
                NotificationHelper(this).showNotification(
                    "🔔 Expiry Alert!",
                    "${soonItems.first().name} is expiring soon!"
                )
            }
        }
    }
}

=======
    }
}
>>>>>>> 5d55251bf52f28edc59179d41fb3c428be9c85a3
