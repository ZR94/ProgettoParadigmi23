In questo progetto, ho sviluppato un sistema di gestione delle prenotazioni delle aule universitarie.

Classi

Aula: Questa è una classe astratta che rappresenta un'aula generica dell'università. Ha attributi come nome, capienza e dotazioni. Inoltre, contiene un metodo astratto getTipo() per ottenere il tipo di aula e un secondo costruttore che prende in input dotazioni aggiuntive. Le classi AulaBiologia, AulaInformatica e AulaSemplice sono sottoclassi di Aula che rappresentano tipi specifici di aule con le loro dotazioni predefinite.

Docente: Questa classe rappresenta un docente dell'università. Ha attributi come nome, cognome e una matricola che viene assegnata in modo automatico dal sistema.

Prenotazioni: Questa classe rappresenta una prenotazione, infatti dati la data, l’orario d’inizio, l’orario di fine, un’aula e un docente, genera una prenotazione.

GestorePrenotazioni: Questa classe è responsabile della gestione delle prenotazioni delle aule. Contiene una lista di prenotazioni, una lista di aule e un vettore di docenti. È possibile aggiungere aule e docenti alla lista corrispondente. Inoltre, è possibile aggiungere prenotazioni alla lista di prenotazioni, ma solo se non esistono prenotazioni conflittuali con aule e orari già prenotati. Inoltre, con il metodo serchAula è possibile cercare le aule libere con diversi parametri e con i metodi SavetoFile e LoadFromFile è possibile salvare e caricare i dati.

Report: Questa è una classe annidata all’interno della classe GestorePrenotazioni, essa permette di generare dei report delle prenotazioni contenute nel GestorePrenotazioni, selezionando una data e un’aula o un docente.

Il programma offre le seguenti funzionalità principali:

1.	Aggiunta di aule: È possibile aggiungere nuove aule al sistema specificandone il tipo (biologia, informatica, semplice) e in modo opzionale selezionare delle dotazioni aggiuntive, oltre a quelle di cui sono dotate le aule.
2.	Aggiunta di docenti: È possibile aggiungere nuovi docenti al sistema fornendo le loro informazioni personali come nome, cognome; la matricola sarà assegnata in modo automatico dal sistema.
3.	Prenotazione di aule: È possibile effettuare prenotazioni delle aule specificando il docente, l'aula desiderata e il giorno e l'orario di inizio e fine prenotazione. Il sistema verifica se l'aula è disponibile per quel determinato giorno e orario, se non ci sono conflitti con altre prenotazioni già effettuate, la prenotazione viene registrata.
4.	Ricerca aule libere: È possibile ricercare le aule libere in una certa fascia oraria in un determinato giorno, inoltre, è possibile selezionare parametri aggiuntivi per la ricerca, come una capienza minima o una specifica dotazione.
5.	Visualizzazione delle aule: Il sistema consente di visualizzare le prenotazioni effettuate, mostrando i dettagli come il docente responsabile, l'aula e l'orario.
6.	Visualizzazione dei docenti: Il sistema consente di visualizzare nome cognome e matricola dei docenti.
7.	Stampa di report: È possibile stampare il report delle prenotazioni relative a un’aula o a un docente, in ordine di fascia di orario, per una specifica data.
8.	Salvataggio e caricamento dei dati: L’utente ha la possibilità di salvare o caricare i dati del GestorePrenotazioni

Ulteriori dettagli sulle funzionalità del programma:

Gestione degli orari delle prenotazioni: Abbiamo incluso una gestione degli orari delle prenotazioni per evitare sovrapposizioni. Il sistema tiene traccia delle prenotazioni esistenti e verifica se ci sono conflitti quando un utente cerca di effettuare una nuova prenotazione. In caso di sovrapposizione, il sistema visualizza un messaggio di avviso e richiede all'utente di selezionare un orario alternativo o un'altra aula.

Interfaccia utente: Ho sviluppato un'interfaccia utente intuitiva per consentire agli utenti di interagire facilmente con il sistema di gestione delle prenotazioni delle aule universitarie. L'interfaccia utente fornisce un menu di opzioni chiare per l'aggiunta di aule, l'aggiunta di docenti, l'effettuazione delle prenotazioni, la ricerca delle aule, le visualizzazioni di docenti o aule e la stampa di report delle prenotazioni di aule o docenti. Inoltre, vengono forniti feedback visivi e messaggi di conferma per guidare gli utenti durante l'utilizzo del programma.
