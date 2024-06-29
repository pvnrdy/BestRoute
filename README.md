# BestRoute

### Introduction
Welcome to the Tomato Delivery App! This console-based application manages food delivery logistics. Users can manually enter data or use test data for simulation. The app calculates the shortest delivery time for a given delivery agent based on orders, locations, and delivery speed.

---

### Assumptions

1. **Distance Calculation**: The distance between locations is provided using latitude and longitude coordinates.
2. **Delivery Agent Speed**: The average speed of delivery agents is assumed to be 20 km/hr.
3. **Preparation Time**: Each restaurant has a preparation time in minutes.
4. **Result Shortest Time**: Result shortest time values are assumed to be in hours.

---

## Usage
### Prerequisites
- Java Development Kit (JDK) - OpenJDK Version: `21.0.2`

---

### Running the Application

1. Clone this repository to your local machine.
2. Navigate to the `lib` directory of the cloned repository using the terminal.
3. Run the JAR file using the command `java -jar BestRouteApp.jar`.

---

### Modes
You can run the application in two modes:
- **Manual Mode**: Allows manual data entry for agents, customers, restaurants, and orders. Provides the final result based on the entered data.
- **Test Mode**: Automatically populates sample data using `TestApp` for quick testing and result verification.

To choose a mode, follow the on-screen instructions after running the JAR file.

### File Structure
- `src/`: Contains the source code files for the application.
- `bin/`: Contains the class files of the application
- `lib/`: Contains the `BestRouteApp.jar` whic is a compressed executable version of the source code, designed for effortless deployment and usage.

### Sample look of the modes defined in the Application

- Enter `manual` to input data manually or `test` to run predefined test cases.

1. Manual Data Entry:
- If you choose `manual`, you'll be prompted to enter details for delivery agents, restaurants, customers, and orders.
- Example:
  ```
  How many awesome delivery agents are ready to conquer the world today?
  2
  Delivery ace joining the squad! What shall we call Agent 1?
  Agent 1
  Captain, it's time to chart Agent 1's course! Enter the latitude first:
  12.3456
  Great! Now, could you please enter the longitude?
  78.9101
  ...
  How many orders do we have today?
  3
  ...
  Enter the delivery agent for whom we have to check the shortest route?
  1
  Total shortest delivery time: 0.061846 hours
  ```

2. Test Data:
- If you choose `test`, predefined test cases will be executed using the TestApp class.
- Example:
  ```
  Enter 'manual' for manual data entry or 'test' for test data:
  test
  ...
  Assertion passed: Calculated shortest time matches the expected value.
  ```

3. Running Tests:
- The application executes predefined tests to verify the correctness of the shortest delivery time calculation.
- Tests are based on sample data and expected outcomes.

4. Test Commit