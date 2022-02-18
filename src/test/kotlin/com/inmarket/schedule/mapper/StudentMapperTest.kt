package com.inmarket.schedule.mapper


import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.model.Student
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.math.BigInteger

class StudentMapperTest : BehaviorSpec() {

    private val studentMapper = StudentMapper()

    init {
        Given("a dto is initialized") {
            val dto = StudentDto(
                studentId = BigInteger.ONE,
                firstName = "fisrt name",
                lastName = "last name"
            )
            When("mapping it to dto") {
                val entity = studentMapper.toEntity(dto)
                Then("mapping is correct") {
                    entity.studentId shouldBe dto.studentId
                    entity.firstName shouldBe dto.firstName
                    entity.lastName shouldBe dto.lastName
                }
            }
        }
    }


}
