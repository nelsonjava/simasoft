scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wcrm
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

#  BooksTypes entity
#  ############
jpa-new-entity --named BooksTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Books entity
#  ############
jpa-new-entity --named Books --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  Chapters entity
#  ############
jpa-new-entity --named Chapters --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  Brands entity
#  ############
jpa-new-entity --named Brands --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Companies entity
#  ############
jpa-new-entity --named Companies --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  EmployeesTypes entity
#  ############
jpa-new-entity --named EmployeesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Employees entity
#  ############
jpa-new-entity --named Employees --targetPackage co.simasoft.models
jpa-new-field --named code --type String

#  CompaniesRolesTypes entity
#  ############
jpa-new-entity --named CompaniesRolesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  CompaniesRoles entity
#  ############
jpa-new-entity --named CompaniesRoles --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  ChargesTypes entity
#  ############
jpa-new-entity --named ChargesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Charges entity
#  ############
jpa-new-entity --named Charges --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  ImprovementTypes entity
#  ############
jpa-new-entity --named ImprovementTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  ImprovementSources entity
#  ############
jpa-new-entity --named ImprovementSources --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  ContinualImprovements entity
#  ############
jpa-new-entity --named ContinualImprovements --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named description --type String
jpa-new-field --named causesAnalysis --type String
jpa-new-field --named rootCause --type String
jpa-new-field --named immediateCorrection --type String
jpa-new-field --named dateCorrection --type java.util.Date --temporalType TIMESTAMP

#  ActionPlans entity
#  ############
jpa-new-entity --named ActionPlans --targetPackage co.simasoft.models
jpa-new-field --named scheduledDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named evidences --type String
jpa-new-field --named trackingDate --type java.util.Date --temporalType TIMESTAMP

#  ImprovementVerifications entity
#  ############
jpa-new-entity --named ImprovementVerifications --targetPackage co.simasoft.models
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP

#  ImprovementClosures entity
#  ############
jpa-new-entity --named ImprovementClosures --targetPackage co.simasoft.models
jpa-new-field --named dateClosing --type java.util.Date --temporalType TIMESTAMP

#  ClosingActivities entity
#  ############
jpa-new-entity --named ClosingActivities --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named isSiorNo --type Boolean

#  ItemsTypes entity
#  ############
jpa-new-entity --named ItemsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  ItemsNames entity
#  ############
jpa-new-entity --named ItemsNames --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named model --type String
jpa-new-field --named productNumber --type String
jpa-new-field --named partNumber --type String

#  Items entity
#  ############
jpa-new-entity --named Items --targetPackage co.simasoft.models
jpa-new-field --named cvNumber --type String
jpa-new-field --named code --type String
jpa-new-field --named inventoryCode --type String
jpa-new-field --named serial --type String
jpa-new-field --named eanCode --type String
jpa-new-field --named expirationDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named warrantyDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named minStock --type Integer
jpa-new-field --named maxStock --type Integer
jpa-new-field --named quantity --type Integer
jpa-new-field --named located --type String

#  ItemsStates entity
#  ############
jpa-new-entity --named ItemsStates --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  HostsTypes entity
#  ############
jpa-new-entity --named HostsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Hosts entity
#  ############
jpa-new-entity --named Hosts --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  NetworkPorts entity
#  ############
jpa-new-entity --named NetworkPorts --targetPackage co.simasoft.models
jpa-new-field --named macAddress --type String
jpa-new-field --named ipAddress --type String
jpa-new-field --named state --type String

#  PatchPanelsPorts entity
#  ############
jpa-new-entity --named PatchPanelsPorts --targetPackage co.simasoft.models
jpa-new-field --named port --type String
jpa-new-field --named code --type String
jpa-new-field --named mts --type Integer

#  SwitchesPorts entity
#  ############
jpa-new-entity --named SwitchesPorts --targetPackage co.simasoft.models
jpa-new-field --named port --type String
jpa-new-field --named code --type String
jpa-new-field --named state --type String
jpa-new-field --named mts --type Integer

#  Vlans entity
#  ############
jpa-new-entity --named Vlans --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named ipMask --type String
jpa-new-field --named ipGateway --type String

