all:
	cd ~/Documents/Github/EscoopInterpreter
	g++ src/main.cpp
	mv a.out escoop
	chmod +x escoop
	cp escoop /usr/local/bin