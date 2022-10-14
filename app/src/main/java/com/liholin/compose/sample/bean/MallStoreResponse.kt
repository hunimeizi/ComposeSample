package com.liholin.compose.sample.bean

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MallStoreResponseItem{
    var remark: String? = ""
    var storeCode: String? = ""
    var storeId: Int? = 0
    var storeName: String? = ""
    var storeStatus: String? = ""
    var shopLogo: String? = ""
    var clicked by mutableStateOf(false)
}

