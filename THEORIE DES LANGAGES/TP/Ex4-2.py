import re

compteur=0
r = re.compile(r"^([0-9]+);ABALAIN;")
f = open("Awk/gen1551.csv",'r', encoding='ISO-8859-1')
for ligne in f:
    if r.findall(ligne):
        compteur=compteur+1
        print(f"ligne {compteur}")
        print(ligne)
f.close()