# 183_abschlussprojekt

## Voraussetzungen

- Java Development Kit (JDK) Version 17 oder höher.
- Apache Maven Version 3.8.1 oder höher.

## Abstract

Das Ziel dieses Projekts ist es, verschiedene Aspekte der Softwareentwicklung zu behandeln, einschliesslich
Sicherheitslücken und Implementierung des Loggings. Die Haupt-Sicherheitslücke, die in dem Projekt identifiziert wurde,
besteht darin, dass der MD5-Hash-Algorithmus zur Passwortspeicherung verwendet wird. MD5 gilt aufgrund seiner
Anfälligkeit für vorberechnete Hash-Angriffe wie Rainbow Tables als unsicher. Um die Sicherheit zu verbessern, wird
empfohlen, MD5 durch stärkere Hashing-Algorithmen wie bcrypt oder scrypt zu ersetzen, die speziell für die
Passwortspeicherung entwickelt wurden und zusätzliche Sicherheitsmassnahmen bieten.

Das Logging-Konzept in diesem Projekt dient mehreren Zwecken. Erstens erfasst es relevante Ereignisse und Informationen
während der Laufzeit der Anwendung, um Fehlerbehebung, Fehleranalyse und Anwendungsüberwachung zu unterstützen. Zweitens
sammelt es Metriken und Leistungsdaten zur weiteren Analyse und Optimierung der Anwendung.

## Vulnerability

Die Sicherheitslücke in unserem Projekt besteht darin, dass als Hash Algorithmus
MD5 verwendet wird. MD5 sollte nicht mehr zur Sicherung von Passwörtern verwendet werden, da es für Angreifer relativ
einfach ist, den MD5-Hash eines Passworts zu berechnen, indem sie eine Tabelle von vorausberechneten Hash-Werten (
Rainbow Tables) verwenden. Sobald ein Angreifer den MD5-Hash eines Passworts kennt, kann er diesen mit der Tabelle
abgleichen, um das eigentliche Passwort zu ermitteln. Dies macht es für Angreifer einfacher, Passwörter zu knacken und
unbefugten Zugriff auf Benutzerkonten zu erlangen. Aus diesem Grund werden heute sicherere Hashing-Algorithmen wie
bcrypt oder scrypt empfohlen, die speziell für die Speicherung von Passwörtern entwickelt wurden und zusätzliche
Sicherheitsmechanismen enthalten, um Angriffe zu erschweren.

## Logging Konzept

1. **Zweck des Loggings**:

   Erfassen von relevanten Ereignissen und Informationen während der Laufzeit der Anwendung.
   Unterstützung bei der Fehlerbehebung, Fehleranalyse und Überwachung der Anwendung.
   Erfassen von Metriken und Leistungsdaten für die Analyse und Optimierung der Anwendung.

2. **Log-Nachrichtenstruktur**:

   Jede Log-Nachricht sollte aus folgenden Elementen bestehen:
    - Zeitstempel: Datum und Uhrzeit, um das Ereignis genau zu dokumentieren.
    - Log-Level: Eine Klassifizierung, um die Bedeutung der Log-Nachricht anzuzeigen (z. B. INFO, WARN, ERROR).
    - Quellmodul: Der Name des Moduls oder der Komponente, aus der die Log-Nachricht stammt.
    - Nachricht: Der eigentliche Inhalt der Log-Nachricht, der das Ereignis oder die Information beschreibt.

3. **Log-Level**:

    - INFO: Allgemeine Informationen über den Programmablauf oder Statusmeldungen. WARN: Warnungen vor potenziellen
      Problemen oder fehlerhaften Zuständen, die aber nicht kritisch sind.
    - ERROR: Fehler, die das ordnungsgemässe Funktionieren der Anwendung beeinträchtigen.
    - DEBUG: Detaillierte Debugging-Informationen, die normalerweise nur in Entwicklungsumgebungen aktiviert sind.

4. **Log-Ausgabe**:

   Die Logs werden in der Konsole ausgegeben.
   Falls die Logs gespeichert werden sollten, kann zum Beispiel eine Software wie logstash
   verwendet werden.

