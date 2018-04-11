$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("persons.feature");
formatter.feature({
  "line": 1,
  "name": "CRUD Person dan Phone",
  "description": "",
  "id": "crud-person-dan-phone",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "Penambahan Data Person",
  "description": "",
  "id": "crud-person-dan-phone;penambahan-data-person",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "Ambil jumlah total record saat ini",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "Ditambahkan record baru firstName:\u003cfirst\u003e, lastName:\u003clast\u003e, umur:\u003cage\u003e, hp: 987854626272, no ktp: 88888888888",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Jumlah total data terakhir adalah record awal + 1",
  "keyword": "Then "
});
formatter.examples({
  "line": 7,
  "name": "",
  "description": "",
  "id": "crud-person-dan-phone;penambahan-data-person;",
  "rows": [
    {
      "cells": [
        "first",
        "last",
        "age"
      ],
      "line": 8,
      "id": "crud-person-dan-phone;penambahan-data-person;;1"
    },
    {
      "cells": [
        "ani",
        "lala",
        "19"
      ],
      "line": 9,
      "id": "crud-person-dan-phone;penambahan-data-person;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 9,
  "name": "Penambahan Data Person",
  "description": "",
  "id": "crud-person-dan-phone;penambahan-data-person;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "Ambil jumlah total record saat ini",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "Ditambahkan record baru firstName:ani, lastName:lala, umur:19, hp: 987854626272, no ktp: 88888888888",
  "matchedColumns": [
    0,
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Jumlah total data terakhir adalah record awal + 1",
  "keyword": "Then "
});
formatter.match({
  "location": "People.given()"
});
formatter.result({
  "duration": 1482766000,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 48
    }
  ],
  "location": "People.then(int)"
});
formatter.result({
  "status": "skipped"
});
});