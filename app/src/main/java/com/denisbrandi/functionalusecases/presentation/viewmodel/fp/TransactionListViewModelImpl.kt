package com.denisbrandi.functionalusecases.presentation.viewmodel.fp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denisbrandi.functionalusecases.domain.model.SimpleResult
import com.denisbrandi.functionalusecases.domain.model.Transaction
import com.denisbrandi.functionalusecases.presentation.viewmodel.TransactionListViewModel
import com.denisbrandi.functionalusecases.presentation.viewmodel.TransactionListViewModel.State
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class TransactionListViewModelImpl(
    private val getTransactionsUseCase: () -> Single<SimpleResult<List<Transaction>>>
) : TransactionListViewModel, ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    override val state = MutableLiveData<State>()

    override fun loadTransactions() {
        state.postValue(State.Loading)
        getTransactionsUseCase().subscribeBy { handleResult(it) }
            .addTo(compositeDisposable)
    }

    private fun handleResult(getTransactionsResult: SimpleResult<List<Transaction>>) {
        getTransactionsResult.fold(
            success = { transactions -> state.postValue(State.Content(transactions)) },
            failure = { throwable -> state.postValue(State.Error(throwable.message.orEmpty())) }
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}