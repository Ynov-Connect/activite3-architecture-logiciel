# Changements d'Architecture

## Objectif
Réduire les dépendances cycliques entre les modules en créant un module API centralisé.

## Solution Implémentée

### Nouveau Module : `api`
Un nouveau module `api` a été créé pour héberger tous les contrats (interfaces, enums, records) partagés entre les modules.

#### Contenu du module API :
- **Interfaces de capteurs** : `ISensor`, `ISensorFactory`
- **Types de données** : `SensorData` (record), `SensorType` (enum)
- **Interfaces de gestion de données** : `IDataManager`, `IDataProcessor`, `IDataStorage`
- **Interfaces de rapports** : `IReportGenerator`, `ReportType` (enum)
- **Interfaces d'interface utilisateur** : `IUserInterface`, `IApplication`, `UserAction` (enum)
- **Interfaces de logging** : `ILogger`, `LogType` (enum)

### Dépendances Avant/Après

#### Avant la réorganisation :
- **data-management** dépendait de : `sensor-data-collection`, `utils`
- **report-generation** dépendait de : `sensor-data-collection`, `utils`
- **user-interface** dépendait de : `data-management`, `sensor-data-collection`
- **sensor-data-collection** dépendait de : `utils`
- **utils** : aucune dépendance

#### Après la réorganisation :
- **api** : aucune dépendance (module de contrats uniquement)
- **utils** dépend de : `api`
- **sensor-data-collection** dépend de : `api`, `utils` (provided)
- **data-management** dépend de : `api`, `utils` (provided)
- **report-generation** dépend de : `api`, `utils` (provided)
- **user-interface** dépend de : `api`
- **main-application** dépend de : `api`, `utils`, tous les autres modules


## Avantages

1. Les contrats sont isolés dans un module dédié
2. Les modules dépendent uniquement des interfaces
3. Modifier une implémentation n'affecte pas les autres modules
4. Les interfaces facilitent les tests unitaires
5. Ajouter de nouveaux modules ou modifier les existants est plus simple

## Structure des Packages

```
api/
└── src/main/java/com/jad/api/
    ├── ISensor.java
    ├── ISensorFactory.java
    ├── SensorData.java
    ├── SensorType.java
    ├── IDataManager.java
    ├── IDataProcessor.java
    ├── IDataStorage.java
    ├── IReportGenerator.java
    ├── ReportType.java
    ├── IUserInterface.java
    ├── IApplication.java
    ├── UserAction.java
    ├── ILogger.java
    └── LogType.java
```

## Tests
Les tests unitaires vérifient maintenant que :
- Chaque module (sauf main-application) n'a plus de dépendances circulaires
- Le module `utils` ne dépend d'aucun autre module métier
- Les modules métier dépendent uniquement de `api` et éventuellement `utils`

