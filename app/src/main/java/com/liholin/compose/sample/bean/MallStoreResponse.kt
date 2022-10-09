package com.liholin.compose.sample.bean

import com.google.gson.annotations.SerializedName

class MallStoreResponseItem(
    @SerializedName("remark")
    var remark: String? = "",
    @SerializedName("storeCode")
    var storeCode: String? = "",
    @SerializedName("storeId")
    var storeId: Int? = 0,
    @SerializedName("storeName")
    var storeName: String? = "",
    @SerializedName("storeStatus")
    var storeStatus: String? = "",
    @SerializedName("shopLogo")
    var shopLogo: String? = "",
    var clicked: Boolean = false,
)

