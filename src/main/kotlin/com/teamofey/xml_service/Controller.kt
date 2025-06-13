package com.teamofey.xml_service

import com.teamofey.xml_service.XmlService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/xml")
class XmlController(
  private val xmlService: XmlService
) {
  @PostMapping("/upload", consumes = ["multipart/form-data"])
  fun uploadXml(@RequestParam("file") file: MultipartFile): ResponseEntity<String> {
    return try {
       xmlService.importFromXml(file)
      ResponseEntity.ok("Импорт завершён успешно")
    } catch (e: Exception) {
      ResponseEntity.status(500).body("Ошибка импорта: ${e.message}")
    }
  }

  @GetMapping("/")
  fun redirectToUploadInterface(): String {
    return "forward:/index.html"
  }
}
