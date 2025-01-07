package com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor

sealed class FakeProductDataSourceResponseType {

   data object Empty : FakeProductDataSourceResponseType()
   data object SuccessData : FakeProductDataSourceResponseType()
}