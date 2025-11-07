# Réflexion sur le Refactoring Maven SensorHub

## Choix de conception

### Modularisation simplifiée
Deux nouveaux modules :
- **`shared-model`** : Contient les types de données partagés (`SensorData`, `SensorType`) - le domaine métier
- **`report-spi`** : Contient le contrat SPI pour la génération de rapports (`IReportGenerator`, `ReportType`)

Cette séparation respecte le principe SRP (Single Responsibility Principle) : chaque module a une responsabilité claire et unique.

### Architecture en couches
L'architecture résultante suit un modèle en couches :
1. **Couche modèle** (`shared-model`) : Les données pures sans dépendances
2. **Couche SPI** (`report-spi`) : Les contrats d'extension (Service Provider Interface)
3. **Couche API** (`api`) : Les contrats applicatifs qui orchestrent le tout
4. **Couches d'implémentation** : Les modules métier qui implémentent les contrats

## Modifications POM principales

### Centralisation des versions
Toutes les versions des plugins et dépendances sont centralisées dans le POM parent via `<properties>` :
- JUnit : 5.8.1
- Maven Compiler Plugin : 3.10.1
- Maven Surefire Plugin : 3.0.0-M5
- Maven Enforcer Plugin : 3.1.0

### DependencyManagement
Utilisation de `<dependencyManagement>` pour :
- Éviter la duplication des versions dans les modules enfants
- Garantir la cohérence des versions à travers tout le projet
- Faciliter les mises à jour futures


## Risques évités

### Couplage fort éliminé
Avant ce refactoring, les modules s'appelaient directement entre eux. Maintenant, tout passe par des interfaces définies dans des modules dédiés.

### Violations du principe de dépendance
L'utilisation du `maven-enforcer-plugin` avec `<dependencyConvergence/>` empêche les conflits de versions qui pourraient causer des bugs(ClassNotFoundException, NoSuchMethodError, etc.).

### Évolution impossible
Avec l'ancienne structure, ajouter un nouveau type de rapport ou de capteur nécessitait de modifier plusieurs modules. Maintenant, la séparation des contrats (SPI) et de l'implémentation, on peut ajouter de nouvelles implémentations sans toucher aux modules existants (Open/Closed Principle).

## Améliorations futures

### Service Loader pour les plugins
Implémenter le mécanisme Java SPI (`ServiceLoader`) pour  les implémentations de `IReportGenerator`, permettant d'ajouter de nouveaux formats de rapport sans recompilation.

