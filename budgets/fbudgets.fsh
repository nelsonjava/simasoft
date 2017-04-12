scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wbudgets
jpa-setup
scaffold-setup --provider AngularJS

#  Apus entity
#  ############
jpa-new-entity --named Apus --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  ConstructionActivities entity
#  ############
jpa-new-entity --named ConstructionActivities --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  ConstructionChapters entity
#  ############
jpa-new-entity --named ConstructionChapters --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  TypesMeasurementUnits entity
#  ############
jpa-new-entity --named TypesMeasurementUnits --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  MeasurementUnits entity
#  ############
jpa-new-entity --named MeasurementUnits --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  Years entity
#  ############
jpa-new-entity --named Years --targetPackage co.simasoft.models
jpa-new-field --named year --type String
jpa-new-field --named ipc --type Double

#  WorksConstruction entity
#  ############
jpa-new-entity --named WorksConstruction --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP

#  WorkActivities entity
#  ############
jpa-new-entity --named WorkActivities --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  TypesWorksConstruction entity
#  ############
jpa-new-entity --named TypesWorksConstruction --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  ConstructionMaterials entity
#  ############
jpa-new-entity --named ConstructionMaterials --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String
jpa-new-field --named price --type Double

#  ConstructionTransports entity
#  ############
jpa-new-entity --named ConstructionTransports --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String
jpa-new-field --named rate --type Double

#  ConstructionWorkforce entity
#  ############
jpa-new-entity --named ConstructionWorkforce --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String
jpa-new-field --named basic --type Double
jpa-new-field --named benefits --type Double
jpa-new-field --named salary --type Double

#  ConstructionEquipments entity
#  ############
jpa-new-entity --named ConstructionEquipments --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String
jpa-new-field --named rate --type Double

#  TypesConstructionMaterials entity
#  ############
jpa-new-entity --named TypesConstructionMaterials --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  TypesConstructionTransports entity
#  ############
jpa-new-entity --named TypesConstructionTransports --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  TypesConstructionWorkforce entity
#  ############
jpa-new-entity --named TypesConstructionWorkforce --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  TypesConstructionEquipments entity
#  ############
jpa-new-entity --named TypesConstructionEquipments --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  Apus Relationships 
#  ############
#  ############*..*
#  Apus Muchos a Muchos Bidirecccional No.7 ConstructionMaterials
cd ..
cd Apus.java
jpa-new-field --named constructionMaterials --type co.simasoft.models.ConstructionMaterials --relationshipType Many-to-Many  ----inverseFieldName apus;

#  ############*..*
#  Apus Muchos a Muchos Bidirecccional No.7 ConstructionWorkforce
cd ..
cd Apus.java
jpa-new-field --named constructionWorkforce --type co.simasoft.models.ConstructionWorkforce --relationshipType Many-to-Many  ----inverseFieldName apus;

#  ############*..*
#  Apus Muchos a Muchos Bidirecccional No.7 ConstructionEquipments
cd ..
cd Apus.java
jpa-new-field --named constructionEquipments --type co.simasoft.models.ConstructionEquipments --relationshipType Many-to-Many  ----inverseFieldName apus;

#  ############*..*
#  Apus Muchos a Muchos Bidirecccional No.7 ConstructionTransports
cd ..
cd Apus.java
jpa-new-field --named constructionTransports --type co.simasoft.models.ConstructionTransports --relationshipType Many-to-Many  ----inverseFieldName apus;

#  ############*..1
#  Apus Muchos a Uno Unidireccional No.3 MeasurementUnits
cd ..
cd Apus.java
jpa-new-field --named measurementUnits --type co.simasoft.models.MeasurementUnits --relationshipType Many-to-One;

#  ############*..1
#  Apus Muchos a Uno Unidireccional No.3 ConstructionActivities
cd ..
cd Apus.java
jpa-new-field --named constructionActivities --type co.simasoft.models.ConstructionActivities --relationshipType Many-to-One;

#  ConstructionActivities Relationships 
#  ############
#  ############1..*
#  ConstructionActivities Uno a Muchos Bidirecccional No.5 WorkActivities
cd ..
cd ConstructionActivities.java
jpa-new-field --named workActivities --type co.simasoft.models.WorkActivities --relationshipType One-to-Many;

#  ############1..*
#  ConstructionActivities Uno a Muchos Bidirecccional No.5 Apus
cd ..
cd ConstructionActivities.java
jpa-new-field --named apus --type co.simasoft.models.Apus --relationshipType One-to-Many;

