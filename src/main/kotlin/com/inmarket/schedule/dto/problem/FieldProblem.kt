package com.inmarket.schedule.dto.problem

import org.springframework.http.HttpStatus
import java.net.URI

class Field(
    val field: String,
    val value: Any,
    val message: String
)

class FieldProblem(
    type: URI,
    title: String,
    status: HttpStatus,
    detail: String,
    instance: URI,

    val fields: List<Field>,
) : Problem(type, title, status, detail, instance)
