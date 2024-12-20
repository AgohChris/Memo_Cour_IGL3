import re

r = re.compile(r"^([0-9]+;[^;]*;PAUL;[^;]*;)PLOU")
f = open("Awk/gen1551.csv",'r', encoding='ISO-8859-1')

o = open("tmp.csv","w")
for ligne in f:
    o.write(r.sub(r"\1LOC",ligne))
f.close()
o.close()