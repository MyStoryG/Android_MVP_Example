package com.mvp.example.presenter

import com.mvp.example.model.Americano
import com.mvp.example.model.Beverage
import com.mvp.example.model.TotalPrice
import com.mvp.example.view.OrderView

class OrderPresenter(
    private var view: OrderView,
    private var menuModel: Beverage = Americano(),
    private var totalModel: TotalPrice = TotalPrice()
) : Presenter {
    override fun deleteAmericano() {
        menuModel.delete()
        view.setAmericanoCounterText(menuModel.quantity)
        updateTotalPriceSubtraction(menuModel.price)
    }

    override fun addAmericano() {
        menuModel.add()
        view.setAmericanoCounterText(menuModel.quantity)
        updateTotalPriceAddition(menuModel.price)
    }

    private fun updateTotalPriceSubtraction(price: Int) {
        totalModel.decreaseTotalPrice(price)
        view.setTotalPriceText(totalModel.totalPrice)
    }

    private fun updateTotalPriceAddition(price: Int) {
        totalModel.increaseTotalPrice(price)
        view.setTotalPriceText(totalModel.totalPrice)
    }
}