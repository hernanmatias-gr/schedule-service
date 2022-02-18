package com.inmarket.schedule.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.query.QueryByExampleExecutor


@NoRepositoryBean
interface CustomRepository<T : Any, ID : Any> : JpaRepository<T, ID>,
    QueryByExampleExecutor<T>

