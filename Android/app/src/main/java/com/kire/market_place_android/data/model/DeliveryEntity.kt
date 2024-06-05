package com.kire.market_place_android.data.model

/**
 * By Aleksey Timko (de4ltt)*/
data class DeliveryEntity(
    val deliveryId: Int,
    val productItem: ProductItemEntity,
    val quantity: Int,
    val deliveryStatus: DeliveryStatusEntity,
    val deliveryCode: Int,
    val deliveryStart: String,
    val deliveryEstimate: String,
    val deliveryEnd: String?
)
