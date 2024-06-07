all:
	clear
	javac src/Main.java -d ~/Documents/Github/EscoopInterpreter
compile:
	clear
	javac src/Main.java -d build
	export PATH=/Library/Java/JavaVirtualMachines/graalvm-jdk-22.0.1+8.1/Contents/Home/bin:$PATH
	native-image Main -cp ~/Documents/Github/EscoopInterpreter/build escoop
	chmod +x escoop
	cp escoop /usr/local/bin