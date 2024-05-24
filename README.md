@Sql({"/schema.sql"}) to create the tables and sequences because I encountered an error: "Sequence 'PRODUCT_ID_SEQ' not found."
This annotation ensures that the SQL script is executed once before the Spring Boot JUnit test class runs.
