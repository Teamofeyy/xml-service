package com.teamofey.xml_service.jaxb

import jakarta.xml.bind.annotation.*

@XmlRootElement(name = "students")
@XmlAccessorType(XmlAccessType.FIELD)
class StudentsDto {
  @XmlElement(name = "student")
  var studentList: MutableList<StudentDto> = mutableListOf()
}
