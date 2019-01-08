Design Document
===================

## Duncan Vrösch (11211490) ##

### Sketch ###
<img src="https://github.com/duncanvrosch/project/blob/master/doc/DesignDocument.jpg" width="100%" height="100%"/>

### Diagram of functions ###

### Data Sources ###
Voor de WorkToDo app die ik ga ontwikkelen maak ik gebruik van een API die een weerbericht doorgeeft voor de huidige locatie. Dit doe ik via de site van OpenWeatherMap die een online API aanbieden waarbij dit mogelijk is (https://openweathermap.org/forecast5). Door deze API te gebruiken, wordt het weerbericht weergegeven op de homepage van de app. Door gebruik te maken van een JSON constructie, wordt de code die de site levert omgezet in een bruikbaar weerbericht voor de user interface. 

### Database tables ###
Ik ga gebruik maken van twee databases om de informatie van de to-do list en het logboek te onthouden:

Online database lijst voor to-do list: https://ide50-duncanvrosch.cs50.io:8080/todolist

Online database lijst voor logboek: https://ide50-duncanvrosch.cs50.io:8080/logboek

