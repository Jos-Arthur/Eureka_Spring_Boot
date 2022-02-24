Dans ce projet nous avons implementé trois (03) microservices :

- Microservice 1 : Ce microservice permet d'effectuer la gestion des produits.
Il est contenu dans le repertoire "product-server" et est à l'ecoute au port 9090.

- Microservice 2 : Ce microservice permet d'effectuer la gestion des personnes (un utilisateur à des enfants).
Il est contenu dans le repertoire "personne-server" et est à l'ecoute au port 9091.

-Microservice 3 : Ce microservice permet d'implement la connexion JWT et la gestion des categories et des transactions d'un produits.
Il est contenu dans le repertoire "jwt-security" et est à l'ecoute au port 9092.

- Repertoire  : 
	- eureka-server qui ecoute au port 8761 est le catalogue de nos microservice. Il est serveur principal
	
	- ecme-zuul-api qui est notre projet zuul qui ecoute au port 8082 et est client


DEFINITION DES TECHNOLOGIES 

- Eureka est un registre voir  un catalogue des differents microservices qui existe dans notre projet.

- Zuul est le point d'entré principal de notre projet( c'est à travers zuul que nous obtenons les divers microservices implementés).


NB : Les microservices sont des clients


