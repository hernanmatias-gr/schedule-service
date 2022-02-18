package com.inmarket.schedule.repository

import com.inmarket.schedule.model.Student
import org.springframework.stereotype.Repository
import java.math.BigInteger

@Repository
interface StudentRepository : CustomRepository<Student, BigInteger> {

    fun findByCourses_Code(courseCode: Int): List<Student>

}
