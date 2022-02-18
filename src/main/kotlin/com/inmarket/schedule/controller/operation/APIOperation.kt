package com.inmarket.schedule.controller.operation

import com.inmarket.schedule.service.AbstractService

interface APIOperation<R, T : Any, ID : Any> {
    val service: AbstractService<R, T, ID>
}
