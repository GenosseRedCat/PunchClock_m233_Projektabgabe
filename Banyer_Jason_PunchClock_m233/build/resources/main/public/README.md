<h2>PunchClock Anleitung</h2>

<h3>Hinweis</h3>
Um dieses Programm zum laufen zu bringen, benötigen Sie Intellij.<br>
Es wird empfohlen minimum die version `JRE: Java 11.02 SDK ` installiert zu haben.<br><br>
<br>
<h2>Installation</h2>
Importieren Sie dieses Projekt in Intellij und verwenden Sie Gradle.<br>
Nachdem das Projekt geöffnet wurde, müssen Sie unten rechts auf "import" klicken. <br>
Dies sollte bei einer kleinen Mitteilungsbox angezeigt werden.<br>

Als Starter-Klasse verwenden Sie ``ch.zli.m223.punchclock.PunchclockApplication``.<br>
Danach starten Sie die Klasse ```Punchclock.java```.<br>

Öffnen Sie im Browser nun ```localhost:8080```. <br>
Falls hier nichts erscheinen sollte, können Sie folgende ausprobieren: <br>
```8080, 8081, 8180```<br>
Falls keiner dieser funktioniert, schauen Sie im Intellij Terminal nach folgender Mitteilung:<br>
``2020-11-15 19:39:11.981  INFO 18292 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s):``
<br>
Dort finden Sie dann auch den aktuellen Port, auf dem diese Applikation gehostet wird.

<br>
<h2>Bedienung</h2>

Zu Beginn müssen Sie sich anmelden. Dies können Sie mit folgenden Konten:
<br>
<hr>
<b>Administration</b> <br><br>
Benutzername: Linda<br>
Passwort: password123<br>
<hr>
<b>Benutzer</b> <br><br>
Benutzername: jason<br>
Passwort: jason<br>
<br>

Benutzername: annasmith<br>
Passwort: password<br>
<hr>
Falls das Anmeldungsfenster nochmals kommt, sollte man einfach auf "cancel" drücken.<br>
<br>
Um die verschiedenen Benutzer zu sehen gehen Sie auf ``localhost:[PORT]/benutzer/[BENUTZER ID]``
<br> Setzen Sie selbst den Port und die gewünschte ID ein.
<br> Es wurden nicht mehr als 3 Benutzer registriert. (ID: 1,2,3)
<br>

Um das Adminpanel aufzurufen gehen Sie auf ``localhost:[PORT]/admin.html``
<br>
Hier ist eigentlich alles selbsterklärend.

