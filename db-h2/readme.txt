git clone https://github.com/nelsonjava/db.git
mongod --dbpath D:\javadat\mongodb-data\database
mongod --dbpath D:\javadat\mongodb-data\database --repair
http://localhost:8089/
--
db
use test
show collections
db.custumer.find() - Muestra los registros
db.custumer.remove() - Elimina los registros
db.dropDatabase()