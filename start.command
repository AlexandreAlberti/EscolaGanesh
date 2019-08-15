#!/bin/bash

echo "Iniciant el servidor";
cd /Users/shankara/EscolaGaneshPrograma/Servidor;
mvn spring-boot:run &

echo "Iniciant el web";
cd /Users/shankara/EscolaGaneshPrograma/AngularFrontend;
ng serve
