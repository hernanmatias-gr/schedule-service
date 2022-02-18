package com.inmarket.schedule.controller.course

import com.inmarket.schedule.controller.CrudController
import com.inmarket.schedule.dto.CourseDto
import com.inmarket.schedule.model.Course
import com.inmarket.schedule.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigInteger

@RestController("courseController")
@RequestMapping("courses")
class CourseController(private val courseService: CourseService) :
    CrudController<CourseDto, Course, Int>(courseService) {

    @GetMapping("/student/{studentId}")
    fun findAllByStudentId(@PathVariable studentId: BigInteger) =
        courseService.findAllByStudentId(studentId)


}


