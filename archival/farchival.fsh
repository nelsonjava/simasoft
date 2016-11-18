scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named warchival
jpa-setup
scaffold-setup --provider AngularJS

#  FundsLife entity
#  ############
jpa-new-entity --named FundsLife --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named isOpen --type Boolean

#  Funds entity
#  ############
jpa-new-entity --named Funds --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

#  SectionsTypes entity
#  ############
jpa-new-entity --named SectionsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Sections entity
#  ############
jpa-new-entity --named Sections --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named dir --type String

#  Series entity
#  ############
jpa-new-entity --named Series --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named located --type String
jpa-new-field --named procedures --type String
jpa-new-field --named dir --type String

#  TrdSeries entity
#  ############
jpa-new-entity --named TrdSeries --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Trd entity
#  ############
jpa-new-entity --named Trd --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  FinalDisposition entity
#  ############
jpa-new-entity --named FinalDisposition --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  DocumentalRetention entity
#  ############
jpa-new-entity --named DocumentalRetention --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named year --type Integer

#  FrequentlyQuery entity
#  ############
jpa-new-entity --named FrequentlyQuery --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  DocumentalsUnits entity
#  ############
jpa-new-entity --named DocumentalsUnits --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named startDate --type java.util.Date --temporalType TIMESTAMP

#  ConservationUnits entity
#  ############
jpa-new-entity --named ConservationUnits --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

#  VersionsControls entity
#  ############
jpa-new-entity --named VersionsControls --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named version --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named request --type String
jpa-new-field --named responsible --type String
jpa-new-field --named description --type String

#  DocumentalInventory entity
#  ############
jpa-new-entity --named DocumentalInventory --targetPackage co.simasoft.models
jpa-new-field --named object --type String
jpa-new-field --named deliveryDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named transferNumber --type Integer
jpa-new-field --named debugDate --type java.util.Date --temporalType TIMESTAMP

#  OriginalOrders entity
#  ############
jpa-new-entity --named OriginalOrders --targetPackage co.simasoft.models
jpa-new-field --named subject --type String
jpa-new-field --named code --type String
jpa-new-field --named entryDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named startDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named finalDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named folios --type Integer
jpa-new-field --named quantity --type Integer
jpa-new-field --named located --type String
jpa-new-field --named mail --type String
jpa-new-field --named notes --type String
jpa-new-field --named fileName --type String
jpa-new-field --named fileType --type String
jpa-new-field --named filedir --type String

#  DocumentalsUnitsTypes entity
#  ############
jpa-new-entity --named DocumentalsUnitsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Access entity
#  ############
jpa-new-entity --named Access --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Organizeds entity
#  ############
jpa-new-entity --named Organizeds --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  InventoryFinality entity
#  ############
jpa-new-entity --named InventoryFinality --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  DocumentalsSupports entity
#  ############
jpa-new-entity --named DocumentalsSupports --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String

#  ConservationUnitsTypes entity
#  ############
jpa-new-entity --named ConservationUnitsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Companies entity
#  ############
jpa-new-entity --named Companies --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  CompaniesRoles entity
#  ############
jpa-new-entity --named CompaniesRoles --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Activities entity
#  ############
jpa-new-entity --named Activities --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Tasks entity
#  ############
jpa-new-entity --named Tasks --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named optimisticDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named pessimisticDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named startDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named finalDate --type java.util.Date --temporalType TIMESTAMP

#  FundsLife Relationships 
#  ############
#  ############1..*
#  FundsLife Uno a Muchos Bidirecccional No.5 Funds
cd ..
cd FundsLife.java
jpa-new-field --named funds --type co.simasoft.models.Funds --relationshipType One-to-Many;

#  Funds Relationships 
#  ############
#  ############1..*
#  Funds Uno a Muchos Bidirecccional No.5 Sections
cd ..
cd Funds.java
jpa-new-field --named sections --type co.simasoft.models.Sections --relationshipType One-to-Many;

#  ############*..1
#  Funds Muchos a Uno Unidireccional No.3 Companies
cd ..
cd Funds.java
jpa-new-field --named companies --type co.simasoft.models.Companies --relationshipType Many-to-One;

#  ############*..1
#  Funds Muchos a Uno Unidireccional No.3 FundsLife
cd ..
cd Funds.java
jpa-new-field --named fundsLife --type co.simasoft.models.FundsLife --relationshipType Many-to-One;

#  SectionsTypes Relationships 
#  ############
#  ############1..*
#  SectionsTypes Uno a Muchos Bidirecccional No.5 Sections
cd ..
cd SectionsTypes.java
jpa-new-field --named sections --type co.simasoft.models.Sections --relationshipType One-to-Many;

