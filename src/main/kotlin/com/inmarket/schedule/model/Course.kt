package com.inmarket.schedule.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
data class Course(

    @Id
    @field:NotNull
    var code: Int?,
    @field:NotBlank
    var title: String?,
    var description: String?,

    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinTable(
        name = "students",
        joinColumns = [JoinColumn(name = "code")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    @JsonIgnoreProperties("courses")
    var students: List<Student>? = mutableListOf()

)
