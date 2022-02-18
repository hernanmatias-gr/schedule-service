package com.inmarket.schedule.mapper


import com.inmarket.schedule.dto.CourseDto
import com.inmarket.schedule.dto.StudentDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import java.math.BigInteger

class CourseMapperTest : BehaviorSpec() {

    private val studentMapper = StudentMapper()
    private val courseMapper = CourseMapper(studentMapper)

    init {
        Given("a dto is initialized") {
            val dto = CourseDto(
                code = 1,
                title = "title",
                description = "description",
                students = STUDENTSDTOs
            )
            When("mapping it to dto") {
                val entity = courseMapper.toEntity(dto)
                Then("mapping is correct") {
                    entity.code shouldBe dto.code
                    entity.title shouldBe dto.title
                    entity.description shouldBe dto.description
                    entity.students?.get(0)?.studentId shouldBe dto.students?.get(0)?.studentId
                    entity.students?.get(0)?.firstName shouldBe dto.students?.get(0)?.firstName
                    entity.students?.get(0)?.lastName shouldBe dto.students?.get(0)?.lastName
                }
            }
        }
    }

    companion object {
        private val STUDENTSDTOs = listOf(
            StudentDto(BigInteger.ONE, "First name 1", "last name 1"),
            StudentDto(BigInteger.TWO, "First name 2", "last name 2")
        )


    }
}
