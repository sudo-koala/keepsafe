package com.ralphmarondev.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun createDate(): String{
    val currentDateTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a")
    val createDate = currentDateTime.format(formatter)

    return createDate
}