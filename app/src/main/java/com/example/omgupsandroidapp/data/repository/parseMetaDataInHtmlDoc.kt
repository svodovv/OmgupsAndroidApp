package com.omgupsapp.data.repository

import android.util.Log
import org.jsoup.Jsoup

internal fun parseMetaDataInHtmlDoc(htmlContent: String, metaName: String): String? {
    return try {
        val element = Jsoup.parse(htmlContent).select("meta[name=$metaName]").first()
        element?.attr("content")
    } catch (e: Exception) {
        e.printStackTrace()
        "Error in parsing fun"
    }
}

internal fun parseTitleInHtmlDoc(htmlContent: String): String? {
    val example = htmlContent
    val withOutSpaces = example.replace(" ", "")
        //Log.e("htmlContent", withOutSpaces)
    return Jsoup.parse(htmlContent).title()
}

internal fun parseLkTestAuth(html: String, entryName: String): Boolean {
    val doc = Jsoup.parse(html)
    val cardBody = doc.select( "а.profile-group"/*"div.card-body"*/).first()
    Log.e("htmlContent", html)
    val text = cardBody?.text()?.trim()

    return text != null && text.contains(entryName)
}