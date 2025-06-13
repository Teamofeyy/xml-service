#!/bin/bash

docker pull teamofey/xml-service:1.0.0
docker pull postgres:12

docker-compose up -d

echo "Ожидаем запуска сервисов (20 секунд)..."
sleep 20

echo "Проверяем работу сервисов:"
docker ps --format "table {{.Names}}\t{{.Status}}\t{{.Ports}}"

echo -e "\nПриложение доступно по адресу:"
echo "http://localhost:8080"
