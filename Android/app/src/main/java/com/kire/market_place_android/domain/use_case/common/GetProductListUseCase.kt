package com.kire.market_place_android.domain.use_case.common

import com.kire.market_place_android.domain.repository.IProductRepository
import javax.inject.Inject

/**
 * By Michael Gontarev (KiREHwYE)*/
class GetProductListUseCase @Inject constructor(
    private val productRepository: IProductRepository
) {

    operator fun invoke() = { /*TODO*/ }
}