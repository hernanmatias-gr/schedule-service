package com.inmarket.schedule.controller

import com.inmarket.schedule.controller.operation.*
import com.inmarket.schedule.service.AbstractService

open class CrudController<R, T : Any, ID : Any>(
    override val service: AbstractService<R, T, ID>,
) : GetById<R, T, ID>,
    Get<R, T, ID>,
    Post<R, T, ID>,
    Put<R, T, ID>,
    Delete<R, T, ID>
