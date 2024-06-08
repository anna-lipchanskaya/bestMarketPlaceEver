package com.kire.market_place_android.data.mapper

import com.kire.market_place_android.data.model.ProductCategoryEntity
import com.kire.market_place_android.domain.model.ProductCategoryDomain

/**
 * By Michael Gontarev (KiREHwYE)*/
fun ProductCategoryEntity.asProductCategoryDomain() =
    ProductCategoryDomain.valueOf(this.categoryName)