package com.inmarket.schedule.mapper

import com.inmarket.schedule.dto.CourseDto
import com.inmarket.schedule.dto.StudentDto
import com.inmarket.schedule.model.Course
import com.inmarket.schedule.model.Student
import org.springframework.stereotype.Component

@Component("courseMapper")
class CourseMapper : AbstractMapper<CourseDto, Course> {


    override fun toEntity(dto: CourseDto) =
        Course(
            code = dto.code,
            title = dto.title,
            description = dto.description
        )

    override fun toDto(entity: Course): CourseDto {
        TODO("You could implement this method to decouple the response from the view" +
                "For time reasons, I am returning the object directly retrieved from the database")
    }

}
