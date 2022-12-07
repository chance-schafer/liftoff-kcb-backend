# Liftoff KCB Backend

The Liftoff KCB Backend is a server-side application that provides a RESTful API for interacting with the Liftoff KCB database. The project uses Gradle, Spring Boot 2.7.6, and a MySQL database.

## Dependencies

To run the Liftoff KCB Backend, you will need the following:

- Gradle
- Groovy
- Spring Boot 2.7.6
- A local installation of MySQL

## Installation

To install the Liftoff KCB Backend, follow these steps:

1. Clone the repository: `git clone https://github.com/chance-schafer/liftoff-kcb-backend.git`
2. Install the dependencies: `gradle build`
3. Create a MySQL database named `liftoff_kcb` and configure the database connection settings in the `application.properties` file.
4. Run the application: `gradle bootRun`
