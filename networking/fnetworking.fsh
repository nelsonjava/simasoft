scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wnetworking
jpa-setup
scaffold-setup --provider AngularJS

#  Hosts entity
#  ############
jpa-new-entity --named Hosts --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Address entity
#  ############
jpa-new-entity --named Address --targetPackage co.simasoft.models
jpa-new-field --named address --type String

#  Companies entity
#  ############
jpa-new-entity --named Companies --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  PatchPanelsPorts entity
#  ############
jpa-new-entity --named PatchPanelsPorts --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named mts --type Integer
jpa-new-field --named port --type String

#  Employees entity
#  ############
jpa-new-entity --named Employees --targetPackage co.simasoft.models
jpa-new-field --named code --type String

#  ItemsNames entity
#  ############
jpa-new-entity --named ItemsNames --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named model --type String
jpa-new-field --named productNumber --type String
jpa-new-field --named partNumber --type String

#  Persons entity
#  ############
jpa-new-entity --named Persons --targetPackage co.simasoft.models
jpa-new-field --named firstName --type String
jpa-new-field --named secondName --type String
jpa-new-field --named firstLastName --type String
jpa-new-field --named secondLastName --type String

#  Ids entity
#  ############
jpa-new-entity --named Ids --targetPackage co.simasoft.models
jpa-new-field --named nit --type String
jpa-new-field --named checkDigit --type String
jpa-new-field --named creationDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named isPhotocopy --type Boolean

#  Items entity
#  ############
jpa-new-entity --named Items --targetPackage co.simasoft.models
jpa-new-field --named cvNumber --type String
jpa-new-field --named located --type String
jpa-new-field --named code --type String
jpa-new-field --named inventoryCode --type String
jpa-new-field --named serial --type String
jpa-new-field --named eanCode --type String
jpa-new-field --named expirationDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named warrantyDate --type java.util.Date --temporalType TIMESTAMP
jpa-new-field --named minStock --type Integer
jpa-new-field --named maxStock --type Integer
jpa-new-field --named quantity --type Integer

#  Emails entity
#  ############
jpa-new-entity --named Emails --targetPackage co.simasoft.models
jpa-new-field --named email --type String

#  ItemsTypes entity
#  ############
jpa-new-entity --named ItemsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  EmployeesTypes entity
#  ############
jpa-new-entity --named EmployeesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  PhysicalAreas entity
#  ############
jpa-new-entity --named PhysicalAreas --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String
jpa-new-field --named telExt --type String

#  NetworkPorts entity
#  ############
jpa-new-entity --named NetworkPorts --targetPackage co.simasoft.models
jpa-new-field --named ipAddress --type String
jpa-new-field --named macAddress --type String
jpa-new-field --named state --type String

#  HostsTypes entity
#  ############
jpa-new-entity --named HostsTypes --targetPackage co.simasoft.models
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

#  SwitchesPorts entity
#  ############
jpa-new-entity --named SwitchesPorts --targetPackage co.simasoft.models
jpa-new-field --named port --type String
jpa-new-field --named code --type String
jpa-new-field --named state --type String
jpa-new-field --named mts --type Integer

#  TelephonesTypes entity
#  ############
jpa-new-entity --named TelephonesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Telephones entity
#  ############
jpa-new-entity --named Telephones --targetPackage co.simasoft.models
jpa-new-field --named telephone --type String
jpa-new-field --named isCellPhone --type Boolean

#  Brands entity
#  ############
jpa-new-entity --named Brands --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  SitesTypes entity
#  ############
jpa-new-entity --named SitesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  PositionsCompany entity
#  ############
jpa-new-entity --named PositionsCompany --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  IdsTypes entity
#  ############
jpa-new-entity --named IdsTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  PhysicalAreasTypes entity
#  ############
jpa-new-entity --named PhysicalAreasTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Vlans entity
#  ############
jpa-new-entity --named Vlans --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named ipMask --type String
jpa-new-field --named ipGateway --type String

#  ItemsStates entity
#  ############
jpa-new-entity --named ItemsStates --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Hosts Relationships 
#  ############
#  ############1..*
#  Hosts Uno a Muchos Bidirecccional No.5 NetworkPorts
cd ..
cd Hosts.java
jpa-new-field --named networkPorts --type co.simasoft.models.NetworkPorts --relationshipType One-to-Many;

#  ############1..*
#  Hosts Uno a Muchos Bidirecccional No.5 SwitchesPorts
cd ..
cd Hosts.java
jpa-new-field --named switchesPorts --type co.simasoft.models.SwitchesPorts --relationshipType One-to-Many;

#  ############1..*
#  Hosts Uno a Muchos Bidirecccional No.5 PatchPanelsPorts
cd ..
cd Hosts.java
jpa-new-field --named patchPanelsPorts --type co.simasoft.models.PatchPanelsPorts --relationshipType One-to-Many;

#  ############*..1
#  Hosts Muchos a Uno Unidireccional No.3 HostsTypes
cd ..
cd Hosts.java
jpa-new-field --named hostsTypes --type co.simasoft.models.HostsTypes --relationshipType Many-to-One;

