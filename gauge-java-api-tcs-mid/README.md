# Sky Technical Test – API Automation

The aim of this test is to showcase your knowledge of working on an existing automation project.

We have built a Ruby-based API that needs testing.
The API is containerised within a Docker image and available at https://reference-tryout-api.herokuapp.com/ (*Please contact immediately if you're not able to access this.*)

Your mission is to test the API, find bugs and fix the Gauge automated tests so you could report back with your findings and the team will be aware of any issues with API or the documentation. You'll be using Markdown format for this.

Please try to complete all the tasks to the best of your ability.

## Setup

### Pre-requisites

Please make sure you have the following dependencies set up:

- Maven
- Java 8+
- Gauge - [see docs](https://docs.gauge.org/getting_started/installing-gauge.html?os=windows&language=java&ide=null)
  - Once Gauge is installed, the `java` and `html-report` plugins will also need to be installed. 
  - From cmd line/terminal run: `gauge install html-report java`
- Editor of your choice. Gauge plugins are available for JetBrains IntelliJ as well as VS Code.

## Tasks

### Part 1 - Explore the API documentation

Our developers have created a documentation for the API which can be accessed at https://reference-tryout-api.herokuapp.com however, there are some issues with it.

- Create a new file `FINDINGS.md`.
- Explore the documentation for each available route, spot any issues and document what will need to be amended with a severity order.

### Part 2 - Explore the API endpoints

Explore the API using your favourite API tool, be it `Postman`, `cURL` or `Insomnia`.

- Document any issues or discrepancies you discover in the same file created earlier.

### Part 3 - Setup Gauge Environment

If you haven't used Gauge before, we recommend reading the official documentation at `https://docs.gauge.org`.

- The project is built using Maven. Once you have `Gauge` and `Maven` installed on your machine, import the project into your favourite IDE `(IntelliJ/VS Code)`.

#### Part 3.1 - How to run the tests

```sh
mvn clean test # will run all of the tests.
mvn gauge:execute -DspecsDir=specs -Dtags=made_up # will run tests with a tag `made_up`.
```

To learn more about the `gauge-maven-plugin` refer to `https://github.com/getgauge-contrib/gauge-maven-plugin/blob/master/README.md`

### Part 4 - Fix broken tests

The testers have worked on some API tests in Gauge Java however, some are failing.
The scenarios are written in Gauge's spec files under the `specs/` directory.

- Go through the specifications and help the testers by fixing broken tests.

### Part 5 - Add missing steps

Some tests are incomplete and haven't been finished. 

- Add missing steps and implementation to complete the tests.

### Part 6 - Improving the tests

Is there anything that can be improved in the tests? Now is the time to make the tests shine!

- Add any additional test coverage that you think is applicable for the application under test.

### Part 7 - Further improvements

- How else would you test this API?
- Are there any improvements you would make to the tests?
- Are there any improvements you would make to the framework?

Document your suggestions in the same file as above.

## Submission

Add the entire test project along with your `FINDINGS.md` to a ZIP archive and send it over back to us.
