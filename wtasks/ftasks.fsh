jpa-setup
scaffold-setup --provider AngularJS

scaffold-generate --provider AngularJS --targets org.wtasks.model.Tasks
scaffold-generate --provider AngularJS --targets org.wtasks.model.Guides
scaffold-generate --provider AngularJS --targets org.wtasks.model.Activities
scaffold-generate --provider AngularJS --targets org.wtasks.model.ActivitiesTypes
scaffold-generate --provider AngularJS --targets org.wtasks.model.Calendars
scaffold-generate --provider AngularJS --targets org.wtasks.model.Persons
scaffold-generate --provider AngularJS --targets org.wtasks.model.Sections
scaffold-generate --provider AngularJS --targets org.wtasks.model.Sites
scaffold-generate --provider AngularJS --targets org.wtasks.model.SitesTypes

rest-generate-endpoints-from-entities --targets org.wtasks.model.*
