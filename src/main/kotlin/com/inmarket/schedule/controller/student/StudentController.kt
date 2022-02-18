package com.inmarket.schedule.controller.student

import com.inmarket.schedule.controller.CrudController
import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.model.Student
import com.inmarket.schedule.service.StudentService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController("studentController")
@RequestMapping("students")
class StudentController(private val studentsService: StudentService) :
    CrudController<StudentDto, Student, BigInteger>(studentsService) {

    @GetMapping("/course/{courseCode}")
    fun findAllByCourseCode(@PathVariable courseCode: Int) =
        studentsService.findAllByCourseCode(courseCode)


}


