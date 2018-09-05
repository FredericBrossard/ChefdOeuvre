INSERT INTO public.application(
	id, name)
	VALUES (1,'NetCredit'), (2,'NetDemat'), (3,'ODEJ'), (4,'Crédit Bail Santé'), (5,'SELL - Outil d Aide à la Vente'), (6,'Webmarchand Crédit Auto');

 INSERT INTO public.etat(
	id, name)
	VALUES (1, 'Ouvert'), (2, 'Accès à l application limité, diagnostic en cours'), (3, 'Service indisponible, l incident est en cours d analyse par les équipes'); 

INSERT INTO public.scenario(
	id, namescena, aplication)
	VALUES (1, 'Page accueil', 1), (2, 'Offre alternative', 1), (3, 'Utilisation carte', 1), (4, 'Entrée dossier papier', 1), (5, 'Entrée dossier démat', 2), (6, 'Automobile', 3),
	(7, 'Distribution', 3) , (8, 'Interface CBS', 4), (9, 'Page accueil', 5), (10, 'Saisie dossier', 5), (11, 'Vente crédit auto', 6);
	
	INSERT INTO public.statut(
	id, name, scenario)
	VALUES  
(1, 'Ouverture à l heure', 1), 
(2, 'Application indisponible', 1), 
(3, 'Ouverture a l heure', 2), 
(4, 'Offre alternative indisponible', 2), 
(5,  'Ralentissement, surveillance en cours', 2), 
(6, 'Ouverture à l heure', 3), 
(7, 'Utilisation carte indisponible', 3), 
(8, 'Ralentissement, surveillance en cours', 3), 
(9, 'Ouverture à l heure', 4), 
(10, 'Souscription indisponible', 4), 
(11, 'Ralentissement, surveillance en cours', 4), 
(12, 'Ouverture à l heure',5 ), 
(13, 'Dématérialisation impossible', 5), 
(14, 'Ralentissement, surveillance en cours', 5), 
(15, 'Ouverture à l heure', 6),
(16, 'Décision dossier auto impossible', 6),
(17, 'Ralentissement, surveillance en cours',6 ),
(18, 'Ouverture à l heure', 7) , 
(19, 'Décision dossier distribution impossible ', 7) ,
(20, 'Ralentissement, surveillance en cours', 7) ,
(21, 'Ouverture à l heure', 8), 
(22, 'Souscription CMV indisponible', 8), 
(23, 'Ralentissement, surveillance en cours', 8), 
(24, 'Ouverture à l heure', 9), 
(25,  'Application indisponible',9), 
(26, 'Ouverture à l heure', 10), 
(27,  'Souscription auto indisponible', 10), 
(28, 'Ralentissement, surveillance en cours', 10), 
(29, 'Ouverture à l heure', 11), 
(30, 'Souscription auto API indisponible', 11), 
(31, 'Ralentissement, surveillance en cours', 11);