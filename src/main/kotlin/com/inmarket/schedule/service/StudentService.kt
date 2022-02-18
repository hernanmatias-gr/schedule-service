package com.inmarket.schedule.service

import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.exception.ResourceNotFoundException
import com.inmarket.schedule.mapper.StudentMapper
import com.inmarket.schedule.model.Student
import com.inmarket.schedule.repository.StudentRepository
import org.springframework.stereotype.Service
import java.math.BigInteger

@Service("studentService")
class StudentService(
    private val studentRepository: StudentRepository,
    mapper: StudentMapper
) : AbstractService<StudentDto, Student, BigInteger>(studentRepository, mapper) {


    fun findAllByCourseCode(courseCode: Int) =
        studentRepository.findByCourses_Code(courseCode).takeIf { it.isNotEmpty() }
            ?: throw ResourceNotFoundException("Resource with $courseCode not found")
}