#  Sections Relationships 
#  ############
#  ############1..*
#  Sections Uno a Muchos Bidirecccional No.5 Activities
cd ..
cd Sections.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType One-to-Many;

#  ############1..*
#  Sections Uno a Muchos Bidirecccional No.5 Tasks
cd ..
cd Sections.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType One-to-Many;

#  ############1..*
#Unitaria  Sections Uno a Muchos Bidirecccional No.5 Sections
cd ..
cd Sections.java
jpa-new-field --named objHijos --type co.simasoft.models.Sections --relationshipType One-to-Many;

#  ############1..*
#  Sections Uno a Muchos Bidirecccional No.5 Series
cd ..
cd Sections.java
jpa-new-field --named series --type co.simasoft.models.Series --relationshipType One-to-Many;

#  ############*..1
#  Sections Muchos a Uno Unidireccional No.3 SectionsTypes
cd ..
cd Sections.java
jpa-new-field --named sectionsTypes --type co.simasoft.models.SectionsTypes --relationshipType Many-to-One;

#  ############*..1
#Unitaria  Sections Muchos a Uno Unidireccional No.3 Sections
cd ..
cd Sections.java
jpa-new-field --named objPadre --type co.simasoft.models.Sections --relationshipType Many-to-One;

#  ############*..1
#  Sections Muchos a Uno Unidireccional No.3 Funds
cd ..
cd Sections.java
jpa-new-field --named funds --type co.simasoft.models.Funds --relationshipType Many-to-One;

#  Series Relationships 
#  ############
#  ############1..*
#  Series Uno a Muchos Bidirecccional No.5 Tasks
cd ..
cd Series.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType One-to-Many;

#  ############1..*
#  Series Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd Series.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  ############1..*
#Unitaria  Series Uno a Muchos Bidirecccional No.5 Series
cd ..
cd Series.java
jpa-new-field --named objHijos --type co.simasoft.models.Series --relationshipType One-to-Many;

#  ############1..*
#  Series Uno a Muchos Bidirecccional No.5 VersionsControls
cd ..
cd Series.java
jpa-new-field --named versionsControls --type co.simasoft.models.VersionsControls --relationshipType One-to-Many;

#  ############1..*
#  Series Uno a Muchos Bidirecccional No.5 TrdSeries
cd ..
cd Series.java
jpa-new-field --named trdSeries --type co.simasoft.models.TrdSeries --relationshipType One-to-Many;

#  ############*..1
#  Series Muchos a Uno Unidireccional No.3 Sections
cd ..
cd Series.java
jpa-new-field --named sections --type co.simasoft.models.Sections --relationshipType Many-to-One;

#  ############*..1
#Unitaria  Series Muchos a Uno Unidireccional No.3 Series
cd ..
cd Series.java
jpa-new-field --named objPadre --type co.simasoft.models.Series --relationshipType Many-to-One;

#  TrdSeries Relationships 
#  ############
#  ############*..1
#  TrdSeries Muchos a Uno Unidireccional No.3 Trd
cd ..
cd TrdSeries.java
jpa-new-field --named trd --type co.simasoft.models.Trd --relationshipType Many-to-One;

#  ############*..1
#  TrdSeries Muchos a Uno Unidireccional No.3 Series
cd ..
cd TrdSeries.java
jpa-new-field --named series --type co.simasoft.models.Series --relationshipType Many-to-One;

#  Trd Relationships 
#  ############
#  ############1..*
#  Trd Uno a Muchos Bidirecccional No.5 TrdSeries
cd ..
cd Trd.java
jpa-new-field --named trdSeries --type co.simasoft.models.TrdSeries --relationshipType One-to-Many;

#  ############*..1
#  Trd Muchos a Uno Unidireccional No.3 DocumentalRetention
cd ..
cd Trd.java
jpa-new-field --named documentalRetention --type co.simasoft.models.DocumentalRetention --relationshipType Many-to-One;

#  ############*..1
#  Trd Muchos a Uno Unidireccional No.3 DocumentalRetention
cd ..
cd Trd.java
jpa-new-field --named documentalRetention --type co.simasoft.models.DocumentalRetention --relationshipType Many-to-One;

#  ############*..1
#  Trd Muchos a Uno Unidireccional No.3 FinalDisposition
cd ..
cd Trd.java
jpa-new-field --named finalDisposition --type co.simasoft.models.FinalDisposition --relationshipType Many-to-One;

#  FinalDisposition Relationships 
#  ############
#  ############1..*
#  FinalDisposition Uno a Muchos Bidirecccional No.5 Trd
cd ..
cd FinalDisposition.java
jpa-new-field --named trd --type co.simasoft.models.Trd --relationshipType One-to-Many;

