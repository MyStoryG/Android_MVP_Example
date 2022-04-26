package com.mvp.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.mvp.example.R
import com.mvp.example.presenter.OrderPresenter

class OrderActivity : AppCompatActivity(), OrderView {
    private lateinit var americanoCountText: TextView
    private lateinit var totalPriceText: TextView
    private var present: OrderPresenter = OrderPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val americanoDeleteButton = findViewById<Button>(R.id.americanoDeleteButton)
        val americanoAddButton = findViewById<Button>(R.id.americanoAddButton)

        americanoCountText = findViewById<TextView>(R.id.americanoCountText)
        totalPriceText = findViewById<TextView>(R.id.totalPriceText)

        americanoDeleteButton.setOnClickListener {
            present.deleteAmericano()
        }

        americanoAddButton.setOnClickListener {
            present.addAmericano()
        }
    }

    override fun setAmericanoCounterText(count: Int) {
        americanoCountText.text = "$count"
    }

    override fun setTotalPriceText(price: Int) {
        totalPriceText.text = "$price"
    }
}