#  Persons entity
#  ############
jpa-new-entity --named Persons --targetPackage co.simasoft.models
jpa-new-field --named firstName --type String
jpa-new-field --named secondName --type String
jpa-new-field --named firstLastName --type String
jpa-new-field --named secondLastName --type String
jpa-new-field --named email --type String
jpa-new-field --named mobile --type String
jpa-new-field --named telephone --type String
jpa-new-field --named skipe --type String
jpa-new-field --named address --type String

#  PhysicalAreas entity
#  ############
jpa-new-entity --named PhysicalAreas --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named telExt --type String

#  SitesTypes entity
#  ############
jpa-new-entity --named SitesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Sites entity
#  ############
jpa-new-entity --named Sites --targetPackage co.simasoft.models
jpa-new-field --named title --type String
jpa-new-field --named link --type String
jpa-new-field --named abc --type String
jpa-new-field --named ipAddress1 --type String
jpa-new-field --named ipAddress2 --type String
jpa-new-field --named ipAddress3 --type String

#  ActivitiesTypes entity
#  ############
jpa-new-entity --named ActivitiesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Activities entity
#  ############
jpa-new-entity --named Activities --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Calendars entity
#  ############
jpa-new-entity --named Calendars --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Tasks entity
#  ############
jpa-new-entity --named Tasks --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named optimisticDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named pessimisticDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named startDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named finalDate --type java.util.Date --temporalType TIMESTAMP

#  Priorities entity
#  ############
jpa-new-entity --named Priorities --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Diaries entity
#  ############
jpa-new-entity --named Diaries --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named date --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named description --type String

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
#  DocumentalsUnits Uno a Muchos Bidirecccional No.5 ContinualImprovements
cd ..
cd DocumentalsUnits.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType One-to-Many;

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
#  OriginalOrders Muchos a Uno Unidireccional No.3 ContinualImprovements
cd ..
cd OriginalOrders.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType Many-to-One;

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

#  BooksTypes Relationships 
#  ############
#  ############1..*
#  BooksTypes Uno a Muchos Bidirecccional No.5 Books
cd ..
cd BooksTypes.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType One-to-Many;

#  ############1..*
#Unitaria  BooksTypes Uno a Muchos Bidirecccional No.5 BooksTypes
cd ..
cd BooksTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.BooksTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  BooksTypes Muchos a Uno Unidireccional No.3 BooksTypes
cd ..
cd BooksTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.BooksTypes --relationshipType Many-to-One;

#  Books Relationships 
#  ############
#  ############1..*
#  Books Uno a Muchos Bidirecccional No.5 Activities
cd ..
cd Books.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType One-to-Many;

#  ############1..*
#  Books Uno a Muchos Bidirecccional No.5 Chapters
cd ..
cd Books.java
jpa-new-field --named chapters --type co.simasoft.models.Chapters --relationshipType One-to-Many;

#  ############*..1
#  Books Muchos a Uno Unidireccional No.3 BooksTypes
cd ..
cd Books.java
jpa-new-field --named booksTypes --type co.simasoft.models.BooksTypes --relationshipType Many-to-One;

#  Chapters Relationships 
#  ############
#  ############1..*
#  Chapters Uno a Muchos Bidirecccional No.5 Diaries
cd ..
cd Chapters.java
jpa-new-field --named diaries --type co.simasoft.models.Diaries --relationshipType One-to-Many;

#  ############1..*
#  Chapters Uno a Muchos Bidirecccional No.5 Tasks
cd ..
cd Chapters.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType One-to-Many;

#  ############1..*
#Unitaria  Chapters Uno a Muchos Bidirecccional No.5 Chapters
cd ..
cd Chapters.java
jpa-new-field --named objHijos --type co.simasoft.models.Chapters --relationshipType One-to-Many;

#  ############*..1
#  Chapters Muchos a Uno Unidireccional No.3 Books
cd ..
cd Chapters.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType Many-to-One;

#  ############*..1
#Unitaria  Chapters Muchos a Uno Unidireccional No.3 Chapters
cd ..
cd Chapters.java
jpa-new-field --named objPadre --type co.simasoft.models.Chapters --relationshipType Many-to-One;

#  Brands Relationships 
#  ############
#  ############*..*
#  Brands Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Brands.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName brands;

