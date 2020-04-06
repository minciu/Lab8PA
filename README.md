# Lab8PA

Am creat in NetBeans baza de date, user-ul si parola folosind GlassFish(derby)

Folsindu-ma de resursele din NetBeans am creat si tabelele( dar am scris codul corespunzator si in main) si am adugat in librarii Java DB Driver.
Nota: nu am facut proiectul in Maven deoarece se pare ca nu pot adauga librarii(sau cel mai probabil nu stiu eu cum)

Conexiunea cu baza de date se gestioneaza in main. Pentru a ne conecta la baza de date ne trebuie: Connection, Statement, ResultSet. Sunt setate ca null intrucat le vom schimba mai tarziu.

Obiectul conex ne da posibilitatea de a ne conecta la baza de date, si apoi creaza un Statement stat al bazei de date.

Obiectul stat ne da posibilitatea de a executa queryes in baza de date si de a stoca  ResultSet res.

Obiectul res va reprezenta data pe care o avem.

conex primeste adresa bazei de date(aici ar putea sa intampinati probleme), user-ul si parola(specificate ca in enunt).

Clasele album si artist sunt simple: au valori si cate un constructor pentru a sprijini clasele AlbumController respectiv ArtistController.

Metodele create stocheaza in baza de date cu parametrii potriviti artistii si albumele lor.

Metodele find cauta si gasesc cu ajutorul listelor albume si artisti, instantiaza cate un obiect din clasa sa, care va concordacu  randul corespunzator(sau nu).

Mai departe in Main cream trupele si albumele mele preferate si le afisam.
