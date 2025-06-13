package com.teamofey.xml_service

import com.teamofey.xml_service.entity.*
import com.teamofey.xml_service.jaxb.StudentsDto
import com.teamofey.xml_service.repository.*
import jakarta.xml.bind.JAXBContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.InputStreamReader

@Service
class XmlService(
  private val jaxbContext: JAXBContext,
  private val studentRepo: StudentRepository,
  private val skillRepository: SkillRepository
) {
  @Transactional
  fun importFromXml(file: MultipartFile) {
    val unmarshaller = jaxbContext.createUnmarshaller()
    val dto = unmarshaller.unmarshal(InputStreamReader(file.inputStream)) as StudentsDto

    dto.studentList.forEach { studentDto ->
      val student = StudentEntity(
        firstName = studentDto.firstName.orEmpty(),
        secondName = studentDto.secondName.orEmpty()
      )

      studentDto.skills.forEach { skillDto ->
        val skill = skillRepository.findByName(skillDto.name ?: "")
          ?: SkillEntity(
            name = skillDto.name.orEmpty(),
            hard = skillDto.hard,
            soft = skillDto.soft
          ).also { skillRepository.save(it) }

        student.addSkill(skill)
      }

      studentRepo.save(student)
    }
  }
}
