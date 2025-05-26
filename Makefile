JC = javac
JRE = java
PROGRAM = Main
SOURCE = Main.java

build:
	$(JC) $(SOURCE)

run:
	$(JRE) $(PROGRAM)

clean:
	rm -rf *.class