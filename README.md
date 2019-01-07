App Proposal
===================

## Duncan Vrösch (11211490) ##

### Probleem ###
Iedereen werkt en wie werkt, verricht taken. Toch is het niet altijd duidelijk wat je precies op een werkdag moet doen en welke verrichtingen je moet doen om je taken voor het einde van de dag af te maken. Daarbij gebeuren er soms speciale zaken op het werk die je graag aan je collega's en baas wil melden zoals gevaarlijke situaties of defecten binnen een bedrijf. 

Kortom, als bijvoorbeeld supermarktmedewerker wil je alle taken voor een werkdag op een rijtje hebben zodat je weet wat je moet doen. Als je een taak hebt uitgevoerd wil je deze ook kunnen afvinken met een eventuele opmerking erbij waarna een manager of baas deze handeling kan goedkeuren. Daarbij wil je gevaarlijke situaties, ongevallen of defecten kunnen melden via een logboek zodat alle andere collega's, ook van andere diensten, deze kunnen terugvinden op elk gewenst moment op elke gewenste plaats.

### Oplossing ###
Als oplossing voor dit probleem wil ik graag een app ontwikkelen die de mogelijkheid geeft voor een werkgever om transparant en duidelijk to-do listen samen te stellen, deze goed of af te keuren en een logboek te onderhouden als bepaalde zaken die gemeld staan door werknemers inmiddels zijn opgelost waarbij de werknemer dit alles op de app te zien krijgt.

<img src="https://github.com/duncanvrosch/project/blob/master/doc/AppProposal.jpg" width="100%" height="100%"/>

### Features ###
MVP:
- Een gebruiker kan inloggen via een inlogpagina zodat deze herkend wordt als werknemer of werkgever en op basis daarvan een verschillende interface te zien krijgt.
- Een werkgever kan to-do listen samenstellen met een titel en de daarbijbehorende beschrijving. 
- Een werkgever kan zaken toevoegen aan het logboek maar ook uit het logboek verwijderen zodra deze hersteld zijn.
- Een werkgever kan afgeronde taken van werknemers goed-, dan wel afkeuren.
- Een werknemer kan zijn to-do list zien.
- Een werknemer kan taken als gedaan markeren.
- Een werknemer kan zaken aan het logboek toevoegen met een titel of beschrijving.

Optioneel:
- De hoogte van urgentie is door middel van icoontjes aan te passen.
- Een werknemer kan zijn to-do list op basis van urgentie indelen.
- Een werknemer kan een taak afronden met een optie om een beschrijving of een foto toe te voegen.
- Een werknemer kan foto's aan het logboek toevoegen. De mate van urgentie kan hierbij bepaald worden.

### Prerequisites ###
##### External components: #####
- Online API lijst voor to-do list: https://ide50-duncanvrosch.cs50.io:8080/todolist

- Online API lijst voor logboek: https://ide50-duncanvrosch.cs50.io:8080/logboek

##### Similar apps: #####
Er bestaan enkele soortgelijke apps waarbij er lijsten worden bijgehouden van ingevoerde items: denk aan notitie-apps. Vaak zijn deze overzichtelijk geordend in lijsten die zijn ingedeeld op tijd. De functionaliteit qua toevoegen en verwijderen van items van een to-do list of logboek, kan ik ook gebruiken in mijn eigen app waar dit noodzakelijk is. Echter, het is moeilijker aangezien huidige apps nauwelijks tot niet de mogelijkheid geven om een prioriteit of label toe te voegen aan een notitie of item. Dit zal ik onder andere zelf moeten implementeren.

##### Hardest parts: #####
Tijdens het maken van de app kan ik problemen krijgen met het maken van twee verschillende soorten interfaces. Die van de werkgever die meer bevoegdheden heeft, en die van de werknemer, die er juist minder heeft. Mocht ik hiermee te veel vertraging oplopen, kies ik ervoor om me te beperken tot een uitgebreide versie die voor de werknemer / werkgever hetzelfde is.