#  ############*..1
#  Brands Muchos a Uno Unidireccional No.3 Companies
cd ..
cd Brands.java
jpa-new-field --named companies --type co.simasoft.models.Companies --relationshipType Many-to-One;

#  Companies Relationships 
#  ############
#  ############1..*
#  Companies Uno a Muchos Bidirecccional No.5 Funds
cd ..
cd Companies.java
jpa-new-field --named funds --type co.simasoft.models.Funds --relationshipType One-to-Many;

#  ############*..*
#  Companies Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Companies.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName companies;

#  ############1..*
#  Companies Uno a Muchos Bidirecccional No.5 Brands
cd ..
cd Companies.java
jpa-new-field --named brands --type co.simasoft.models.Brands --relationshipType One-to-Many;

#  ############1..*
#  Companies Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd Companies.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  ############1..*
#Unitaria  Companies Uno a Muchos Bidirecccional No.5 Companies
cd ..
cd Companies.java
jpa-new-field --named objHijos --type co.simasoft.models.Companies --relationshipType One-to-Many;

#  ############*..1
#Unitaria  Companies Muchos a Uno Unidireccional No.3 Companies
cd ..
cd Companies.java
jpa-new-field --named objPadre --type co.simasoft.models.Companies --relationshipType Many-to-One;

#  EmployeesTypes Relationships 
#  ############
#  ############1..*
#  EmployeesTypes Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd EmployeesTypes.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  Employees Relationships 
#  ############
#  ############*..*
#  Employees Muchos a Muchos Bidirecccional No.7 Charges
cd ..
cd Employees.java
jpa-new-field --named charges --type co.simasoft.models.Charges --relationshipType Many-to-Many  ----inverseFieldName employees;

#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Employees.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 EmployeesTypes
cd ..
cd Employees.java
jpa-new-field --named employeesTypes --type co.simasoft.models.EmployeesTypes --relationshipType Many-to-One;

#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 Companies
cd ..
cd Employees.java
jpa-new-field --named companies --type co.simasoft.models.Companies --relationshipType Many-to-One;

#  CompaniesRolesTypes Relationships 
#  ############
#  ############1..*
#  CompaniesRolesTypes Uno a Muchos Bidirecccional No.5 CompaniesRoles
cd ..
cd CompaniesRolesTypes.java
jpa-new-field --named companiesRoles --type co.simasoft.models.CompaniesRoles --relationshipType One-to-Many;

#  ############1..*
#Unitaria  CompaniesRolesTypes Uno a Muchos Bidirecccional No.5 CompaniesRolesTypes
cd ..
cd CompaniesRolesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.CompaniesRolesTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  CompaniesRolesTypes Muchos a Uno Unidireccional No.3 CompaniesRolesTypes
cd ..
cd CompaniesRolesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.CompaniesRolesTypes --relationshipType Many-to-One;

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

#  ############*..*
#  CompaniesRoles Muchos a Muchos Unidireccional No.6 Charges
cd ..
cd CompaniesRoles.java
jpa-new-field --named charges --type co.simasoft.models.Charges --relationshipType Many-to-Many  ----inverseFieldName companiesRoles;

#  ############*..1
#  CompaniesRoles Muchos a Uno Unidireccional No.3 CompaniesRolesTypes
cd ..
cd CompaniesRoles.java
jpa-new-field --named companiesRolesTypes --type co.simasoft.models.CompaniesRolesTypes --relationshipType Many-to-One;

#  ChargesTypes Relationships 
#  ############
#  ############1..*
#  ChargesTypes Uno a Muchos Bidirecccional No.5 Charges
cd ..
cd ChargesTypes.java
jpa-new-field --named charges --type co.simasoft.models.Charges --relationshipType One-to-Many;

#  ############1..*
#Unitaria  ChargesTypes Uno a Muchos Bidirecccional No.5 ChargesTypes
cd ..
cd ChargesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.ChargesTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  ChargesTypes Muchos a Uno Unidireccional No.3 ChargesTypes
cd ..
cd ChargesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.ChargesTypes --relationshipType Many-to-One;

