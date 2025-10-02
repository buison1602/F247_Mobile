package vn.edu.tlu.buicongson.football247_mobile.mappers

import vn.edu.tlu.buicongson.football247_mobile.networks.entities.news.Category
import vn.edu.tlu.buicongson.football247_mobile.networks.entities.response.CategoryResponse

fun CategoryResponse.toCategoryWrapper(): Category {
    return Category(category = this)
}