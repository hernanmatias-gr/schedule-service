package com.inmarket.schedule.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigInteger
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Student(
    @Id
    @field:NotNull
    val studentId: BigInteger?,
    @field:NotBlank
    val firstName: String?,
    @field:NotBlank
    val lastName: String?,
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("students")
    var courses: List<Course>? = mutableListOf()

)
