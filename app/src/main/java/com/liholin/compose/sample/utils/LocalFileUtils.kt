package com.liholin.compose.sample.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.BufferedReader
import java.io.ByteArrayOutputStream
import java.io.InputStreamReader

object LocalFileUtils {
    /**
     * 获取Asset下文本内容
     *
     * @param context
     * @param str
     * @return
     */
    fun getStringFormAsset(context: Context, str: String): String {
        BufferedReader(InputStreamReader(context.assets.open(str))).use { it ->
            var line: String?
            val buffer = StringBuilder()
            while(it.readLine().also { line = it } != null) {
                buffer.append(line).append('\n')
            }
           return buffer.toString()
        }
    }

    /**
     * @description 从Assets中读取图片
     *
     * @param context
     * @param fileName
     * @return 图片
     * @date 2015-6-11 15:00:55
     */
    fun getImageFromAssetsFile(context: Context, fileName: String): Bitmap? {
        context.assets.open(fileName).use {
            return BitmapFactory.decodeStream(it)
        }
    }

    /**
     * 获取Raw下文本内容
     * @param context
     * @param rawId
     * @return
     */
    fun getStringFormRaw(context: Context, rawId: Int): String {
        ByteArrayOutputStream().use { it ->
            val buffer = ByteArray(1024)
            var len: Int
            while(context.resources.openRawResource(rawId).read(buffer).also { len = it } != -1) {
                it.write(buffer, 0, len)
            }
            return it.toString()
        }
    }
}