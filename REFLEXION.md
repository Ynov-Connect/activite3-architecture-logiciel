# Réflexion sur l'Architecture du Projet MavenSensorHub

## 1. Choix de Design de Packages

Le choix principal a été de créer un **module API dédié** contenant uniquement les contrats (interfaces, enums, records). Ca va permettre de faire en sorte que chaque module métier ne dépend plus que de l'API, d'éliminer les dépendances cycliques et d'appliquer l'inversion de dépendances

L'architecture en trois couches résultante (API → Core/Utils → Implementations) respecte le principe de responsabilité unique et facilite l'évolution du code.

## 2. Changements dans le Parent POM et Justification

### Centralisation des versions
- Ajout d'une section `<dependencyManagement>` pour gérer toutes les versions au même endroit
Ca va éviter les conflits de versions et facilite les mises à jour


## 3. Risques Évités


### Dépendances cycliques
L'ancienne architecture permettait des cycles implicites. Ces cycles rendent le code difficile à tester, maintenir et réutiliser. 

### Couplage fort aux implémentations
Avant, modifier une implémentation nécessitait de recompiler tous les modules dépendants. Maintenant, seul le module modifié est recompilé.


## 4. Prochaine Amélioration

La prochaine amélioration serait d'introduire un **module de tests d'intégration** séparé avec :
- Des tests end-to-end couvrant plusieurs modules
- Utilisation de TestContainers
- Ajout de Jacoco pour mesurer la couverture de code 


## 4. Si vous avez un problème avec les tests directement en local, il faut passer par le pannel maven via IntelliJ (j'ai eu du mal à trouvé), je vous explique comment faire :

Dans IntelliJ IDEA, dans le panneau Maven :
Ouvrez le panneau Maven (à droite)
Déroulez MavenSensorHub
Déroulez Lifecycle
Double-cliquez sur clean puis sur test

Et voila vous pouvez ! 
