package com.example.omgupsandroidapp.presentation.utils

fun String.portable(portableIndex: Int): String {
    return this.split(" ").flatMapIndexed { index, it ->
        if (index == portableIndex) listOf("\n$it") else listOf(it)
    }.joinToString(" ")
}

