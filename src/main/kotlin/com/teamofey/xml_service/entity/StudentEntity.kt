package com.teamofey.xml_service.entity

import jakarta.persistence.*

@Entity
@Table(name = "students")
class StudentEntity(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id: Long? = null,

  var firstName: String,
  var secondName: String,

  @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
  @JoinTable(
    name = "student_skills",
    joinColumns = [JoinColumn(name = "student_id")],
    inverseJoinColumns = [JoinColumn(name = "skill_id")]
  )
  var skills: MutableSet<SkillEntity> = mutableSetOf()
) {
  fun addSkill(skill: SkillEntity) {
    skills.add(skill)
    skill.students.add(this)
  }
}
