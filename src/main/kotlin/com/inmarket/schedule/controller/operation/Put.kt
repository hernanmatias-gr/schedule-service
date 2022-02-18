package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.utils.CompanionLogger
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import javax.validation.Valid

interface Put<R, T : Any, ID : Any> : APIOperation<R, T, ID> {

    @PutMapping("/{id}")
    fun update(@Valid @RequestBody dto: R, @PathVariable id: ID) =

        service
            .log { info("Updating entity with id $id") }
            .update(id, dto)
            .log { info("Update successful") }


    companion object : CompanionLogger()
}