#  ############*..*
#  ConstructionActivities Muchos a Muchos Unidireccional No.6 TypesWorksConstruction
cd ..
cd ConstructionActivities.java
jpa-new-field --named typesWorksConstruction --type co.simasoft.models.TypesWorksConstruction --relationshipType Many-to-Many  ----inverseFieldName constructionActivities;

#  ############*..1
#  ConstructionActivities Muchos a Uno Unidireccional No.3 ConstructionChapters
cd ..
cd ConstructionActivities.java
jpa-new-field --named constructionChapters --type co.simasoft.models.ConstructionChapters --relationshipType Many-to-One;

#  ConstructionChapters Relationships 
#  ############
#  ############1..*
#  ConstructionChapters Uno a Muchos Bidirecccional No.5 ConstructionActivities
cd ..
cd ConstructionChapters.java
jpa-new-field --named constructionActivities --type co.simasoft.models.ConstructionActivities --relationshipType One-to-Many;

#  TypesMeasurementUnits Relationships 
#  ############
#  ############1..*
#  TypesMeasurementUnits Uno a Muchos Bidirecccional No.5 MeasurementUnits
cd ..
cd TypesMeasurementUnits.java
jpa-new-field --named measurementUnits --type co.simasoft.models.MeasurementUnits --relationshipType One-to-Many;

#  MeasurementUnits Relationships 
#  ############
#  ############1..*
#  MeasurementUnits Uno a Muchos Bidirecccional No.5 Apus
cd ..
cd MeasurementUnits.java
jpa-new-field --named apus --type co.simasoft.models.Apus --relationshipType One-to-Many;

#  ############*..1
#  MeasurementUnits Muchos a Uno Unidireccional No.3 TypesMeasurementUnits
cd ..
cd MeasurementUnits.java
jpa-new-field --named typesMeasurementUnits --type co.simasoft.models.TypesMeasurementUnits --relationshipType Many-to-One;

#  Years Relationships 
#  ############
#  ############1..*
#  Years Uno a Muchos Bidirecccional No.5 WorksConstruction
cd ..
cd Years.java
jpa-new-field --named worksConstruction --type co.simasoft.models.WorksConstruction --relationshipType One-to-Many;

#  WorksConstruction Relationships 
#  ############
#  ############1..*
#  WorksConstruction Uno a Muchos Bidirecccional No.5 WorkActivities
cd ..
cd WorksConstruction.java
jpa-new-field --named workActivities --type co.simasoft.models.WorkActivities --relationshipType One-to-Many;

#  ############1..*
#Unitaria  WorksConstruction Uno a Muchos Bidirecccional No.5 WorksConstruction
cd ..
cd WorksConstruction.java
jpa-new-field --named objHijos --type co.simasoft.models.WorksConstruction --relationshipType One-to-Many;

#  ############*..1
#  WorksConstruction Muchos a Uno Unidireccional No.3 Years
cd ..
cd WorksConstruction.java
jpa-new-field --named years --type co.simasoft.models.Years --relationshipType Many-to-One;

#  ############*..1
#Unitaria  WorksConstruction Muchos a Uno Unidireccional No.3 WorksConstruction
cd ..
cd WorksConstruction.java
jpa-new-field --named objPadre --type co.simasoft.models.WorksConstruction --relationshipType Many-to-One;

#  ############*..1
#  WorksConstruction Muchos a Uno Unidireccional No.3 TypesWorksConstruction
cd ..
cd WorksConstruction.java
jpa-new-field --named typesWorksConstruction --type co.simasoft.models.TypesWorksConstruction --relationshipType Many-to-One;

#  WorkActivities Relationships 
#  ############
#  ############*..1
#  WorkActivities Muchos a Uno Unidireccional No.3 WorksConstruction
cd ..
cd WorkActivities.java
jpa-new-field --named worksConstruction --type co.simasoft.models.WorksConstruction --relationshipType Many-to-One;

#  ############*..1
#  WorkActivities Muchos a Uno Unidireccional No.3 ConstructionActivities
cd ..
cd WorkActivities.java
jpa-new-field --named constructionActivities --type co.simasoft.models.ConstructionActivities --relationshipType Many-to-One;

#  TypesWorksConstruction Relationships 
#  ############
#  ############1..*
#  TypesWorksConstruction Uno a Muchos Bidirecccional No.5 WorksConstruction
cd ..
cd TypesWorksConstruction.java
jpa-new-field --named worksConstruction --type co.simasoft.models.WorksConstruction --relationshipType One-to-Many;

