package com.teamofey.xml_service.repository

import com.teamofey.xml_service.entity.SkillEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<SkillEntity, Long>{
  fun findByName(name: String): SkillEntity?
}
