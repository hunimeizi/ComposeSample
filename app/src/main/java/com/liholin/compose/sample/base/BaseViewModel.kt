package com.liholin.compose.sample.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel(){
    /**
     * 用流的方式进行网络请求
     */
    fun <T> getFlow(block: suspend () -> T): Flow<T> {
        return flow {
            emit(block())
        }
    }

    fun launchUI(block: suspend CoroutineScope.() -> Unit) = viewModelScope.launch { block() }

    protected fun <T> launchFlow(block: suspend () -> T, successBlock: (T) -> Unit) {
        launchUI {
            getFlow {
                block()
            }/*.flatMapConcat {
                getFlow {

                }
            }*/.flowOn(Dispatchers.IO)
                .catch { e ->

                }.onStart { }.onCompletion {
                }.collect {
                    successBlock.invoke(it)
                }
        }
    }
}