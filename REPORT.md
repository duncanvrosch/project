WorkToDo!
===================

## Duncan Vrösch (11211490) ##

## Final Report: Minor Programmeren, Universiteit van Amsterdam (2018 / 2019) ##

<img src="/doc/Screenshot_20190130-115600.png" width="170"> 

Deze app maakt online communicatie tussen werknemers en werkgevers mogelijk door middel van het uitwisselen van gebeurtenissen in een logboek en een to-do list.

### Overview activities ###

### Classes ###
De class Helper wordt gebruikt om de informatie van een to-do item, done item, of log item op te slaan. Op deze manier wordt het mogelijk om deze informatie ook weer weer te geven in de lijst van bijvoorbeeld het logboek. Daarnaast wordt deze class aangeroepen om ook informatie te kunnen plaatsen in de DetailActivity's. Kortom, voor iedere activiteit worden de relevante attributes gepakt en getoond door middel van de Helper class en de bijbehorende adapter. In onderstaande tabel kan worden bekeken welke zaken er worden opgeslagen in de Helper class.

Hiernaast bestaat er een class Account. Deze wordt gebruikt om de informatie van een account op te slaan. Dit betreft de 'username' en 'password' van een gebruiker. Op deze manier wordt het mogelijk om deze informatie ook weer weer te geven in accountlijst die beschikbaar is voor de werkgever. In onderstaande tabel kan ook worden bekeken welke zaken er worden opgeslagen in de Account class.

<table>
<tr><th> Helper </th><th> Account </th></tr>
<tr><td>

|attribute| type |
|--|--|
| title | string|
| name | string | 
| description | string |
| priority | string |
| timestamp | string |

</td><td>

|attribute| type |
|--|--|
|movieId| string|
| username | string | 
| password | string |

</td></tr> </table>


### Adapters ###
Het project heeft vier adapters: DoneAdapter, ToDoAdapter, LoggerAdapter en AccountAdapter,. De eerste drie adapters zorgen ervoor dat de gebruiker de naam, beschrijving, tijd en datum, naam en prioriteit te zien krijgen in de lijsten van het logboek, to-do list en de done-list, en de detailactivity's ervan. De AccountAdapter werkt hetzelfde, alleen zet deze alleen username en password om zodat het visueel zichtbaar wordt voor de werkgever in de AccountListWGActivity en de AccountDetailWGActivity.


### Database ###
Om items blijvend te kunnen opslaan in een database, wordt gebruik gemaakt van de Rester Database: https://github.com/stgm/rester. In de database worden verschillende zaken opgeslagen en bestaan er vier entry's: de to-do list, een logboek, een done-list en een accountlist. Hieronder staat alles keurig en overzichtelijk op een rijtje van wat de entry's bevatten.

<table>
<tr><th> To-Do List </th><th> Logger </th></tr>
<tr><td>

|key| value |
|--|--|
| id | int|
| name | string | 
| description | string |
| title | string |
| priority | string |
| timestamp | string |

</td><td>

|key| value |
|--|--|
| id | int|
| name | string | 
| description | string |
| title | string |
| priority | string |
| timestamp | string |

</td></tr> </table>

<table>
<tr><th> AccountList </th><th> DoneList </th></tr>
<tr><td>

|key| value |
|--|--|
| id | int|
| password | string | 
| username | string |

</td><td>

|key| value |
|--|--|
| id | int|
| name | string | 
| description | string |
| title | string |
| priority | string |
| timestamp | string |

</td></tr> </table>
