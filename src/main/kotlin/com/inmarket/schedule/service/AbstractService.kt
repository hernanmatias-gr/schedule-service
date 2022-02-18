package com.inmarket.schedule.service

import com.inmarket.schedule.mapper.AbstractMapper
import com.inmarket.schedule.repository.CustomRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull

abstract class AbstractService<R, T : Any, ID : Any>(
    private val repository: CustomRepository<T, ID>,
    protected val mapper: AbstractMapper<R, T>
) {
    fun findAll(pageable: Pageable) =
        repository
            .findAll(pageable)

    fun search(dto: R) =
        repository
            .findAll(
                Example.of(mapper.toEntity(dto))
            )


    fun findById(id: ID) =
        repository
            .findByIdOrNull(id)

    fun save(dto: R) =
        mapper
            .toEntity(dto)
            .persist()

    fun update(id: ID, dto: R): T {
        findById(id)
        return save(dto)
    }

    fun deleteById(id: ID) =
        repository.deleteById(id)

    private fun T.persist() =
        repository.save(this)
}