#  ############*..*
#  TypesWorksConstruction Muchos a Muchos Bidirecccional No.7 ConstructionActivities
cd ..
cd TypesWorksConstruction.java
jpa-new-field --named constructionActivities --type co.simasoft.models.ConstructionActivities --relationshipType Many-to-Many  ----inverseFieldName typesWorksConstruction;

#  ConstructionMaterials Relationships 
#  ############
#  ############*..*
#  ConstructionMaterials Muchos a Muchos Unidireccional No.6 Apus
cd ..
cd ConstructionMaterials.java
jpa-new-field --named apus --type co.simasoft.models.Apus --relationshipType Many-to-Many  ----inverseFieldName constructionMaterials;

#  ############*..1
#  ConstructionMaterials Muchos a Uno Unidireccional No.3 TypesConstructionMaterials
cd ..
cd ConstructionMaterials.java
jpa-new-field --named typesConstructionMaterials --type co.simasoft.models.TypesConstructionMaterials --relationshipType Many-to-One;

#  ConstructionTransports Relationships 
#  ############
#  ############*..*
#  ConstructionTransports Muchos a Muchos Unidireccional No.6 Apus
cd ..
cd ConstructionTransports.java
jpa-new-field --named apus --type co.simasoft.models.Apus --relationshipType Many-to-Many  ----inverseFieldName constructionTransports;

#  ############*..1
#  ConstructionTransports Muchos a Uno Unidireccional No.3 TypesConstructionTransports
cd ..
cd ConstructionTransports.java
jpa-new-field --named typesConstructionTransports --type co.simasoft.models.TypesConstructionTransports --relationshipType Many-to-One;

#  ConstructionWorkforce Relationships 
#  ############
#  ############*..*
#  ConstructionWorkforce Muchos a Muchos Unidireccional No.6 Apus
cd ..
cd ConstructionWorkforce.java
jpa-new-field --named apus --type co.simasoft.models.Apus --relationshipType Many-to-Many  ----inverseFieldName constructionWorkforce;

#  ############*..1
#  ConstructionWorkforce Muchos a Uno Unidireccional No.3 TypesConstructionWorkforce
cd ..
cd ConstructionWorkforce.java
jpa-new-field --named typesConstructionWorkforce --type co.simasoft.models.TypesConstructionWorkforce --relationshipType Many-to-One;

#  ConstructionEquipments Relationships 
#  ############
#  ############*..*
#  ConstructionEquipments Muchos a Muchos Unidireccional No.6 Apus
cd ..
cd ConstructionEquipments.java
jpa-new-field --named apus --type co.simasoft.models.Apus --relationshipType Many-to-Many  ----inverseFieldName constructionEquipments;

#  ############*..1
#  ConstructionEquipments Muchos a Uno Unidireccional No.3 TypesConstructionEquipments
cd ..
cd ConstructionEquipments.java
jpa-new-field --named typesConstructionEquipments --type co.simasoft.models.TypesConstructionEquipments --relationshipType Many-to-One;

#  TypesConstructionMaterials Relationships 
#  ############
#  ############1..*
#  TypesConstructionMaterials Uno a Muchos Bidirecccional No.5 ConstructionMaterials
cd ..
cd TypesConstructionMaterials.java
jpa-new-field --named constructionMaterials --type co.simasoft.models.ConstructionMaterials --relationshipType One-to-Many;

#  TypesConstructionTransports Relationships 
#  ############
#  ############1..*
#  TypesConstructionTransports Uno a Muchos Bidirecccional No.5 ConstructionTransports
cd ..
cd TypesConstructionTransports.java
jpa-new-field --named constructionTransports --type co.simasoft.models.ConstructionTransports --relationshipType One-to-Many;

#  TypesConstructionWorkforce Relationships 
#  ############
#  ############1..*
#  TypesConstructionWorkforce Uno a Muchos Bidirecccional No.5 ConstructionWorkforce
cd ..
cd TypesConstructionWorkforce.java
jpa-new-field --named constructionWorkforce --type co.simasoft.models.ConstructionWorkforce --relationshipType One-to-Many;

#  TypesConstructionEquipments Relationships 
#  ############
#  ############1..*
#  TypesConstructionEquipments Uno a Muchos Bidirecccional No.5 ConstructionEquipments
cd ..
cd TypesConstructionEquipments.java
jpa-new-field --named constructionEquipments --type co.simasoft.models.ConstructionEquipments --relationshipType One-to-Many;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
