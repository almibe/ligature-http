# ligatureLab
*A breadboard for linked data.*

LigatureLab is a web application that helps users work with Ligature's data model.

## Note
This project is very new and very much under development and design.
For now assume that all apis are temporary and will change in the future.
That said, this document will be kept up to date with the current api that is implemented.

## Running
This project requires SBT to be installed.
On Linux/Mac I recommend using https://sdkman.io/ to manage SBT installs.
Once that is set up use `sbt test` to run tests `sbt run` to run the server.
Ligature requires that an auth mode argument be passed at start up, see list below.

## Auth Modes
Ligature plans to support multiple auth modes.
Currently, only the `local-dev-no-auth` mode is implemented but below is documentation on additional modes that will be added soon.

 * `--local-dev-no-auth` - Allows easy local development with no authentication but explicitly checks that all traffic comes on localhost
 * `--basic-auth` - Uses HTTP's basic auth mechanism.
 * `--jwt-auth` - Allows use of JWT for working with the API.
 
Additional auth modes may be added later (probably OpenID Connect), but these are the initial ones that are planned.

## API

Below is documentation for ligature-server's api.
These are not set in stone by any means and all will likely change.

### Create Collection

PUT to ligature/collectionName
Returns 201 if new collection is created
Returns 200 if the collection already existed
Returns 401 if user can't create resource
TODO other possible error codes

### List Collections

GET to ligature/_collections
TODO return values

### Delete Collection

DELETE to ligature/collectionName
TODO return values

### Add Statement

POST to ligature/collectionName
TODO return values + bodies

### Get All Statements

GET to ligature/collectionName
TODO return values

### Remove Statement

DELETE to ligature/collectionName
TODO return values + bodies

### Query Statements

GET to ligature/collectionName
TODO return values + bodies
