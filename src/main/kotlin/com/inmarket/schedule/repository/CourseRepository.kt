package com.inmarket.schedule.repository

import com.inmarket.schedule.model.Course
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface CourseRepository : CustomRepository<Course, Int> {

    fun findByStudents_StudentId(studentId: BigInteger): List<Course>
}
