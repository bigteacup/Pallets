# Pallets

Sert à calculer le nombre de colis, de pièces, les poids bruts et nets afin de vérifier la conformité des bons de livraison des fournisseurs.
Vous pouvez déterminer facilement tout les éléments nécessaires à un agréage précis en une saisie rapide des éléments connus.

Fonctionnalités :
- Les calculs se lancent immédiatement à chaque saisie de chiffre.
- Il n'est pas nécessaire de saisir les données qui ne vous intéressent pas. 
- Plusieurs modes d'affichage visant à épurer les champs de saisie afin de viser une simplicité maximum. 
- Personnalisation des valeurs par défauts des champs de saisie etc...

Calcule automatiquement :

- Poids brut attendu à partir du poids net facturé par le fournisseur
- Poids net à partir d'un poids brut pesé
- L'écart (Delta) entre le poids net facturé et le poids net réel
- Tare palettes + palettes intermédiaires
- Tare colis
- Nombre de pièces par colis et par lots (saisie directe ou échantillonnage)
- Nombre de colis (Multiplicateur Colonne-Tranche si nécessaire)
- Taux de pièces abîmées
- Poids Net moyen par colis
- Poids Net moyen par pièce


Info :
- Les poids des palettes intermédiaires sont à ajouter à la tare palette et non à entrer dans le champs "Nombre de palettes au Sol".

- Le "Delta" est calculé entre le "poids net annoncé" et le poids net déterminé par le "poids brut" de votre pesée nommé "poids net réel" dans les résultats. 

- Toutes les données sont calculées sur le "poids net réel" issu du "poids brut".
