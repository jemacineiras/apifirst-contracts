# Bank Server

## Description
Demo project for Event and Contracts Testing using Spring Boot, MongoDB, and Kafka.

## Installation
1. Clone the repository:
   ```bash
   git clone https://your-repo-url.git
   ```
2. Navigate to the project directory:
   ```bash
   cd bank-server
   ```
3. Build the project using Maven:
   ```bash
   ./mvnw clean install
   ```

## Usage
Run the application:
```bash
./mvnw spring-boot:run
```

## Configuration
The application uses the following configuration files:
- [application.yml](cci:7://file:///Users/joseenrique.garcia/Developer/private/apifirst-contracts/src/main/resources/application.yml:0:0-0:0): Main configuration file.
- [application-localhost.yml](cci:7://file:///Users/joseenrique.garcia/Developer/private/apifirst-contracts/src/main/resources/application-localhost.yml:0:0-0:0): Configuration for local development.
- [application-standalone.yml](cci:7://file:///Users/joseenrique.garcia/Developer/private/apifirst-contracts/src/main/resources/application-standalone.yml:0:0-0:0): Configuration for standalone execution.

MongoDB connection details can be found in the [application.yml](cci:7://file:///Users/joseenrique.garcia/Developer/private/apifirst-contracts/src/main/resources/application.yml:0:0-0:0) file.

## Dependencies
- Spring Boot
- Spring Data MongoDB
- Spring Cloud Stream
- Kafka
- Lombok
- MapStruct

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for discussion.

## License
This project is licensed under the MIT License.