#  Charges Relationships 
#  ############
#  ############*..*
#  Charges Muchos a Muchos Bidirecccional No.7 CompaniesRoles
cd ..
cd Charges.java
jpa-new-field --named companiesRoles --type co.simasoft.models.CompaniesRoles --relationshipType Many-to-Many  ----inverseFieldName charges;

#  ############*..1
#  Charges Muchos a Uno Unidireccional No.3 ChargesTypes
cd ..
cd Charges.java
jpa-new-field --named chargesTypes --type co.simasoft.models.ChargesTypes --relationshipType Many-to-One;

#  ############*..*
#  Charges Muchos a Muchos Unidireccional No.6 Employees
cd ..
cd Charges.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType Many-to-Many  ----inverseFieldName charges;

#  ImprovementTypes Relationships 
#  ############
#  ############1..*
#  ImprovementTypes Uno a Muchos Bidirecccional No.5 ContinualImprovements
cd ..
cd ImprovementTypes.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType One-to-Many;

#  ImprovementSources Relationships 
#  ############
#  ############1..*
#  ImprovementSources Uno a Muchos Bidirecccional No.5 ContinualImprovements
cd ..
cd ImprovementSources.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType One-to-Many;

#  ContinualImprovements Relationships 
#  ############
#  ############1..*
#  ContinualImprovements Uno a Muchos Bidirecccional No.5 OriginalOrders
cd ..
cd ContinualImprovements.java
jpa-new-field --named originalOrders --type co.simasoft.models.OriginalOrders --relationshipType One-to-Many;

#  ############1..*
#  ContinualImprovements Uno a Muchos Bidirecccional No.5 ActionPlans
cd ..
cd ContinualImprovements.java
jpa-new-field --named actionPlans --type co.simasoft.models.ActionPlans --relationshipType One-to-Many;

#  ############*..1
#  ContinualImprovements Muchos a Uno Unidireccional No.3 DocumentalsUnits
cd ..
cd ContinualImprovements.java
jpa-new-field --named documentalsUnits --type co.simasoft.models.DocumentalsUnits --relationshipType Many-to-One;

#  ############*..1
#  ContinualImprovements Muchos a Uno Unidireccional No.3 ImprovementClosures
cd ..
cd ContinualImprovements.java
jpa-new-field --named improvementClosures --type co.simasoft.models.ImprovementClosures --relationshipType Many-to-One;

#  ############*..1
#  ContinualImprovements Muchos a Uno Unidireccional No.3 ImprovementTypes
cd ..
cd ContinualImprovements.java
jpa-new-field --named improvementTypes --type co.simasoft.models.ImprovementTypes --relationshipType Many-to-One;

#  ############*..1
#  ContinualImprovements Muchos a Uno Unidireccional No.3 ImprovementSources
cd ..
cd ContinualImprovements.java
jpa-new-field --named improvementSources --type co.simasoft.models.ImprovementSources --relationshipType Many-to-One;

#  ############*..1
#  ContinualImprovements Muchos a Uno Unidireccional No.3 ImprovementVerifications
cd ..
cd ContinualImprovements.java
jpa-new-field --named improvementVerifications --type co.simasoft.models.ImprovementVerifications --relationshipType Many-to-One;

#  ActionPlans Relationships 
#  ############
#  ############*..1
#  ActionPlans Muchos a Uno Unidireccional No.3 ContinualImprovements
cd ..
cd ActionPlans.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType Many-to-One;

#  ImprovementVerifications Relationships 
#  ############
#  ############1..*
#  ImprovementVerifications Uno a Muchos Bidirecccional No.5 ContinualImprovements
cd ..
cd ImprovementVerifications.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType One-to-Many;

#  ImprovementClosures Relationships 
#  ############
#  ############1..*
#  ImprovementClosures Uno a Muchos Bidirecccional No.5 ClosingActivities
cd ..
cd ImprovementClosures.java
jpa-new-field --named closingActivities --type co.simasoft.models.ClosingActivities --relationshipType One-to-Many;

#  ############1..*
#  ImprovementClosures Uno a Muchos Bidirecccional No.5 ContinualImprovements
cd ..
cd ImprovementClosures.java
jpa-new-field --named continualImprovements --type co.simasoft.models.ContinualImprovements --relationshipType One-to-Many;

