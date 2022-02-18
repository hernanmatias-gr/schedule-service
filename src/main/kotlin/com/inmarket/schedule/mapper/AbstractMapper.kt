package com.inmarket.schedule.mapper

interface AbstractMapper<R, T> {
    fun toEntity(dto: R): T
    fun toDto(entity: T): R
}
