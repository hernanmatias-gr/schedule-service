package com.inmarket.schedule.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean


@NoRepositoryBean
interface CustomRepository<T : Any, ID : Any> : JpaRepository<T, ID>

