package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.utils.CompanionLogger
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

interface GetById<R, T : Any, ID : Any> : APIOperation<R, T, ID> {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: ID) =
        service
            .log { info("Finding entity by id {}", id) }
            .findById(id)
            .log { info("Find by id successful") }

    companion object : CompanionLogger()
}
