WorkToDo!
===================

## Duncan Vrösch (11211490) ##

## Final Report: Minor Programmeren, Universiteit van Amsterdam (2018 / 2019) ##

<img src="/doc/Screenshot_20190130-115600.png" width="170"> 

Deze app maakt online communicatie tussen werknemers en werkgevers mogelijk door middel van het uitwisselen van gebeurtenissen in een logboek en een to-do list.

### Overview activities ###

### Classes ###
De class Helper wordt gebruikt om de informatie van een to-do item, done item, of log item op te slaan. Op deze manier wordt het mogelijk om deze informatie ook weer weer te geven in de lijst van bijvoorbeeld het logboek. Daarnaast wordt deze class aangeroepen om ook informatie te kunnen plaatsen in de DetailActivity's. Kortom, voor iedere activiteit worden de relevante attributes gepakt en getoond door middel van de Helper class en de bijbehorende adapter. In onderstaande tabel kan worden bekeken welke zaken er worden opgeslagen in de Helper class.

<table>
<tr><th>Helper</th>
<tr><td>

|attribute| type |
|--|--|
| title | string |
| name | string | 
| description | string |
| priority | string |
| timestamp | string |

</td><td>



