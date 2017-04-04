scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wbooks
jpa-setup
scaffold-setup --provider AngularJS

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

#  TypesFilms entity
#  ############
jpa-new-entity --named TypesFilms --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Films entity
#  ############
jpa-new-entity --named Films --targetPackage co.simasoft.models
jpa-new-field --named name --type String

#  Videos entity
#  ############
jpa-new-entity --named Videos --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named time --type String

#  VideoContents entity
#  ############
jpa-new-entity --named VideoContents --targetPackage co.simasoft.models
jpa-new-field --named name --type String
jpa-new-field --named startTime --type String
jpa-new-field --named endTime --type String

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
#  ############*..*
#  Books Muchos a Muchos Bidirecccional No.7 Films
cd ..
cd Books.java
jpa-new-field --named films --type co.simasoft.models.Films --relationshipType Many-to-Many  ----inverseFieldName books;

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
#  ############*..*
#  Chapters Muchos a Muchos Bidirecccional No.7 VideoContents
cd ..
cd Chapters.java
jpa-new-field --named videoContents --type co.simasoft.models.VideoContents --relationshipType Many-to-Many  ----inverseFieldName chapters;

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

#  TypesFilms Relationships 
#  ############
#  ############1..*
#  TypesFilms Uno a Muchos Bidirecccional No.5 Films
cd ..
cd TypesFilms.java
jpa-new-field --named films --type co.simasoft.models.Films --relationshipType One-to-Many;

#  Films Relationships 
#  ############
#  ############1..*
#  Films Uno a Muchos Bidirecccional No.5 Videos
cd ..
cd Films.java
jpa-new-field --named videos --type co.simasoft.models.Videos --relationshipType One-to-Many;

#  ############*..1
#  Films Muchos a Uno Unidireccional No.3 TypesFilms
cd ..
cd Films.java
jpa-new-field --named typesFilms --type co.simasoft.models.TypesFilms --relationshipType Many-to-One;

#  ############*..*
#  Films Muchos a Muchos Unidireccional No.6 Books
cd ..
cd Films.java
jpa-new-field --named books --type co.simasoft.models.Books --relationshipType Many-to-Many  ----inverseFieldName films;

#  Videos Relationships 
#  ############
#  ############1..*
#  Videos Uno a Muchos Bidirecccional No.5 VideoContents
cd ..
cd Videos.java
jpa-new-field --named videoContents --type co.simasoft.models.VideoContents --relationshipType One-to-Many;

#  ############*..1
#  Videos Muchos a Uno Unidireccional No.3 Films
cd ..
cd Videos.java
jpa-new-field --named films --type co.simasoft.models.Films --relationshipType Many-to-One;

#  VideoContents Relationships 
#  ############
#  ############*..1
#  VideoContents Muchos a Uno Unidireccional No.3 Videos
cd ..
cd VideoContents.java
jpa-new-field --named videos --type co.simasoft.models.Videos --relationshipType Many-to-One;

#  ############*..*
#  VideoContents Muchos a Muchos Unidireccional No.6 Chapters
cd ..
cd VideoContents.java
jpa-new-field --named chapters --type co.simasoft.models.Chapters --relationshipType Many-to-Many  ----inverseFieldName videoContents;

rest-generate-endpoints-from-entities --targets co.simasoft.models.*
