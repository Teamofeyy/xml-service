package com.teamofey.xml_service.jaxb

import jakarta.xml.bind.annotation.*

@XmlAccessorType(XmlAccessType.FIELD)
class SkillDto {
  @XmlValue
  var name: String? = null

  @XmlAttribute(name = "hard")
  var hard: Boolean? = null

  @XmlAttribute(name = "soft")
  var soft: Boolean? = null
}
