clear;
echo "Generating the scaffold.";
scaffold-setup --provider AngularJS
scaffold-generate --webRoot /admin --targets co.simasoft.models.*;
scaffold-generate --web-root /admin --provider Faces --targets org.wtasks.model.*
scaffold-generate --web-root /admin --provider AngularJS --targets org.wtasks.model.*
scaffold-generate --webRoot /admin --targets org.wtasks.model.* --provider Faces



