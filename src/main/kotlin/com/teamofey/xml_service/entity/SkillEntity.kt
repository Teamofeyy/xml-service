package com.teamofey.xml_service.entity

import jakarta.persistence.*

@Entity
@Table(name = "skills")
class SkillEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null,

  var name: String,
  var hard: Boolean? = null,
  var soft: Boolean? = null,

  @ManyToMany(mappedBy = "skills")
  var students: MutableSet<StudentEntity> = mutableSetOf()
) {
  fun addStudent(student: StudentEntity) {
    students.add(student)
    student.skills.add(this)
  }
}
