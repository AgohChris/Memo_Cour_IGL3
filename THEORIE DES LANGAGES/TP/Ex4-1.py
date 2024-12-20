import re

def traiterdate(entree):
    return entree.group(1)+"/"+str(int(entree.group(2))+10)+";PLOU"


faclité =  r"^([0-9]+;[^;]*;PAUL;[0-9][0-9]/[0-9][0-9])/([0-9]{4});PLOU"
r = re.compile(faclité)
f = open("Awk/gen1551.csv",'r', encoding="ISO-8859-1")
o = open("tmp","w")
for ligne in f:
    o.write(r.sub(traiterdate,ligne))
f.close()
o.close()