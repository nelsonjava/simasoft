scaffold-setup --provider Faces
scaffold-generate --web-root /admin --provider Faces --targets co.simasoft.models.*;
project-new --named wrelationships2
jpa-setup
scaffold-setup --provider AngularJS

#  Hosts entity
#  ############
jpa-new-entity --named Hosts --targetPackage co.simasoft.models
jpa-new-field --named name --type String

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

#  Hosts Relationships 
#  ############
#  Hosts Uno a Uno Unidireccional No.1 Items
#  Items Relationships 
#  ############
#  Items Uno a Uno Bidirecccional No.2 Hosts
rest-generate-endpoints-from-entities --targets co.simasoft.models.*
