package com.inmarket.schedule.dto


data class CourseDto(

    val code: Int?,

    val title: String?,

    val description: String?,

    val students: List<StudentDto>?

)