#  ClosingActivities Relationships 
#  ############
#  ############*..1
#  ClosingActivities Muchos a Uno Unidireccional No.3 ImprovementClosures
cd ..
cd ClosingActivities.java
jpa-new-field --named improvementClosures --type co.simasoft.models.ImprovementClosures --relationshipType Many-to-One;

#  ItemsTypes Relationships 
#  ############
#  ############1..*
#Unitaria  ItemsTypes Uno a Muchos Bidirecccional No.5 ItemsTypes
cd ..
cd ItemsTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.ItemsTypes --relationshipType One-to-Many;

#  ############1..*
#  ItemsTypes Uno a Muchos Bidirecccional No.5 ItemsNames
cd ..
cd ItemsTypes.java
jpa-new-field --named itemsNames --type co.simasoft.models.ItemsNames --relationshipType One-to-Many;

#  ############*..1
#Unitaria  ItemsTypes Muchos a Uno Unidireccional No.3 ItemsTypes
cd ..
cd ItemsTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.ItemsTypes --relationshipType Many-to-One;

#  ItemsNames Relationships 
#  ############
#  ############1..*
#  ItemsNames Uno a Muchos Bidirecccional No.5 Items
cd ..
cd ItemsNames.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType One-to-Many;

#  ############*..1
#  ItemsNames Muchos a Uno Unidireccional No.3 ItemsTypes
cd ..
cd ItemsNames.java
jpa-new-field --named itemsTypes --type co.simasoft.models.ItemsTypes --relationshipType Many-to-One;

#  Items Relationships 
#  ############
#  ############1..*
#  Items Uno a Muchos Bidirecccional No.5 Hosts
cd ..
cd Items.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType One-to-Many;

#  ############1..*
#Unitaria  Items Uno a Muchos Bidirecccional No.5 Items
cd ..
cd Items.java
jpa-new-field --named objHijos --type co.simasoft.models.Items --relationshipType One-to-Many;

#  ############*..1
#  Items Muchos a Uno Unidireccional No.3 PhysicalAreas
cd ..
cd Items.java
jpa-new-field --named physicalAreas --type co.simasoft.models.PhysicalAreas --relationshipType Many-to-One;

#  ############*..1
#  Items Muchos a Uno Unidireccional No.3 ItemsNames
cd ..
cd Items.java
jpa-new-field --named itemsNames --type co.simasoft.models.ItemsNames --relationshipType Many-to-One;

#  ############*..1
#  Items Muchos a Uno Unidireccional No.3 ItemsStates
cd ..
cd Items.java
jpa-new-field --named itemsStates --type co.simasoft.models.ItemsStates --relationshipType Many-to-One;

#  ############*..1
#Unitaria  Items Muchos a Uno Unidireccional No.3 Items
cd ..
cd Items.java
jpa-new-field --named objPadre --type co.simasoft.models.Items --relationshipType Many-to-One;

#  ItemsStates Relationships 
#  ############
#  ############1..*
#  ItemsStates Uno a Muchos Bidirecccional No.5 Items
cd ..
cd ItemsStates.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType One-to-Many;

#  HostsTypes Relationships 
#  ############
#  ############1..*
#  HostsTypes Uno a Muchos Bidirecccional No.5 Hosts
cd ..
cd HostsTypes.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType One-to-Many;

#  Hosts Relationships 
#  ############
#  ############1..*
#  Hosts Uno a Muchos Bidirecccional No.5 NetworkPorts
cd ..
cd Hosts.java
jpa-new-field --named networkPorts --type co.simasoft.models.NetworkPorts --relationshipType One-to-Many;

#  ############1..*
#  Hosts Uno a Muchos Bidirecccional No.5 PatchPanelsPorts
cd ..
cd Hosts.java
jpa-new-field --named patchPanelsPorts --type co.simasoft.models.PatchPanelsPorts --relationshipType One-to-Many;

#  ############1..*
#  Hosts Uno a Muchos Bidirecccional No.5 SwitchesPorts
cd ..
cd Hosts.java
jpa-new-field --named switchesPorts --type co.simasoft.models.SwitchesPorts --relationshipType One-to-Many;

#  ############*..1
#  Hosts Muchos a Uno Unidireccional No.3 Items
cd ..
cd Hosts.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType Many-to-One;

