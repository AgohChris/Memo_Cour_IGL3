import re

compteur=0
total=0.
faclt = r"^[0-9]+;[^;]*;[^;]*;([0-9][0-9])/([0-9][0-9])/([0-9]{4});[^;]*;([0-9][0-9])/\ ([0-9][0-9])/([0-9]{4})"

r = re.compile(faclt)
f = open("Awk/gen1551.csv",'r', encoding="ISO-8859-1")
for ligne in f:
    for m in r.finditer(ligne):
        datenaissance=int(m.group(3))+((int(m.group(2))-1)/12)+((int(m.group(1))-1)/360)
        datemariage=int(m.group(6))+((int(m.group(5))-1)/12)+((int(m.group(4))-1)/360)
        total = total + datemariage - datenaissance
        compteur = compteur+1
f.close()
print(total/compteur)