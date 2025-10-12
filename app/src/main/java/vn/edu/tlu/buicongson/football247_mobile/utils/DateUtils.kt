package vn.edu.tlu.buicongson.football247_mobile.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun convertCreatedAt(createdAt: String?): String? {
    if (createdAt != null) {
        val dateTime = LocalDateTime.parse(createdAt)

        val formatter = DateTimeFormatter.ofPattern("MMM, d, yyyy", Locale.ENGLISH)

        return dateTime.format(formatter)
    }
    return createdAt
}