#  ############*..1
#  Hosts Muchos a Uno Unidireccional No.3 HostsTypes
cd ..
cd Hosts.java
jpa-new-field --named hostsTypes --type co.simasoft.models.HostsTypes --relationshipType Many-to-One;

#  NetworkPorts Relationships 
#  ############
#  ############*..*
#  NetworkPorts Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd NetworkPorts.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName networkPorts;

#  ############*..1
#  NetworkPorts Muchos a Uno Unidireccional No.3 PatchPanelsPorts
cd ..
cd NetworkPorts.java
jpa-new-field --named patchPanelsPorts --type co.simasoft.models.PatchPanelsPorts --relationshipType Many-to-One;

#  ############*..1
#  NetworkPorts Muchos a Uno Unidireccional No.3 Hosts
cd ..
cd NetworkPorts.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType Many-to-One;

#  PatchPanelsPorts Relationships 
#  ############
#  ############1..*
#  PatchPanelsPorts Uno a Muchos Bidirecccional No.5 NetworkPorts
cd ..
cd PatchPanelsPorts.java
jpa-new-field --named networkPorts --type co.simasoft.models.NetworkPorts --relationshipType One-to-Many;

#  ############*..1
#  PatchPanelsPorts Muchos a Uno Unidireccional No.3 SwitchesPorts
cd ..
cd PatchPanelsPorts.java
jpa-new-field --named switchesPorts --type co.simasoft.models.SwitchesPorts --relationshipType Many-to-One;

#  ############*..1
#  PatchPanelsPorts Muchos a Uno Unidireccional No.3 Hosts
cd ..
cd PatchPanelsPorts.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType Many-to-One;

#  SwitchesPorts Relationships 
#  ############
#  ############1..*
#  SwitchesPorts Uno a Muchos Bidirecccional No.5 PatchPanelsPorts
cd ..
cd SwitchesPorts.java
jpa-new-field --named patchPanelsPorts --type co.simasoft.models.PatchPanelsPorts --relationshipType One-to-Many;

#  ############*..1
#  SwitchesPorts Muchos a Uno Unidireccional No.3 Vlans
cd ..
cd SwitchesPorts.java
jpa-new-field --named vlans --type co.simasoft.models.Vlans --relationshipType Many-to-One;

#  ############*..1
#  SwitchesPorts Muchos a Uno Unidireccional No.3 Hosts
cd ..
cd SwitchesPorts.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType Many-to-One;

#  Vlans Relationships 
#  ############
#  ############1..*
#  Vlans Uno a Muchos Bidirecccional No.5 SwitchesPorts
cd ..
cd Vlans.java
jpa-new-field --named switchesPorts --type co.simasoft.models.SwitchesPorts --relationshipType One-to-Many;

#  Persons Relationships 
#  ############
#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Tasks
cd ..
cd Persons.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType One-to-Many;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Activities
cd ..
cd Persons.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType One-to-Many;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd Persons.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  PhysicalAreas Relationships 
#  ############
#  ############1..*
#  PhysicalAreas Uno a Muchos Bidirecccional No.5 Items
cd ..
cd PhysicalAreas.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType One-to-Many;

#  SitesTypes Relationships 
#  ############
#  ############1..*
#Unitaria  SitesTypes Uno a Muchos Bidirecccional No.5 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.SitesTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  SitesTypes Muchos a Uno Unidireccional No.3 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  ############*..*
#  SitesTypes Muchos a Muchos Unidireccional No.6 Sites
cd ..
cd SitesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#  Sites Relationships 
#  ############
#  ############*..*
#  Sites Muchos a Muchos Bidirecccional No.7 SitesTypes
cd ..
cd Sites.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Unidireccional No.6 Tasks
cd ..
cd Sites.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Unidireccional No.6 Diaries
cd ..
cd Sites.java
jpa-new-field --named diaries --type co.simasoft.models.Diaries --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Unidireccional No.6 Activities
cd ..
cd Sites.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Unidireccional No.6 NetworkPorts
cd ..
cd Sites.java
jpa-new-field --named networkPorts --type co.simasoft.models.NetworkPorts --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Unidireccional No.6 Companies
cd ..
cd Sites.java
jpa-new-field --named companies --type co.simasoft.models.Companies --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Unidireccional No.6 Brands
cd ..
cd Sites.java
jpa-new-field --named brands --type co.simasoft.models.Brands --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ActivitiesTypes Relationships 
#  ############
#  ############1..*
#  ActivitiesTypes Uno a Muchos Bidirecccional No.5 Activities
cd ..
cd ActivitiesTypes.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType One-to-Many;

