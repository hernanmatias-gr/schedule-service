package com.inmarket.schedule.utils

import java.util.Locale

private val CAMEL_REGEX = "(?<=[a-zA-Z])[A-Z]".toRegex()

fun String.camelToSnakeCase(): String {
    return replace(CAMEL_REGEX) {
        "_${it.value}"
    }.lowercase(Locale.getDefault())
}
