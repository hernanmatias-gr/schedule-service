package com.inmarket.schedule.service

import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.mapper.CourseMapper
import com.inmarket.schedule.mapper.StudentMapper
import com.inmarket.schedule.model.Student
import com.inmarket.schedule.repository.StudentRepository
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.springframework.data.domain.Example
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import java.math.BigInteger

class StudentServiceTest : BehaviorSpec() {

    private val repository = mockk<StudentRepository>()
    private val studentMapper = StudentMapper()

    private val studentService = StudentService(studentRepository = repository, mapper = studentMapper)

    init {
        beforeTest {
            every { repository.findAll(Pageable.unpaged()) } returns PageImpl(STUDENTS)
            every { repository.findByIdOrNull(any()) } returns STUDENT
            every { repository.findByCourses_Code(any()) } returns STUDENTS
            every { repository.deleteById(any()) } just runs
        }

        afterTest {
            clearMocks(repository)
        }

        Given("an id with value 1 is initialized") {
            val id = BigInteger.ONE
            When("the id is sent to the service") {
                val student = studentService.findById(id)
                Then("student id should be 1") {
                    student.studentId shouldBe STUDENT.studentId
                    student.firstName shouldBe STUDENT.firstName
                    student.lastName shouldBe STUDENT.lastName
                }
            }
        }

        Given("an codeCourse with value 1 is initialized") {
            val codeCourse = 1
            When("the id is sent to the service") {
                val students = studentService.findAllByCourseCode(codeCourse)
                Then("two students are found") {
                    students.size shouldBe 2
                    students shouldContainExactly STUDENTS
                }
            }
        }


        Given("all students needs to be searched") {
            When("all students are being searched") {
                val students = studentService.findAll(Pageable.unpaged())
                Then("two students are found") {
                    students.size shouldBe 2
                    students shouldContainExactly STUDENTS
                }
            }
        }

        Given("an entity with id 1 wants to be deleted") {
            val id = BigInteger.ONE
            When("the id is sent to the service") {
                Then("delete successfully runs") {
                    shouldNotThrowAny {
                        studentService.deleteById(id)
                    }
                }
            }
        }
    }

    companion object {
        private val STUDENTS = listOf(
            Student(BigInteger.ONE, "First name 1", "last name 1"),
            Student(BigInteger.TWO, "First name 2", "last name 2")
        )

        private val STUDENT = Student(BigInteger.ONE, "First name 1", "last name 1")
    }
}
