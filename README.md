# KC Business

*Work in Progress*

## Setup

1. Create a new database and set up a database user for it.
    * You can use the command line or a GUI tool like MySQL Workbench to create the database and user.

2. Set up the following environment variables:
    * **PORT**  - The server port to run on
    * **DB_URL** - The URL of the database to connect to, including the port number and database name (e.g. `jdbc:mysql://localhost:3306/kcbusiness`)
    * **DB_USERNAME** - The username of the database user you created in step 1
    * **DB_PASSWORD** - The password of the database user you created in step 1
   * **JWT_SECRET** - A secret string that will be used to sign JWTs. For example, `jwtsecretkey#123`
    * You can set these variables in different ways, depending on your Operating System and shell, like in Windows you can use set command, in Linux you can use export command.
    * Alternatively, for development you may be able to set up the environment variables using your IDE.
