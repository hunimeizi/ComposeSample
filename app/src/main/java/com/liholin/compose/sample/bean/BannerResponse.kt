package com.liholin.compose.sample.bean

import com.google.gson.annotations.SerializedName

data class BannerResponse(
    @SerializedName("countId")
    var countId: Int? = 0,
    @SerializedName("current")
    var current: Int? = 0,
    @SerializedName("hitCount")
    var hitCount: Boolean? = false,
    @SerializedName("maxLimit")
    var maxLimit: Int? = 0,
    @SerializedName("optimizeCountSql")
    var optimizeCountSql: Boolean? = false,
    @SerializedName("orders")
    var orders: List<Any?>? = null,
    @SerializedName("pages")
    var pages: Int? = 0,
    @SerializedName("records")
    var records: List<Record>? = null,
    @SerializedName("searchCount")
    var searchCount: Boolean? = false,
    @SerializedName("size")
    var size: Int? = 0,
    @SerializedName("total")
    var total: Int? = 0
)

data class Record(
    @SerializedName("adcode")
    var adcode: Int? = 0,
    @SerializedName("admaterialId")
    var admaterialId: Int? = 0,
    @SerializedName("createdBy")
    var createdBy: String? = "",
    @SerializedName("createdTime")
    var createdTime: String? = "",
    @SerializedName("deleted")
    var deleted: Int? = 0,
    @SerializedName("description")
    var description: String? = "",
    @SerializedName("group")
    var group: String? = "",
    @SerializedName("orderBy")
    var orderBy: Int? = 0,
    @SerializedName("pic")
    var pic: String? = "",
    @SerializedName("revision")
    var revision: String? = "",
    @SerializedName("status")
    var status: Int? = 0,
    @SerializedName("tenantId")
    var tenantId: String? = "",
    @SerializedName("title")
    var title: String? = "",
    @SerializedName("updatedBy")
    var updatedBy: String? = "",
    @SerializedName("updatedTime")
    var updatedTime: String? = "",
    @SerializedName("url")
    var url: String? = ""
)