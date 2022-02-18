package com.inmarket.schedule.service

import com.inmarket.schedule.dto.CourseDto
import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.mapper.CourseMapper
import com.inmarket.schedule.mapper.StudentMapper
import com.inmarket.schedule.model.Course
import com.inmarket.schedule.model.Student
import com.inmarket.schedule.repository.CourseRepository
import com.inmarket.schedule.repository.StudentRepository
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service("courseService")
class CourseService(
    private val courseRepository: CourseRepository,
    mapper: CourseMapper
) : AbstractService<CourseDto, Course, Int>(courseRepository, mapper) {


    fun findAllByStudentId(studentId: BigInteger) =
        courseRepository.findByStudents_StudentId(studentId)

}