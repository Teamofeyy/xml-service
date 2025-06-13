package com.teamofey.xml_service.jaxb

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
class StudentDto {
  @XmlElement(name = "first_name")
  var firstName: String? = null

  @XmlElement(name = "second_name")
  var secondName: String? = null

  @XmlElementWrapper(name = "skills")
  @XmlElement(name = "skill")
  var skills: MutableList<SkillDto> = mutableListOf()
}
