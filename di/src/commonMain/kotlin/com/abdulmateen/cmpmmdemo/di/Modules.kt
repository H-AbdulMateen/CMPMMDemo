package com.abdulmateen.cmpmmdemo.di

import com.abdulmateen.cmpmmdemo.core.network.ktor.HttpClientFactory
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.KtorProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.data.network.ktor.RemoteProductsDataSource
import com.abdulmateen.cmpmmdemo.feature.products.data.repository.ProductRepositoryImpl
import com.abdulmateen.cmpmmdemo.feature.products.domain.ProductRepository
import com.abdulmateen.cmpmmdemo.feature.products.presentation.product_list.ProductListViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorProductsDataSource).bind<RemoteProductsDataSource>()
    singleOf(::ProductRepositoryImpl).bind<ProductRepository>()

    viewModelOf(::ProductListViewModel)


}