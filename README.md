La compulsory am adaugat clasa singleton Database care gestioneaza conexiunea
(saptamana trecuta conexiunea era realizata in main).

Optional .
Clasele Album, Artist si Chart sunt simple: au valori si cate un constructor pentru a sprijini 
clasele AlbumController ,ArtistController respectiv ChartsController. Clasa Chart contine id-ul sau,
id-ulalbumului cu care face legatura si top_chart care ajuta la ordonarea albumelor respective.

 ChartsController a fost modelata in stilul ArtistController si 
AlbumController, avand metoda create care adauga un nou element in baza de date ,
insertChart care completeaza functia create adaugand chart-urile pentru a fi gestionate
si Top care ordoneaza in query cei mai apreciati artisti.

In ArtistController si AlbumController import de la adresa din enunt si generam artisti si
albume cu nume, tari,date de lansare false.
