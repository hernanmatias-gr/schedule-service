package com.inmarket.schedule.dto.problem

import org.springframework.http.HttpStatus
import java.net.URI



open class Problem(
    val type: URI,

    val title: String,

    val status: HttpStatus,

    val detail: String,

    val instance: URI
)
