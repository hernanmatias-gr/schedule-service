package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.utils.CompanionLogger
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable

interface Delete<R, T : Any, ID : Any> : APIOperation<R, T, ID> {

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: ID) =
        service
            .log { info("Deleting entity with id $id") }
            .deleteById(id)
            .log { info("Delete successful") }

    companion object : CompanionLogger()
}
