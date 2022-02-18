package com.inmarket.schedule.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.math.BigInteger
import javax.validation.constraints.Max
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class StudentDto(

    val studentId: BigInteger?,

    val firstName: String?,

    val lastName: String?,


)
