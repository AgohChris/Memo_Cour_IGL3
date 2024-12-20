import re
r = re.compile(r"^([0-9]+);[^;]*;PAUL;")
f = open("gen1551.csv",'r', encoding='ISO-8859-1')



for ligne in f:
    for m in r.finditer(ligne):
        print(f"ligne {m.group(1)} Contient PAUL")
f.close()