#  DocumentalRetention Relationships 
#  ############
#  ############1..*
#  DocumentalRetention Uno a Muchos Bidirecccional No.5 Trd
cd ..
cd DocumentalRetention.java
jpa-new-field --named trd --type co.simasoft.models.Trd --relationshipType One-to-Many;

#  ############1..*
#  DocumentalRetention Uno a Muchos Bidirecccional No.5 Trd
cd ..
cd DocumentalRetention.java
jpa-new-field --named trd --type co.simasoft.models.Trd --relationshipType One-to-Many;

#  FrequentlyQuery Relationships 
#  ############
#  ############1..*
#  FrequentlyQuery Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd FrequentlyQuery.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  DocumentalsUnits Relationships 
#  ############
#  ############1..*
#  DocumentalsUnits Uno a Muchos Bidirecccional No.5 OriginalOrders
cd ..
cd DocumentalsUnits.java
jpa-new-field --named originalOrders --type co.simasoft.models.OriginalOrders --relationshipType One-to-Many;

#  ############1..*
#  DocumentalsUnits Uno a Muchos Bidirecccional No.5 VersionsControls
cd ..
cd DocumentalsUnits.java
jpa-new-field --named versionsControls --type co.simasoft.models.VersionsControls --relationshipType One-to-Many;

#  ############1..*
#Unitaria  DocumentalsUnits Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd DocumentalsUnits.java
jpa-new-field --named objHijos --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 CompaniesRoles
cd ..
cd DocumentalsUnits.java
jpa-new-field --named companiesRoles --type co.simasoft.models.CompaniesRoles --relationshipType Many-to-One;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 CompaniesRoles
cd ..
cd DocumentalsUnits.java
jpa-new-field --named companiesRoles --type co.simasoft.models.CompaniesRoles --relationshipType Many-to-One;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 Series
cd ..
cd DocumentalsUnits.java
jpa-new-field --named series --type co.simasoft.models.Series --relationshipType Many-to-One;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 Organizeds
cd ..
cd DocumentalsUnits.java
jpa-new-field --named organizeds --type co.simasoft.models.Organizeds --relationshipType Many-to-One;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 Access
cd ..
cd DocumentalsUnits.java
jpa-new-field --named access --type co.simasoft.models.Access --relationshipType Many-to-One;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 FrequentlyQuery
cd ..
cd DocumentalsUnits.java
jpa-new-field --named frequentlyQuery --type co.simasoft.models.FrequentlyQuery --relationshipType Many-to-One;

#  ############*..1
#  DocumentalsUnits Muchos a Uno Unidireccional No.3 DocumentalsUnitsTypes
cd ..
cd DocumentalsUnits.java
jpa-new-field --named documentalsUnitsTypes --type co.simasoft.models.DocumentalsUnitsTypes --relationshipType Many-to-One;

#  ############*..1
#Unitaria  DocumentalsUnits Muchos a Uno Unidireccional No.3 DocumentalsUnits
cd ..
cd DocumentalsUnits.java
jpa-new-field --named objPadre --type co.simasoft.models.DocumentalsUnits --relationshipType Many-to-One;

#  ConservationUnits Relationships 
#  ############
#  ############1..*
#  ConservationUnits Uno a Muchos Bidirecccional No.5 OriginalOrders
cd ..
cd ConservationUnits.java
jpa-new-field --named originalOrders --type co.simasoft.models.OriginalOrders --relationshipType One-to-Many;

#  ############*..1
#  ConservationUnits Muchos a Uno Unidireccional No.3 ConservationUnitsTypes
cd ..
cd ConservationUnits.java
jpa-new-field --named conservationUnitsTypes --type co.simasoft.models.ConservationUnitsTypes --relationshipType Many-to-One;

#  VersionsControls Relationships 
#  ############
#  ############*..1
#  VersionsControls Muchos a Uno Unidireccional No.3 DocumentalsUnits
cd ..
cd VersionsControls.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType Many-to-One;

#  ############*..1
#  VersionsControls Muchos a Uno Unidireccional No.3 Series
cd ..
cd VersionsControls.java
jpa-new-field --named series --type co.simasoft.models.Series --relationshipType Many-to-One;

#  DocumentalInventory Relationships 
#  ############
#  ############1..*
#  DocumentalInventory Uno a Muchos Bidirecccional No.5 OriginalOrders
cd ..
cd DocumentalInventory.java
jpa-new-field --named originalOrders --type co.simasoft.models.OriginalOrders --relationshipType One-to-Many;

