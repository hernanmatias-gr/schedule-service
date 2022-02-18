package com.inmarket.schedule.mapper

import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.model.Course
import com.inmarket.schedule.model.Student
import org.springframework.stereotype.Component

@Component("studentMapper")
class StudentMapper : AbstractMapper<StudentDto, Student> {
    override fun toEntity(dto: StudentDto) =
        Student(
            studentId = dto.studentId,
            firstName = dto.firstName,
            lastName = dto.lastName
        )

    override fun toDto(entity: Student): StudentDto {
        TODO("You could implement this method to decouple the response from the view" +
                "For time reasons, I am returning the object directly retrieved from the database")
    }


}
