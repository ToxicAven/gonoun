package dev.toxicaven.gonoun.util

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException


class PDBCaller {
    fun run(uid: String): String? {
        val client = OkHttpClient()
        val request : Request = Request.Builder()
            .url("https://pronoundb.org/api/v1/lookup?platform=discord&id=$uid")
            .build()
        try {
            val response: Response = client.newCall(request).execute()
            val body: String = response.body!!.string()
            response.close()
            return JSONObject(body).get("pronouns").toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}
