
package com.fahimezv.githubrepositorylist.core.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import org.json.JSONObject

class ModelUtils(private val builder: GsonBuilder) {

    fun build(): Gson {
        return builder.create()
    }

    @Suppress("public")
    fun toJsonString(any: Any): String {
        return build().toJson(any)
    }

    @Suppress("unused")
    @Throws(JSONException::class)
    fun toJsonObject(any: Any): JSONObject {
        return JSONObject(toJsonString(any))
    }


    inline fun <reified T> toModel(json: String): T? {
        return try {
            val typeToken = object : TypeToken<T>() {}.type
            build().fromJson(json, typeToken)
        } catch (e: Throwable) {
            e.printStackTrace()
            null
        }
    }

    @Suppress("unused")
    inline fun <reified T> toModelList(json: String): List<T>? {
        return if (json.isEmpty()) null else try {
            val typeToken = object : TypeToken<List<T>>() {}.type
            build().fromJson(json, typeToken)
        } catch (e: Throwable) {
            ArrayList()
        }
    }

}
