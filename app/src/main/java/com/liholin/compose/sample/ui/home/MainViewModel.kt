package com.liholin.compose.sample.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.liholin.compose.sample.base.BaseApplication
import com.liholin.compose.sample.base.BaseViewModel
import com.liholin.compose.sample.bean.MallStoreResponseItem
import com.liholin.compose.sample.utils.LocalFileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel() {
    var phone by mutableStateOf("1866677889")
    var homeIndex by mutableStateOf(0)
    var homeCount by mutableStateOf(12)

    val mainChannel = Channel<MainIntent>(Channel.UNLIMITED)
    var uiState by mutableStateOf(MainState())

    init {
        handleIntent()
    }

    private fun handleIntent(){
        viewModelScope.launch {
            mainChannel.consumeAsFlow().collect{
                when(it){
                  is MainIntent.GetStoreData -> getStoreData()
                }
            }
        }
    }

    private fun getStoreData(){
        launchFlow({
            getData()
        },{
            uiState = uiState.copy(storeData = it?.toMutableList() ?: mutableListOf())
        })
//        return Gson().fromJson(
//            LocalFileUtils.getStringFormAsset(BaseApplication.context, "storeData.json"),
//            object : TypeToken<MutableList<MallStoreResponseItem?>?>() {}.type
//        )
    }

}

private suspend fun getData() = withIO<MutableList<MallStoreResponseItem>?> {
    Gson().fromJson(
        LocalFileUtils.getStringFormAsset(BaseApplication.context, "storeData.json"),
        object : TypeToken<MutableList<MallStoreResponseItem>?>() {}.type)
}
private suspend fun <T> withIO(block: suspend () -> T): T {
    return withContext(Dispatchers.IO) {
        block.invoke()
    }
}

data class MainState(
    val storeData: List<MallStoreResponseItem> = emptyList()
)

sealed class MainIntent{
    object GetStoreData : MainIntent()
}