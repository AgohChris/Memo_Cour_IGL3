import re

r = re.compile(r"^([0-9]+);[^;]*;PAUL;")

with open("gen1551.csv", 'r', encoding='ISO-8859-1') as f:

    for ligne in f:
        for m in r.finditer(ligne):
                print(f"ligne {m.group(1)} Contient PAUL")