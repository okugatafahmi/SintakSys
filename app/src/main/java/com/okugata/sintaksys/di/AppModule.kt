package com.okugata.sintaksys.di

import com.okugata.sintaksys.MainViewModel
import com.okugata.sintaksys.domain.usecase.SintaksysInteractor
import com.okugata.sintaksys.domain.usecase.SintaksysUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SintaksysUseCase> { SintaksysInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}