
#!/bin/bash
# filepath: /home/zark/Bureau/ITU/Annee-3/Framework/Test/deployer.sh

# ----------- Définition des variables -----------
src="src"
lib="lib"
bin="bin"
src_temp="src_temp"
build="build"
webapp="/home/zark/Documents/apache-tomcat-10.1.28/webapps"   # adapte ce chemin si besoin
name="Test_Framework"

# ----------- Préparation -----------
echo "Préparation des dossiers..."
mkdir -p "$src_temp"
mkdir -p "$build/WEB-INF/classes"
mkdir -p "$build/WEB-INF/lib"

# ----------- Copie des fichiers sources -----------
echo "Copie des fichiers sources..."
find "$src/main/java/" -name "*.java" -exec cp {} "$src_temp" \;

# ----------- Compilation -----------
echo "Compilation des fichiers Java..."
mkdir -p "$bin"
javac -parameters -cp "$lib/*" -g:vars -d "$bin" "$src_temp"/*.java

# ----------- Copie des fichiers compilés et des bibliothèques -----------
echo "Copie des fichiers compilés et des bibliothèques..."
cp -r "$bin/"* "$build/WEB-INF/classes/"
cp -r "$lib/"* "$build/WEB-INF/lib/"
cp src/main/webapp/web.xml "$build/WEB-INF/"
cp src/main/webapp/* "$build/"
if [ -d "src/main/resources" ]; then
    cp -r src/main/resources/* "$build/WEB-INF/classes/"
fi

# ----------- Création du fichier WAR -----------
echo "Création du fichier WAR..."
cd "$build"
jar -cvf "$name.war" .
cd ..

# ----------- Déploiement sur Tomcat -----------
echo "Déploiement sur Tomcat..."
rm -f "$webapp/$name.war" "$webapp/$name.war.deployed"
cp "$build/$name.war" "$webapp/"

# ----------- Nettoyage -----------
echo "Nettoyage..."
rm -f "$build/$name.war"
rm -rf "$build"
rm -rf "$src_temp"

# ----------- Fin -----------
echo "Déploiement terminé avec succès !"
read -p "Appuyez sur Entrée pour quitter..."
