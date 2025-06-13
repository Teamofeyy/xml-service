package com.teamofey.xml_service

import jakarta.xml.bind.JAXBContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JaxbConfig {
  @Bean
  fun jaxbContext(): JAXBContext = JAXBContext.newInstance(
    com.teamofey.xml_service.jaxb.StudentsDto::class.java
  )
}
