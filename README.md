# RESTassured — jsonplaceholder.typicode.com API test framework

Purpose
-------
This repository contains an API testing framework for the public demo API https://jsonplaceholder.typicode.com. The framework provides typed models for resources (posts, comments, users, albums, photos, todos), API implementation wrappers, facades and TestNG tests to validate endpoints, payloads and basic contract behavior.

Key goals:
- Maintain clear models and request DTOs for every resource.
- Provide small, reusable API client implementations and facade helpers.
- Expose deterministic factories/builders for test data generation.
- Keep tests runnable via Maven and IntelliJ with TestNG.

Tools & libraries used
----------------------
- Java (8+ / 11+ recommended)
- Maven (project build & test runner)
- RestAssured (HTTP client + assertions)
- TestNG (test runner)
- Jackson (JSON (de)serialization via model classes)
- Allure (annotations used for reporting)

Project structure (high-level)
------------------------------
- `src/main/java`
  - `api` — low-level API implementations (e.g. `PostsAPIImpl`, `CommentsAPIImpl`, `AlbumsAPIImpl`, ...)
  - `facade` — higher-level facades that wrap `*APIImpl` and return typed objects (e.g. `CommentsAPIFacade`)
  - `model` — typed models and request DTOs for every resource, organized per-resource (e.g. `model/Post`, `model/Album`, `model/Photo`, `model/Todo`)
  - `utils` — shared utilities (e.g. `SpecFactory`, `LoggingFilter`, `AuthFilter`)

- `src/test/java`
  - `tests` — TestNG tests grouped into packages (e.g. `tests.Positive`, `tests.Negative`). Tests use facades and factories to prepare, execute and assert API behavior.

- `src/test/resources`
  - `testng.xml` — suite configuration with suite-level parameters used by tests
  - `schema/` — JSON Schemas used for contract validation

How the framework is organized (conventions)
------------------------------------------
- Models: `model.<Resource>.<Resource>VO` for response objects and `...VORequest` for requests.
- Builders & factories: `*VOBuilder` and `*VORequestFactory` help create deterministic or random payloads.
- API layer: `api.*APIImpl` holds the raw REST calls using RestAssured.
- Facade layer: `facade.*APIFacade` exposes typed methods returning model objects or lists.
- Tests: rely on facades, factories and builders. Prefer facades in tests rather than calling APIImpl directly.

How to run tests
----------------
Prerequisites:
- Java JDK installed (11+ recommended)
- Maven installed (or use your IDE's Maven integration)
- (Optional) Allure CLI if you want to generate served reports locally

Run the full test suite (Maven):

```bash
# From project root
mvn test
```

Run a single TestNG suite file from IntelliJ:
- Right-click `src/test/resources/testng.xml` and choose Run
- Or create a TestNG run configuration and point it at that suite file

Run a single test class or method via Maven (Surefire):

```bash
# Run a single test class
mvn -Dtest=tests.Positive.AlbumsTest test

# Run a single test method
mvn -Dtest=tests.Positive.AlbumsTest#getAlbumById test
```

TestNG parameters and running single tests
-----------------------------------------
Some tests accept TestNG parameters via `@Parameters` and those parameters are defined in `src/test/resources/testng.xml` as suite-level `<parameter>` elements. When you run the suite XML, TestNG uses those values.

When running a single test or method from the IDE, IntelliJ creates a temporary TestNG suite that does not contain your suite-level parameters — those runs can fail if a parameter is required and not marked with `@Optional`.

Recommendations:
- To run tests with parameters consistently, run the `testng.xml` suite via Maven or create an IntelliJ TestNG run configuration that points to the suite file.
- For convenience and interactive runs, tests use `@Optional` with sensible defaults in critical places so single-method runs still work.

Allure reporting (optional)
---------------------------
Tests include Allure annotations. If you want to preview a local report after running tests, and you have the Allure CLI installed, run:

```bash
# After running mvn test
allure serve target/allure-results
```

Adapt the results directory if your build places Allure results elsewhere.


