scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wbooks
jpa-setup
scaffold-setup --provider AngularJS

#  BooksTypes entity
#  ############
jpa-new-entity --named BooksTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  SitesTypes entity
#  ############
jpa-new-entity --named SitesTypes --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Chapters entity
#  ############
jpa-new-entity --named Chapters --targetPackage co.simasoft.models
jpa-new-field --named code --type String
jpa-new-field --named name --type String

#  Books entity
#  ############
jpa-new-entity --named Books --targetPackage co.simasoft.models
jpa-new-field --named code --type String
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

#  BooksTypes Relationships 
#  ############
#  ############1..*
#Unitaria  BooksTypes Uno a Muchos Bidirecccional No.5 BooksTypes
cd ..
cd BooksTypes.java
jpa-new-field --named objHijos --type co.simasoft.models.BooksTypes --relationshipType One-to-Many;

#  ############1..*
#  BooksTypes Uno a Muchos Bidirecccional No.5 Books
cd ..
cd BooksTypes.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType One-to-Many;

#  ############*..1
#Unitaria  BooksTypes Muchos a Uno Unidireccional No.3 BooksTypes
cd ..
cd BooksTypes.java
jpa-new-field --named objPadre --type co.simasoft.models.BooksTypes --relationshipType Many-to-One;

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
#  SitesTypes Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd SitesTypes.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#  ############*..*
#  SitesTypes Muchos a Muchos Bidirecccional No.7 Books
cd ..
cd SitesTypes.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType Many-to-Many  ----inverseFieldName sitesTypes;

#  Chapters Relationships 
#  ############
#  ############1..*
#Unitaria  Chapters Uno a Muchos Bidirecccional No.5 Chapters
cd ..
cd Chapters.java
jpa-new-field --named objHijos --type co.simasoft.models.Chapters --relationshipType One-to-Many;

#  ############*..*
#  Chapters Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Chapters.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName chapters;

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

#  Books Relationships 
#  ############
#  ############1..*
#  Books Uno a Muchos Bidirecccional No.5 Chapters
cd ..
cd Books.java
jpa-new-field --named chapters --type co.simasoft.models.Chapters --relationshipType One-to-Many;

#  ############*..*
#  Books Muchos a Muchos Bidirecccional No.7 SitesTypes
cd ..
cd Books.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-Many  ----inverseFieldName books;

#  ############*..*
#  Books Muchos a Muchos Bidirecccional No.7 Sites
cd ..
cd Books.java
jpa-new-field --named sites --type co.simasoft.models.Sites --relationshipType Many-to-Many  ----inverseFieldName books;

#  ############*..1
#  Books Muchos a Uno Unidireccional No.3 BooksTypes
cd ..
cd Books.java
jpa-new-field --named booksTypes --type co.simasoft.models.BooksTypes --relationshipType Many-to-One;

#  Sites Relationships 
#  ############
#  ############*..*
#  Sites Muchos a Muchos Bidirecccional No.7 SitesTypes
cd ..
cd Sites.java
jpa-new-field --named sitesTypes --type co.simasoft.models.SitesTypes --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Bidirecccional No.7 Chapters
cd ..
cd Sites.java
jpa-new-field --named chapters --type co.simasoft.models.Chapters --relationshipType Many-to-Many  ----inverseFieldName sites;

#  ############*..*
#  Sites Muchos a Muchos Bidirecccional No.7 Books
cd ..
cd Sites.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType Many-to-Many  ----inverseFieldName sites;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