#  ############*..1
#  Hosts Muchos a Uno Unidireccional No.3 Items
cd ..
cd Hosts.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType Many-to-One;

#  Address Relationships 
#  ############
#  ############*..*
#  Address Muchos a Muchos Unidireccional No.6 Persons
cd ..
cd Address.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-Many  ----inverseFieldName address;

#  Companies Relationships 
#  ############
#  ############1..*
#Unitaria  Companies Uno a Muchos Bidirecccional No.5 Companies
cd ..
cd Companies.java
jpa-new-field --named objHijos --type co.simasoft.models.Companies --relationshipType One-to-Many;

#  ############1..*
#  Companies Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd Companies.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  ############1..*
#  Companies Uno a Muchos Bidirecccional No.5 Brands
cd ..
cd Companies.java
jpa-new-field --named brands --type co.simasoft.models.Brands --relationshipType One-to-Many;

#  ############*..*
#  Companies Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Companies.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName companies;

#  ############*..1
#Unitaria  Companies Muchos a Uno Unidireccional No.3 Companies
cd ..
cd Companies.java
jpa-new-field --named objPadre --type co.simasoft.models.Companies --relationshipType Many-to-One;

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

#  Employees Relationships 
#  ############
#  ############1..*
#  Employees Uno a Muchos Bidirecccional No.5 PositionsCompany
cd ..
cd Employees.java
jpa-new-field --named positionsCompany --type co.simasoft.models.PositionsCompany --relationshipType One-to-Many;

#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 Companies
cd ..
cd Employees.java
jpa-new-field --named companies --type co.simasoft.models.Companies --relationshipType Many-to-One;

#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 EmployeesTypes
cd ..
cd Employees.java
jpa-new-field --named employeesTypes --type co.simasoft.models.EmployeesTypes --relationshipType Many-to-One;

#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Employees.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

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

#  Persons Relationships 
#  ############
#  ############*..*
#  Persons Muchos a Muchos Bidirecccional No.7 Address
cd ..
cd Persons.java
jpa-new-field --named address --type co.simasoft.models.Address --relationshipType Many-to-Many  ----inverseFieldName persons;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Emails
cd ..
cd Persons.java
jpa-new-field --named emails --type co.simasoft.models.Emails --relationshipType One-to-Many;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Ids
cd ..
cd Persons.java
jpa-new-field --named ids --type co.simasoft.models.Ids --relationshipType One-to-Many;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Telephones
cd ..
cd Persons.java
jpa-new-field --named telephones --type co.simasoft.models.Telephones --relationshipType One-to-Many;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 PhysicalAreas
cd ..
cd Persons.java
jpa-new-field --named physicalAreas --type co.simasoft.models.PhysicalAreas --relationshipType One-to-Many;

#  ############1..*
#  Persons Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd Persons.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  Ids Relationships 
#  ############
#  ############*..1
#  Ids Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Ids.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ############*..1
#  Ids Muchos a Uno Unidireccional No.3 IdsTypes
cd ..
cd Ids.java
jpa-new-field --named idsTypes --type co.simasoft.models.IdsTypes --relationshipType Many-to-One;

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

#  ############*..1
#  Items Muchos a Uno Unidireccional No.3 PhysicalAreas
cd ..
cd Items.java
jpa-new-field --named physicalAreas --type co.simasoft.models.PhysicalAreas --relationshipType Many-to-One;

#  Emails Relationships 
#  ############
#  ############*..1
#  Emails Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Emails.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ItemsTypes Relationships 
#  ############
#  ############1..*
#  ItemsTypes Uno a Muchos Bidirecccional No.5 ItemsNames
cd ..
cd ItemsTypes.java
jpa-new-field --named itemsNames --type co.simasoft.models.ItemsNames --relationshipType One-to-Many;

#  ############1..*
#Unitaria  ItemsTypes Uno a Muchos Bidirecccional No.5 ItemsTypes
cd ..
cd ItemsTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.ItemsTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  ItemsTypes Muchos a Uno Unidireccional No.3 ItemsTypes
cd ..
cd ItemsTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.ItemsTypes --relationshipType Many-to-One;

#  EmployeesTypes Relationships 
#  ############
#  ############1..*
#  EmployeesTypes Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd EmployeesTypes.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  PhysicalAreas Relationships 
#  ############
#  ############1..*
#  PhysicalAreas Uno a Muchos Bidirecccional No.5 Items
cd ..
cd PhysicalAreas.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType One-to-Many;

#  ############*..1
#  PhysicalAreas Muchos a Uno Unidireccional No.3 Persons
cd ..
cd PhysicalAreas.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ############*..1
#  PhysicalAreas Muchos a Uno Unidireccional No.3 PhysicalAreasTypes
cd ..
cd PhysicalAreas.java
jpa-new-field --named physicalAreasTypes --type co.simasoft.models.PhysicalAreasTypes --relationshipType Many-to-One;

#  NetworkPorts Relationships 
#  ############
#  ############*..*
#  NetworkPorts Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd NetworkPorts.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName networkPorts;

