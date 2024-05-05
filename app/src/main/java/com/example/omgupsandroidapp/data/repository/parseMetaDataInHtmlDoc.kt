package com.omgupsapp.data.repository

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
    return Jsoup.parse(htmlContent).title()
}

internal fun parseLkTestAuth(html: String, entryName: String): Boolean {
    val doc = Jsoup.parse(html)
    val cardBody = doc.select("div.card-body").first()
    val text = cardBody?.text()?.trim()

    return text != null && text.contains(entryName)
}