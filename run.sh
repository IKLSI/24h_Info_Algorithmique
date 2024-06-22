#!/bin/sh

BIN_DIR="bin"
NIVEAU_DIR="niveau"

# Demande à l'utilisateur quel programme il souhaite lancer

echo "Quel programme souhaitez-vous lancer ? (1, 2 ou 3)"

while true; do
	read PROGRAMME

	case $PROGRAMME in
		1)
			CLASS_TO_RUN="PB1"
			break
			;;
		2)
			CLASS_TO_RUN="PB2"
			break
			;;
		3)
			CLASS_TO_RUN="PB3"
			break
			;;
		*)
			echo "Choix invalide. Veuillez entrer 1, 2 ou 3."
			;;
	esac
done

if [ ! -d "$BIN_DIR" ]; then
	mkdir $BIN_DIR
fi

rm -rf $BIN_DIR/*

# Trouve tous les fichiers .java dans le répertoire courant et le dossier niveau

JAVA_FILES=$(find . $NIVEAU_DIR -maxdepth 1 -name "*.java")

javac -d $BIN_DIR $JAVA_FILES

if [ $? -eq 0 ]; then
	echo "Compilation réussie."
	java -cp $BIN_DIR $CLASS_TO_RUN
else
	echo "Erreur de compilation"
fi