#  ############*..1
#  NetworkPorts Muchos a Uno Unidireccional No.3 Hosts
cd ..
cd NetworkPorts.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType Many-to-One;

#  ############*..1
#  NetworkPorts Muchos a Uno Unidireccional No.3 PatchPanelsPorts
cd ..
cd NetworkPorts.java
jpa-new-field --named patchPanelsPorts --type co.simasoft.models.PatchPanelsPorts --relationshipType Many-to-One;

#  HostsTypes Relationships 
#  ############
#  ############1..*
#  HostsTypes Uno a Muchos Bidirecccional No.5 Hosts
cd ..
cd HostsTypes.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType One-to-Many;

#  Sites Relationships 
#  ############
#  ############*..*
#  Sites Muchos a Muchos Bidirecccional No.7 SitesTypes
cd ..
cd Sites.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-Many  ----inverseFieldName sites;

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

#  SwitchesPorts Relationships 
#  ############
#  ############1..*
#  SwitchesPorts Uno a Muchos Bidirecccional No.5 PatchPanelsPorts
cd ..
cd SwitchesPorts.java
jpa-new-field --named patchPanelsPorts --type co.simasoft.models.PatchPanelsPorts --relationshipType One-to-Many;

#  ############*..1
#  SwitchesPorts Muchos a Uno Unidireccional No.3 Hosts
cd ..
cd SwitchesPorts.java
jpa-new-field --named hosts --type co.simasoft.models.Hosts --relationshipType Many-to-One;

#  ############*..1
#  SwitchesPorts Muchos a Uno Unidireccional No.3 Vlans
cd ..
cd SwitchesPorts.java
jpa-new-field --named vlans --type co.simasoft.models.Vlans --relationshipType Many-to-One;

#  TelephonesTypes Relationships 
#  ############
#  ############1..*
#  TelephonesTypes Uno a Muchos Bidirecccional No.5 Telephones
cd ..
cd TelephonesTypes.java
jpa-new-field --named telephones --type co.simasoft.models.Telephones --relationshipType One-to-Many;

#  Telephones Relationships 
#  ############
#  ############*..1
#  Telephones Muchos a Uno Unidireccional No.3 Persons
cd ..
cd Telephones.java
jpa-new-field --named persons --type co.simasoft.models.Persons --relationshipType Many-to-One;

#  ############*..1
#  Telephones Muchos a Uno Unidireccional No.3 TelephonesTypes
cd ..
cd Telephones.java
jpa-new-field --named telephonesTypes --type co.simasoft.models.TelephonesTypes --relationshipType Many-to-One;

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

#  SitesTypes Relationships 
#  ############
#  ############1..*
#Unitaria  SitesTypes Uno a Muchos Bidirecccional No.5 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.SitesTypes --relationshipType One-to-Many;

#  ############*..*
#  SitesTypes Muchos a Muchos Unidireccional No.6 Sites
cd ..
cd SitesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#  ############*..1
#Unitaria  SitesTypes Muchos a Uno Unidireccional No.3 SitesTypes
cd ..
cd SitesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.SitesTypes --relationshipType Many-to-One;

#  PositionsCompany Relationships 
#  ############
#  ############*..1
#  PositionsCompany Muchos a Uno Unidireccional No.3 Employees
cd ..
cd PositionsCompany.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType Many-to-One;

#  IdsTypes Relationships 
#  ############
#  ############1..*
#  IdsTypes Uno a Muchos Bidirecccional No.5 Ids
cd ..
cd IdsTypes.java
jpa-new-field --named ids --type co.simasoft.models.Ids --relationshipType One-to-Many;

#  PhysicalAreasTypes Relationships 
#  ############
#  ############1..*
#  PhysicalAreasTypes Uno a Muchos Bidirecccional No.5 PhysicalAreas
cd ..
cd PhysicalAreasTypes.java
jpa-new-field --named physicalAreas --type co.simasoft.models.PhysicalAreas --relationshipType One-to-Many;

#  ############1..*
#Unitaria  PhysicalAreasTypes Uno a Muchos Bidirecccional No.5 PhysicalAreasTypes
cd ..
cd PhysicalAreasTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.PhysicalAreasTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  PhysicalAreasTypes Muchos a Uno Unidireccional No.3 PhysicalAreasTypes
cd ..
cd PhysicalAreasTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.PhysicalAreasTypes --relationshipType Many-to-One;

#  Vlans Relationships 
#  ############
#  ############1..*
#  Vlans Uno a Muchos Bidirecccional No.5 SwitchesPorts
cd ..
cd Vlans.java
jpa-new-field --named switchesPorts --type co.simasoft.models.SwitchesPorts --relationshipType One-to-Many;

#  ItemsStates Relationships 
#  ############
#  ############1..*
#  ItemsStates Uno a Muchos Bidirecccional No.5 Items
cd ..
cd ItemsStates.java
jpa-new-field --named items --type co.simasoft.models.Items --relationshipType One-to-Many;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
