package com.inmarket.schedule.mapper

import com.inmarket.schedule.dto.CourseDto
import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.model.Course
import com.inmarket.schedule.model.Student
import org.springframework.stereotype.Component

@Component("courseMapper")
class CourseMapper(private val studentMapper: StudentMapper) : AbstractMapper<CourseDto, Course> {


    override fun toEntity(dto: CourseDto) =
        Course(
            code = dto.code,
            title = dto.title,
            description = dto.description,
            students = dto.students?.map { studentMapper.toEntity(it) }
        )

    override fun toDto(entity: Course): CourseDto {
        TODO("You could implement this method to decouple the response from the view" +
                "For time reasons, I am returning the object directly retrieved from the database")
    }

}
