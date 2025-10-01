package vn.edu.tlu.buicongson.football247_mobile.constants

object DatasourceProperties {

    fun getUrl(): String {
        return SERVER_URL
    }

    const val SERVER_URL = "http://192.168.1.120:7087/"
    const val TIMEOUT_CONNECT: Long = 30
    const val TIMEOUT_READ: Long = 90
}