# 🚀 Быстрый старт
### Клонируйет и перейдите репозиторий:
```shell
  git clone https://github.com/Teamofeyy/xml-service.git
  cd xml-service
```

### Запустите приложение:
```shell
  chmod +x run.sh 
  ./run.sh
```
# Просмотр результатов импорта
```shell
docker exec -it db psql -U postgres -c "
SELECT s.id, s.first_name, s.second_name, sk.name as skill_name, sk.hard, sk.soft
FROM students s
JOIN student_skills ss ON s.id = ss.student_id
JOIN skills sk ON ss.skill_id = sk.id
ORDER BY s.id;
"
```
### Пример вывода:
```shell
 id | first_name | second_name |    skill_name    | hard | soft 
----+------------+-------------+------------------+------+------
  1 | Viacheslav | Ivanov      | Java             | t    | 
  1 | Viacheslav | Ivanov      | Kotlin           | t    | 
  1 | Viacheslav | Ivanov      | DevSecOps        | t    | 
  1 | Viacheslav | Ivanov      | English language |      | t
  2 | Peter      | Sergeev     | PHP              | t    | 
  2 | Peter      | Sergeev     | Kotlin           | t    | 
  2 | Peter      | Sergeev     | Backend          | t    | 
  3 | Maria      | Gavrilovich | Project manager  | t    | 
  3 | Maria      | Gavrilovich | Kotlin           | t    | 
  3 | Maria      | Gavrilovich | Speaking         |      | t
(10 rows)
```