#  ############*..1
#  DocumentalInventory Muchos a Uno Unidireccional No.3 InventoryFinality
cd ..
cd DocumentalInventory.java
jpa-new-field --named inventoryFinality --type co.simasoft.models.InventoryFinality --relationshipType Many-to-One;

#  OriginalOrders Relationships 
#  ############
#  ############*..1
#  OriginalOrders Muchos a Uno Unidireccional No.3 DocumentalsUnits
cd ..
cd OriginalOrders.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType Many-to-One;

#  ############*..1
#  OriginalOrders Muchos a Uno Unidireccional No.3 DocumentalsSupports
cd ..
cd OriginalOrders.java
jpa-new-field --named documentalsSupports --type co.simasoft.models.DocumentalsSupports --relationshipType Many-to-One;

#  ############*..1
#  OriginalOrders Muchos a Uno Unidireccional No.3 ConservationUnits
cd ..
cd OriginalOrders.java
jpa-new-field --named conservationUnits --type co.simasoft.models.ConservationUnits --relationshipType Many-to-One;

#  ############*..1
#  OriginalOrders Muchos a Uno Unidireccional No.3 ConservationUnitsTypes
cd ..
cd OriginalOrders.java
jpa-new-field --named conservationUnitsTypes --type co.simasoft.models.ConservationUnitsTypes --relationshipType Many-to-One;

#  ############*..1
#  OriginalOrders Muchos a Uno Unidireccional No.3 DocumentalInventory
cd ..
cd OriginalOrders.java
jpa-new-field --named documentalInventory --type co.simasoft.models.DocumentalInventory --relationshipType Many-to-One;

#  DocumentalsUnitsTypes Relationships 
#  ############
#  ############1..*
#  DocumentalsUnitsTypes Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd DocumentalsUnitsTypes.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  Access Relationships 
#  ############
#  ############1..*
#  Access Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd Access.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  Organizeds Relationships 
#  ############
#  ############1..*
#  Organizeds Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd Organizeds.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  InventoryFinality Relationships 
#  ############
#  ############1..*
#  InventoryFinality Uno a Muchos Bidirecccional No.5 DocumentalInventory
cd ..
cd InventoryFinality.java
jpa-new-field --named documentalInventory --type co.simasoft.models.DocumentalInventory --relationshipType One-to-Many;

#  DocumentalsSupports Relationships 
#  ############
#  ############1..*
#  DocumentalsSupports Uno a Muchos Bidirecccional No.5 OriginalOrders
cd ..
cd DocumentalsSupports.java
jpa-new-field --named originalOrders --type co.simasoft.models.OriginalOrders --relationshipType One-to-Many;

#  ConservationUnitsTypes Relationships 
#  ############
#  ############1..*
#  ConservationUnitsTypes Uno a Muchos Bidirecccional No.5 ConservationUnits
cd ..
cd ConservationUnitsTypes.java
jpa-new-field --named conservationUnits --type co.simasoft.models.ConservationUnits --relationshipType One-to-Many;

#  ############1..*
#  ConservationUnitsTypes Uno a Muchos Bidirecccional No.5 OriginalOrders
cd ..
cd ConservationUnitsTypes.java
jpa-new-field --named originalOrders --type co.simasoft.models.OriginalOrders --relationshipType One-to-Many;

#  Companies Relationships 
#  ############
#  ############1..*
#  Companies Uno a Muchos Bidirecccional No.5 Funds
cd ..
cd Companies.java
jpa-new-field --named funds --type co.simasoft.models.Funds --relationshipType One-to-Many;

#  CompaniesRoles Relationships 
#  ############
#  ############1..*
#  CompaniesRoles Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd CompaniesRoles.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  ############1..*
#  CompaniesRoles Uno a Muchos Bidirecccional No.5 DocumentalsUnits
cd ..
cd CompaniesRoles.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType One-to-Many;

#  Activities Relationships 
#  ############
#  ############*..1
#  Activities Muchos a Uno Unidireccional No.3 Sections
cd ..
cd Activities.java
jpa-new-field --named sections --type co.simasoft.models.Sections --relationshipType Many-to-One;

#  Tasks Relationships 
#  ############
#  ############*..1
#  Tasks Muchos a Uno Unidireccional No.3 Sections
cd ..
cd Tasks.java
jpa-new-field --named sections --type co.simasoft.models.Sections --relationshipType Many-to-One;

#  ############*..1
#  Tasks Muchos a Uno Unidireccional No.3 Series
cd ..
cd Tasks.java
jpa-new-field --named series --type co.simasoft.models.Series --relationshipType Many-to-One;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
