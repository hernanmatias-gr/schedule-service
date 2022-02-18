package com.inmarket.schedule.service

import com.inmarket.schedule.mapper.StudentMapper
import com.inmarket.schedule.mapper.CourseMapper
import com.inmarket.schedule.model.Course
import com.inmarket.schedule.repository.CourseRepository
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import java.math.BigInteger

class CourseServiceTest : BehaviorSpec() {

    private val repository = mockk<CourseRepository>()
    private val studentMapper = mockk<StudentMapper>()
    private val courseMapper = CourseMapper(studentMapper)

    private val courseService = CourseService(courseRepository = repository, mapper = courseMapper)

    init {
        beforeTest {
            every { repository.findAll(Pageable.unpaged()) } returns PageImpl(COURSES)
            every { repository.findByIdOrNull(any()) } returns COURSE
            every { repository.findByStudents_StudentId(any()) } returns COURSES
            every { repository.deleteById(any()) } just runs
        }

        afterTest {
            clearMocks(repository)
        }

        Given("an id with value 1 is initialized") {
            val id = 1
            When("the id is sent to the service") {
                val course = courseService.findById(id)
                Then("course id should be 1") {
                    course.code shouldBe COURSE.code
                    course.title shouldBe COURSE.title
                    course.description shouldBe COURSE.description
                }
            }
        }

        Given("an codeCourse with value 1 is initialized") {
            val id = BigInteger.ONE
            When("the id is sent to the service") {
                val courses = courseService.findAllByStudentId(id)
                Then("two students are found") {
                    courses.size shouldBe 2
                    courses shouldContainExactly COURSES
                }
            }
        }

        Given("all sample needs to be searched") {
            When("all sample are being searched") {
                val courses = courseService.findAll(Pageable.unpaged())
                Then("two sample are found") {
                    courses.size shouldBe 2
                    courses shouldContainExactly COURSES
                }
            }
        }

        Given("an entity with id 1 wants to be deleted") {
            val id = 1
            When("the id is sent to the service") {
                Then("delete successfully runs") {
                    shouldNotThrowAny {
                        courseService.deleteById(id)
                    }
                }
            }
        }
    }

    companion object {
        private val COURSES = listOf(
            Course(1, "title 1", "desc 1"),
            Course(2, "title 2", "desc 2")
        )

        private val COURSE = Course(1, "title 1", "desc 1")
    }
}
