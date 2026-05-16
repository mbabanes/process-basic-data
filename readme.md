# Endpointy:

- `POST http://localhost:8080/company-data-process-start` (klasa `CompanyDataProcessController`)

```json
{
    "processId" : "ihuiujhwq13-1ascasjjas-123412-adasads"
}
```

Do tego endpointu uderza camunda/eximee, ten endpoint tworzy nowy process i potem można wejść poniższym adresem (przez przeglądarkę)

- `GET http://localhost:8080/company-data/{processId}`(klasa `CompanyDataFormController`)

Po kliknieciu _Wyślij_, do `process-orchestrator` wysyłany jest request, z tym `processId` że się udało. Klasa `CompanyDataController`.
