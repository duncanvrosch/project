Process Book
===================

## Duncan Vrösch (11211490) ##

### Woensdag 09-01-2019 ###
Vandaag ben ik begonnen met het opstarten van het project in Android Studio en het plaatsen van het project op GitHub. Na wat push- en commitproblemen heb ik het beginscherm (inlogscherm) geïmplementeerd waardoor het mogelijk wordt om een werknemer te onderscheiden van de werkgever. Dit kan gebeuren door de inloggegevens die hardcoded in de code zijn gezet. Er kan ook maar maximaal drie keer geprobeerd worden in te loggen, anders wordt de inlogknop buiten gebruik gesteld.

Nog niet alle activiteiten zijn aangemaakt. Dit gebeurt morgen waarna alle activiteiten aan elkaar worden gelinkt zodat het prototype van de app gereed is.


### Donderdag 10-01-2019 ###
Vandaag heb ik alle activiteiten aangemaakt en de linkjes gelegd tussen deze activiteiten. De navigatie klopt dus nu en daarmee is mijn prototype afgerond. Dit komt erop neer dat er twee verschillende platformen zijn voor aan de ene kant de werkgever, en aan de andere kant de werknemer. Deze keuze heb ik gemaakt zodat het makkelijk wordt om verschillende bevoegdheden toe te kennen aan de twee verschillende platformen. 

De platformen zijn daarnaast gescheiden door de inlogpagina. Er kan ingelogd worden door de werknemer met gebruikersnaam en wachtwoord 'Werknemer', en er kan ingelogd worden door de werkgever met gebruikersnaam en wachtwoord 'Werkgever'. 

Ook heb ik vandaag een huisstijl ontworpen voor mijn app met keuze voor kleuren en het ontwerp van het logo. De app icon is al aangepast op het logo en ziet er als volgt uit:

<img src="https://github.com/duncanvrosch/project/blob/master/doc/Logo%20WorkToDo.jpg" width="20%" height="20%"/>

<img src="https://github.com/duncanvrosch/project/blob/master/doc/Screenshot_20190110-160333.png" width="20%" height="20%"/>

De volgende stap is het laten functioneren van de lijsten en de databases zodat er items in de to-do listen en het logboek geplaatst kunnen worden.


### Vrijdag 11-01-2019 ###
Vandaag heb ik niet de volgende stap gevolgd die ik gisteren had gepland om vandaag te doen: het laten functioneren van de lijsten en de databases zodat er items in de to-do listen en het logboek geplaatst kunnen worden. In plaats daarvan heb ik vandaag de API vanuit OpenWeatherMap werkend gemaakt waardoor het voor de werknemer duidelijk is wat voor een weer het is. Echter, het is erg minimaal en de graden celsius kloppen nog niet helemaal. Dus ondanks dat de verbinding met de API werkt, is de data die wordt ingeladen nog niet bruikbaar voor de gebruiker. Hier zal ik maandag aan verder werken zodat ik hier na maandag geen omkijken meer naar heb. 

Vanaf dinsdag wil ik aan de slag met de databases voor de to-do list en het logboek.


### Maandag 14-01-2019 ###
Vandaag vond de eerste bijeenkomst plaats van de mentorgroep. Hierin heb ik aangegeven wat mijn idee is voor de app, hoe ver ik ben en hoe ik denk enkele zaken te gaan implementeren. Onder andere kwam in de bespreking het implementeren van de database voor de to-do list en het logboek voorbij. Aangezien ik nog niet wist welke database ik hiervoor ging gebruiken, heb ik hulp gevraagd. Aangeraden is om de database te implementeren door middel van de rester database die ik al eerder heb gebruikt in een andere app. 

Het is me nog niet gelukt om zoals gepland het weerbericht af te maken. Het werkt, maar graag wil ik er nog een bijbehorend visueel icoontje bij maken. Hiermee ga ik direct morgenvroeg aan de slag.


### Dinsdag 15-01-2019 ###
Vandaag ben ik begonnen met het implementeren van de database voor het gebruik van het logboek en de to-do list. Hiervoor heb ik gebruik gemaakt van de Rester database en ben ik teruggevallen op de instructies die ook golden voor het implementeren van de Trivia app. De database is werkend voor het logboek waardoor het toevoegen van items aan het logboek nu mogelijk is geworden. Daarentegen kan nog niets verwijderd worden uit de database. Dit zal morgen geïmplementeerd worden waardoor het gebruik van het logboek voor zowel de werknemer als de werkgever gereed is.

Zoals eerder wel gepland, ben ik vandaag niet toegekomen aan het afmaken van het weerbericht. Hier wil ik nog graag een bijbehorend visueel icoontje bij maken. Echter, dit is optioneel en heeft geen prioriteit. Ik wil eerst de database voor zowel het logboek als de to-do list af hebben.


