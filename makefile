run: jar

jar: classes
	jar cfm Main.jar manifest.mf -C Build/ .


classes: dir
	javac -sourcepath / -d Build/ Parte2/src/Main.java

dir:
	if [ ! -d Build/ ]; then mkdir -p Build/; fi

clean:
	rm -rf Build
	rm Main.jar