package com.inmarket.schedule.constant

import org.springframework.http.HttpStatus
import java.net.URI

enum class ProblemType(
    val type: URI,
    val title: String,
    val status: HttpStatus
) {

    HTTP_BAD_REQUEST(
        URI.create("https://ms-scheduling/http_bad_request"),
        HttpStatus.BAD_REQUEST.reasonPhrase,
        HttpStatus.BAD_REQUEST
    ),

    HTTP_METHOD_NO_FOUND(
        URI.create("https://ms-scheduling/method_not_found"),
        HttpStatus.NOT_FOUND.reasonPhrase,
        HttpStatus.NOT_FOUND
    ),

    HTTP_REQUEST_METHOD_NOT_SUPPORTED(
        URI.create("https://ms-scheduling/http_request_method_not_supported"),
        HttpStatus.METHOD_NOT_ALLOWED.reasonPhrase,
        HttpStatus.METHOD_NOT_ALLOWED
    ),

    RESOURCE_NOT_FOUND(
        URI.create("https://ms-scheduling/resource_not_found"),
        HttpStatus.NOT_FOUND.reasonPhrase,
        HttpStatus.NOT_FOUND
    ),

    INTERNAL_SERVER_ERROR(
        URI.create("https://ms-scheduling/internal_server_error"),
        HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
        HttpStatus.INTERNAL_SERVER_ERROR
    )
}
