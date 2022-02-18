package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.utils.CompanionLogger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

interface Search<R, T : Any, ID : Any> : APIOperation<R, T, ID> {

    @PostMapping("/search")
    fun search(@Valid @RequestBody dto: R) =
        service
            .log { info("Searching entities") }
            .search(dto)
            .log { info("Search successfully") }

    companion object : CompanionLogger()
}
