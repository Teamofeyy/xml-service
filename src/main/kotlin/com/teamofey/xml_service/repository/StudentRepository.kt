package com.teamofey.xml_service.repository


import com.teamofey.xml_service.entity.StudentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<StudentEntity, Long>
