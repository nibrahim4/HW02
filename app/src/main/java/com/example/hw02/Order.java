package com.example.hw02;

import java.io.Serializable;

public class Order implements Serializable {

    private Integer _toppingsCount = 0;
    private Double _basePizzePrice = 6.50;
    private Double _pricePerTopping = 1.50;
    private Double _deliveryPrice = 4.00;
    private Boolean _isDeliverySelected = false;
    private Double _orderTotal = 0.0;
    private Double _toppingsTotal = 0.0;

    public Order(Integer _toppingsCount,  Boolean _isDeliverySelected) {
        this._toppingsCount = _toppingsCount;
        this._isDeliverySelected = _isDeliverySelected;
    }

    public Double GetTotalOrder(){

        this._orderTotal = (this._toppingsCount * this._pricePerTopping) + this._basePizzePrice;

        if(this._isDeliverySelected){
            this._orderTotal += this._deliveryPrice;
        }

        return this._orderTotal;
    }

    public Double GetToppingsTotal(){
        this._toppingsTotal = (this._toppingsCount * this._pricePerTopping);
        return this._toppingsTotal;
    }

    public boolean IsDeliveryChecked(){
        return this._isDeliverySelected;
    }

    public Double GetDeliveryCost(){
        return this._deliveryPrice;
    }

    public Integer GetToppingsCount(){
        return this._toppingsCount;
    }
}
