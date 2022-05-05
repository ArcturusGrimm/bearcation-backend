In order to start the project, clone the repository and make sure everything is installed correctly from the pom file.

**Note: The application.properties file is setup for deployment and will currently not function on localhost**

Since this is the deployment version of the backend, the `application.properties` file is setup for the deployment information. It currently holds the account information for the heroku database and deployment.

If you wish to run the backend on your local host, then you must change the `application.properties` accordingly. In the folder where `application.properties` is stored, there is a file called `OLD.application.properties`. This file holds the older version of the file with the information setup to run on the local host. Simply rename the files accordingly and one can boot up the backend on the local host.

Heroku App Dashboard can be found at: [https://dashboard.heroku.com/apps/bearcation-backend](https://dashboard.heroku.com/apps/bearcation-backend)

Heroku App can be found at: [https://bearcation-backend.herokuapp.com](https://bearcation-backend.herokuapp.com)
