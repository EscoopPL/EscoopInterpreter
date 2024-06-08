all:
	clear
	bison src/escoop.y
	flex src/escoop.l
	gcc escoop.tab.c
	mv a.out /usr/local/bin/escoop