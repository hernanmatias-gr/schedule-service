package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.utils.CompanionLogger
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping

interface Get<R, T : Any, ID : Any> : APIOperation<R, T, ID> {

    @GetMapping
    fun findAll(pageable: Pageable) =
        service
            .log { info("Finding all elements") }
            .findAll(pageable)
            .log { info("findAll successful") }

    companion object : CompanionLogger()
}