#  Activities Relationships 
#  ############
#  ############1..*
#Unitaria  Activities Uno a Muchos Bidirecccional No.5 Activities
cd ..
cd Activities.java
jpa-new-field --named objHijos --type co.simasoft.models.Activities --relationshipType One-to-Many;

#  ############*..*
#  Activities Muchos a Muchos Bidirecccional No.7 Calendars
cd ..
cd Activities.java
jpa-new-field --named calendars --type co.simasoft.models.Calendars --relationshipType Many-to-Many  ----inverseFieldName activities;

#  ############1..*
#  Activities Uno a Muchos Bidirecccional No.5 Tasks
cd ..
cd Activities.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType One-to-Many;

#  ############*..*
#  Activities Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Activities.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName activities;

#  ############*..1
#  Activities Muchos a Uno Unidireccional No.3 Books
cd ..
cd Activities.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType Many-to-One;

#  ############*..1
#  Activities Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Activities.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ############*..1
#Unitaria  Activities Muchos a Uno Unidireccional No.3 Activities
cd ..
cd Activities.java
jpa-new-field --named objPadre --type co.simasoft.models.Activities --relationshipType Many-to-One;

#  ############*..1
#  Activities Muchos a Uno Unidireccional No.3 ActivitiesTypes
cd ..
cd Activities.java
jpa-new-field --named activitiesTypes --type co.simasoft.models.ActivitiesTypes --relationshipType Many-to-One;

#  ############*..1
#  Activities Muchos a Uno Unidireccional No.3 Sections
cd ..
cd Activities.java
jpa-new-field --named sections --type co.simasoft.models.Sections --relationshipType Many-to-One;

#  Calendars Relationships 
#  ############
#  ############*..*
#  Calendars Muchos a Muchos Unidireccional No.6 Activities
cd ..
cd Calendars.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType Many-to-Many  ----inverseFieldName calendars;

#  Tasks Relationships 
#  ############
#  ############1..*
#  Tasks Uno a Muchos Bidirecccional No.5 Diaries
cd ..
cd Tasks.java
jpa-new-field --named diaries --type co.simasoft.models.Diaries --relationshipType One-to-Many;

#  ############*..*
#  Tasks Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Tasks.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName tasks;

#  ############*..1
#  Tasks Muchos a Uno Unidireccional No.3 Chapters
cd ..
cd Tasks.java
jpa-new-field --named chapters --type co.simasoft.models.Chapters --relationshipType Many-to-One;

#  ############*..1
#  Tasks Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Tasks.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ############*..1
#  Tasks Muchos a Uno Unidireccional No.3 Activities
cd ..
cd Tasks.java
jpa-new-field --named activities --type co.simasoft.models.Activities --relationshipType Many-to-One;

#  ############*..1
#  Tasks Muchos a Uno Unidireccional No.3 Priorities
cd ..
cd Tasks.java
jpa-new-field --named priorities --type co.simasoft.models.Priorities --relationshipType Many-to-One;

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

#  Priorities Relationships 
#  ############
#  ############1..*
#  Priorities Uno a Muchos Bidirecccional No.5 Tasks
cd ..
cd Priorities.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType One-to-Many;

#  Diaries Relationships 
#  ############
#  ############*..*
#  Diaries Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Diaries.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName diaries;

#  ############*..1
#  Diaries Muchos a Uno Unidireccional No.3 Chapters
cd ..
cd Diaries.java
jpa-new-field --named chapters --type co.simasoft.models.Chapters --relationshipType Many-to-One;

#  ############*..1
#  Diaries Muchos a Uno Unidireccional No.3 Tasks
cd ..
cd Diaries.java
jpa-new-field --named tasks --type co.simasoft.models.Tasks --relationshipType Many-to-One;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
