scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wpruebas
jpa-setup
scaffold-setup --provider AngularJS

#  Employees entity
#  ############
jpa-new-entity --named Employees --targetPackage co.simasoft.models
jpa-new-field --named code --type String

#  Predio entity
#  ############
jpa-new-entity --named Predio --targetPackage co.simasoft.models
jpa-new-field --named nomenclatura --type String
jpa-new-field --named predial --type String
jpa-new-field --named estrato --type String
jpa-new-field --named matricula --type String
jpa-new-field --named area --type Double

#  PhysicalSpaces entity
#  ############
jpa-new-entity --named PhysicalSpaces --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named telExt --type String

#  PhysicalSpacesTypes entity
#  ############
jpa-new-entity --named PhysicalSpacesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  PhysicalAreas entity
#  ############
jpa-new-entity --named PhysicalAreas --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named code --type String
jpa-new-field --named width --type Double
jpa-new-field --named high --type Double
jpa-new-field --named prof --type Double
jpa-new-field --named area --type Double
jpa-new-field --named volume --type Double

#  PhysicalAreasTypes entity
#  ############
jpa-new-entity --named PhysicalAreasTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named isSubtractArea --type Boolean

#  Employees Relationships 
#  ############
#  ############*..1
#  Employees Muchos a Uno Unidireccional No.3 PhysicalSpaces
cd ..
cd Employees.java
jpa-new-field --named physicalSpaces --type co.simasoft.models.PhysicalSpaces --relationshipType Many-to-One;

#  Predio Relationships 
#  ############
#  ############1..*
#  Predio Uno a Muchos Bidirecccional No.5 PhysicalSpaces
cd ..
cd Predio.java
jpa-new-field --named physicalSpaces --type co.simasoft.models.PhysicalSpaces --relationshipType One-to-Many;

#  ############1..*
#Unitaria  Predio Uno a Muchos Bidirecccional No.5 Predio
cd ..
cd Predio.java
jpa-new-field --named objHijos --type co.simasoft.models.Predio --relationshipType One-to-Many;

#  ############*..1
#Unitaria  Predio Muchos a Uno Unidireccional No.3 Predio
cd ..
cd Predio.java
jpa-new-field --named objPadre --type co.simasoft.models.Predio --relationshipType Many-to-One;

#  PhysicalSpaces Relationships 
#  ############
#  ############1..*
#Unitaria  PhysicalSpaces Uno a Muchos Bidirecccional No.5 PhysicalSpaces
cd ..
cd PhysicalSpaces.java
jpa-new-field --named objHijos --type co.simasoft.models.PhysicalSpaces --relationshipType One-to-Many;

#  ############*..*
#  PhysicalSpaces Muchos a Muchos Bidirecccional No.7 PhysicalAreas
cd ..
cd PhysicalSpaces.java
jpa-new-field --named physicalAreas --type co.simasoft.models.PhysicalAreas --relationshipType Many-to-Many  ----inverseFieldName physicalSpaces;

#  ############1..*
#  PhysicalSpaces Uno a Muchos Bidirecccional No.5 Employees
cd ..
cd PhysicalSpaces.java
jpa-new-field --named employees --type co.simasoft.models.Employees --relationshipType One-to-Many;

#  ############*..1
#  PhysicalSpaces Muchos a Uno Unidireccional No.3 PhysicalSpacesTypes
cd ..
cd PhysicalSpaces.java
jpa-new-field --named physicalSpacesTypes --type co.simasoft.models.PhysicalSpacesTypes --relationshipType Many-to-One;

#  ############*..1
#Unitaria  PhysicalSpaces Muchos a Uno Unidireccional No.3 PhysicalSpaces
cd ..
cd PhysicalSpaces.java
jpa-new-field --named objPadre --type co.simasoft.models.PhysicalSpaces --relationshipType Many-to-One;

#  ############*..1
#  PhysicalSpaces Muchos a Uno Unidireccional No.3 Predio
cd ..
cd PhysicalSpaces.java
jpa-new-field --named predio --type co.simasoft.models.Predio --relationshipType Many-to-One;

#  PhysicalSpacesTypes Relationships 
#  ############
#  ############1..*
#  PhysicalSpacesTypes Uno a Muchos Bidirecccional No.5 PhysicalSpaces
cd ..
cd PhysicalSpacesTypes.java
jpa-new-field --named physicalSpaces --type co.simasoft.models.PhysicalSpaces --relationshipType One-to-Many;

#  ############1..*
#Unitaria  PhysicalSpacesTypes Uno a Muchos Bidirecccional No.5 PhysicalSpacesTypes
cd ..
cd PhysicalSpacesTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.PhysicalSpacesTypes --relationshipType One-to-Many;

#  ############*..1
#Unitaria  PhysicalSpacesTypes Muchos a Uno Unidireccional No.3 PhysicalSpacesTypes
cd ..
cd PhysicalSpacesTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.PhysicalSpacesTypes --relationshipType Many-to-One;

#  PhysicalAreas Relationships 
#  ############
#  ############1..*
#Unitaria  PhysicalAreas Uno a Muchos Bidirecccional No.5 PhysicalAreas
cd ..
cd PhysicalAreas.java
jpa-new-field --named objHijos --type co.simasoft.models.PhysicalAreas --relationshipType One-to-Many;

#  ############*..*
#  PhysicalAreas Muchos a Muchos Unidireccional No.6 PhysicalSpaces
cd ..
cd PhysicalAreas.java
jpa-new-field --named physicalSpaces --type co.simasoft.models.PhysicalSpaces --relationshipType Many-to-Many  ----inverseFieldName physicalAreas;

#  ############*..1
#  PhysicalAreas Muchos a Uno Unidireccional No.3 PhysicalAreasTypes
cd ..
cd PhysicalAreas.java
jpa-new-field --named physicalAreasTypes --type co.simasoft.models.PhysicalAreasTypes --relationshipType Many-to-One;

#  ############*..1
#Unitaria  PhysicalAreas Muchos a Uno Unidireccional No.3 PhysicalAreas
cd ..
cd PhysicalAreas.java
jpa-new-field --named objPadre --type co.simasoft.models.PhysicalAreas --relationshipType Many-to-One;

#  PhysicalAreasTypes Relationships 
#  ############
#  ############1..*
#  PhysicalAreasTypes Uno a Muchos Bidirecccional No.5 PhysicalAreas
cd ..
cd PhysicalAreasTypes.java
jpa-new-field --named physicalAreas --type co.simasoft.models.PhysicalAreas --relationshipType One-to-Many;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
