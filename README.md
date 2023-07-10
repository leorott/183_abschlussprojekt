# 183_abschlussprojekt

## Voraussetzungen

- Java Development Kit (JDK) Version 17 oder höher.
- Apache Maven Version 3.8.1 oder höher.

## Abstract


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