### Woensdag 16-01-2019 ###
Vandaag heb ik het logboek ook voor de werkgever geïmplementeerd. In het overzicht staat nu ook de prioriteit visueel getoond door middel van een rood vlaggetje, oranje vlaggetje of groen vlaggetje afhankelijk van de mate van prioriteit. Daarbij is vandaag de DetailActivity geïmplementeerd voor het logboek waardoor elk item uitgebreid kan worden gezien. 

Enkele problemen die ik vandaag ben tegengekomen houden verband met dezelfde database. Het implementeren van de delete funcite lijkt moeilijker dan gedacht. Hiervoor moet ik hulp vragen. Daarbij leek de Rester database ondanks de update geen zaken blijvend op te slaan. Gelukkig is dit opgelost na het herinstalleren van de Rester database in de CS50 IDE. 

Morgen zal ik de to-do list implementeren zodat de alpha versie van de app morgen werkend is.


### Donderdag 17-01-2019 ###
Zoals gepland heb ik vandaag de to-do list geïmplementeerd. De werkgever kan nu taken aanmaken en zien, de werknemer kan ze enkel en alleen zien. De volgende stap is om ervoor te zorgen dat de werknemer taken kan afvinken die gedaan zijn door middel van het aanpassen van de status van een item. Het veranderen van de status van een item zal gedaan worden via een PUT-request. 

Zodra dit wordt gedaan, wordt het desbetreffende item als gedaan gemarkeerd in de to-do list en wordt deze toegevoegd aan een aparte lijst die alleen de werkgever kan zien. De werkgever kan daardoor alle taken die gedaan zijn in een overzicht zien en deze per item ook verwijderen uit zowel dat overzicht als de to-do list.

Zodra dit geïmplementeerd is, is het gebruik van de app gereed. Mocht dit voortijdig gereed zijn, dan kunnen er optionele items worden geïmplementeerd voor de app.


### Vrijdag 18-01-2019 ###
Ik was ziek, maar heb een begin gemaakt aan de delete functie. Deze werkt als ik een random id nummer invul, maar het zoeken van de id lukt helaas nog niet.


### Maandag 21-01-2019 ###
Vandaag heb ik mijn delete functie afgemaakt en fuctioneel gemaakt. Hierdoor kunnen zowel de werkgever als de werknemer items uit de logger verwijderen. Daarbij kan de werkgever items uit de to-do list verwijderen. Dit betekent dat de basale en simpele functie van de app vandaag compleet gemaakt is. Morgen zal ik een lijst maken waardoor de werkgever kan zien welke taken zijn afgemaakt in de to-do list.


### Dinsdag 22-01-2019 ###
Vandaag heb ik de 'done-list' geïmplementeerd waardoor werknemers een bepaalde taak kunnen afvinken met hun naam. Vervolgens wordt de taak uit de to-do list verwijderd en wordt deze weergegeven in de 'done-list' die alleen te zien is door de werkgever. Vervolgens kan de werkgever de taak ook uit de done-list verwijderen.

Door deze implementatie is de app nu klaar voor gebruik. Volgende stap is de uitbreiding van het weerbericht zodat deze zich aanpast aan de locatie waar de werknemer zich op dat moment bevindt.



### Woensdag 23-01-2019 ###
Vandaag heb ik nog een nieuwe lijst ontwikkeld waardoor het voor de werkgever mogelijk wordt om verschillende accounts aan te maken en deze in de accountlijst te stoppen. Momenteel kon er namelijk alleen ingelogd worden met de inloggegevens die hardcoded werden aangebracht in het codebestand. Door deze nieuwe aanmaakfunctie van accounts wordt het mogelijk om voor nieuwe werknemers een account aan te maken, maar ook oude te verwijderen. De volgende stap is het koppelen van het inlogscherm aan deze lijst zodat het werkelijk functioneert.

Deze keuze voor dynamische inloggegevens is ook gemaakt met het oog op de toekomst: bij volgende produceerstappen in de app kan het makkelijker zijn om persoonlijke accounts te maken met unieke content.


### Donderdag 24-01-2019 ###
Vandaag heb ik de accountlijst gekoppeld aan het inlogscherm. Hierdoor is het mogelijk in te loggen met je eigen verkregen account, gemaakt door de werkgever. 


### Vrijdag 25-01-2019 ###
Vandaag heb ik mijn repository netjes gemaakt zodat alles wat met de app te maken heeft zich nu in een map 'WorkToDo' bevindt. Deze keuze is gemaakt zodat de repository er op het eerste oog geordend uitziet met een goed onderscheiden mappenlijst. Daarnaast heb ik op iedere activiteit een 'Back to...' button gemaakt zodat dat ook consistent netjes uitziet.


### Maandag 28-01-2019 ###
Vandaag heb ik een begin gemaakt met de uitbreiding van het weerbericht waardoor het niet alleen mogelijk is het actuele weerbeeld te zien, maar ook die van over drie uur. Helaas heb ik dit nog niet optimaal werkend waardoor ik hier morgen aan verder moet gaan. Hopelijk krijg ik dit laatste onderdeel werkend.

### Dinsdag 29-01-2019 ###
Vandaag...
