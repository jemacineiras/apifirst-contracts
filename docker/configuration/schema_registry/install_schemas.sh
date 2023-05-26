#!/bin/sh

curl --location --request POST 'http://localhost:8081/subjects/net.coru.kloadgen.demo.BankMovementEvent/versions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "schema": "{\"type\":\"record\",\"name\":\"BankMovementEvent\",\"namespace\":\"net.coru.kloadgen.bankserver\",\"doc\":\"Container for the banking movement.\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"doc\":\"Movement Id\"},{\"name\":\"accountNumber\",\"type\":\"string\",\"doc\":\"Movement account Number\"},{\"name\":\"movement\",\"type\":{\"type\":\"enum\",\"name\":\"MovementType\",\"symbols\":[\"DEPOSIT\",\"WITHDRAW\"],\"doc\":\"Movement Type\"}},{\"name\":\"amount\",\"type\":\"float\",\"doc\":\"Movement amount\"},{\"name\":\"movementDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Movement Date Time when was produced\"},{\"name\":\"appliedDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Movement Date Time when was applied by the system\"}]}",
    "schemaType": "AVRO"
}'

curl --location --request POST 'http://localhost:8081/subjects/net.coru.kloadgen.demo.BankAccountEvent/versions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "schema": "{\"type\":\"record\",\"name\":\"BankAccountEvent\",\"namespace\":\"net.coru.kloadgen.bankserver\",\"doc\":\"Container for the banking movement.\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"doc\":\"Account Id\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"Account name\"},{\"name\":\"accountNumber\",\"type\":\"string\",\"doc\":\"Movement account Number\"},{\"name\":\"amount\",\"type\":\"float\",\"doc\":\"Movement amount\"},{\"name\":\"lastUpdateDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Last Account Update Date Time\"},{\"name\":\"creationDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Account Creation Date Time\"}]}",
    "schemaType": "AVRO"
}'

curl --location --request POST 'http://localhost:8081/subjects/net.coru.kloadgen.bank.account.refresh-value/versions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "schema": "{\"type\":\"record\",\"name\":\"BankAccountEvent\",\"namespace\":\"net.coru.kloadgen.bankserver\",\"doc\":\"Container for the banking movement.\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"doc\":\"Account Id\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"Account name\"},{\"name\":\"accountNumber\",\"type\":\"string\",\"doc\":\"Movement account Number\"},{\"name\":\"amount\",\"type\":\"float\",\"doc\":\"Movement amount\"},{\"name\":\"lastUpdateDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Last Account Update Date Time\"},{\"name\":\"creationDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Account Creation Date Time\"}]}",
    "schemaType": "AVRO"
}'

curl --location --request POST 'http://localhost:8081/subjects/net.coru.kloadgen.bank.account.updated-value/versions' \
--header 'Content-Type: application/json' \
--data-raw '{
    "schema": "{\"type\":\"record\",\"name\":\"BankAccountEvent\",\"namespace\":\"net.coru.kloadgen.bankserver\",\"doc\":\"Container for the banking movement.\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"doc\":\"Account Id\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"Account name\"},{\"name\":\"accountNumber\",\"type\":\"string\",\"doc\":\"Movement account Number\"},{\"name\":\"amount\",\"type\":\"float\",\"doc\":\"Movement amount\"},{\"name\":\"lastUpdateDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Last Account Update Date Time\"},{\"name\":\"creationDate\",\"type\":{\"type\":\"long\",\"logicalType\":\"local-timestamp-millis\"},\"doc\":\"Account Creation Date Time\"}]}",
    "schemaType": "AVRO"
}'