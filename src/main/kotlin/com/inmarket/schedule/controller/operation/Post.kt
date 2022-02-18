package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.utils.CompanionLogger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

interface Post<R, T : Any, ID : Any> : APIOperation<R, T, ID> {

    @PostMapping
    fun create(@Valid @RequestBody dto: R) =
        service
            .log { info("Creating entity") }
            .save(dto)
            .log { info("Entity successfully created") }

    companion object : CompanionLogger()
}
