# SolvishR - OOP II Project
A project for OOP class (SWE 4301) that uses **SOLID** principles. 

> visit the wiki page for more information about the project. Or click [here](

## SOLID Principles
- **S**ingle Responsibility Principle : Each class should have a single responsibility.

- **O**pen/Closed Principle : Classes should be open for extension but closed for modification.

- **L**iskov Substitution Principle : Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program.

- **I**nterface Segregation Principle : Many client-specific interfaces are better than one general-purpose interface.

- **D**ependency Inversion Principle : One should depend upon abstractions, not concretions.

## UML Diagram
![UML Diagram](rsx/uml.png)


## Single Responsibility Principle in SolvishR
Here all the classes are having a single responsibility. For example, the `NonTimedExam` class is responsible for the non-timed exam. The `TimedExam` class is responsible for the timed exam. The `Exam` class is responsible for managing any of the exam. `Exam` does not depend on `Question` class or its children. 

## Open/Closed Principle in SolvishR
The `Exam` class is open for extension but closed for modification. The `Exam` class is extended by `NonTimedExam` and `TimedExam` classes. The `Exam` class is not modified to add the functionality of `NonTimedExam` and `TimedExam` classes. And in future to introduce a new method to **run** the exam, the `Exam` class will not be modified. Instead, a new class will be created that will extend the `Exam` class and add the functionality of **runExam** method.

In the same way the `Question` class is open for extension but closed for modification. The `Question` class is extended by `AdditionQuestion` , `SubtractionQuestion` , `MultiplicationQuestion` and `DivisionQuestion` classes. The `Question` class is not modified to add the functionality of `AdditionQuestion` , `SubtractionQuestion` , `MultiplicationQuestion` and `DivisionQuestion` classes. And in future to introduce a new method to **run** the exam, the `Question` class will not be modified. Instead, a new class will be created that will extend the `Question` class and add the functionality of **checkAnswer** method.

## Liskov Substitution Principle in SolvishR
The `Exam` class is extended by `NonTimedExam` and `TimedExam` classes. The `NonTimedExam` and `TimedExam` classes are subtypes of `Exam` class. The `NonTimedExam` and `TimedExam` classes can be used in place of `Exam` class without altering the correctness of the program.

Same goes for the `Question` class. The `AdditionQuestion` , `SubtractionQuestion` , `MultiplicationQuestion` and `DivisionQuestion` classes are subtypes of `Question` class. The `AdditionQuestion` , `SubtractionQuestion` , `MultiplicationQuestion` and `DivisionQuestion` classes can be used in place of `Question` class without altering the correctness of the program.

And these type of referances for both `Exam` , `Question` and their subtypes are used in the `ExamSaver` and other `factory` classes.

## Interface Segregation Principle in SolvishR
> As there is no interface in the project, the Interface Segregation Principle is not applicable here.


## Dependency Inversion Principle in SolvishR
From the high level `main class` to any other class like `ExamSaver` , `ExamFactory` , `QuestionFactory` , `Exam` , `Question` and their subtypes, all the classes depend on abstraction. For example, the `ExamSaver` class depends on `Exam` class. The `Exam` class is an abstraction. The `ExamSaver` class does not depend on `NonTimedExam` or `TimedExam` class. The `ExamSaver` class depends on `Exam` class. The `Exam` class is an abstraction. The `Main` class does not depend on `AdditionQuestion` , `SubtractionQuestion` , `MultiplicationQuestion` and `DivisionQuestion` classes. The `Main` class depends on `Question` class. The `Question` class is an abstraction. The whole project is organized in a way that it depends on abstraction, not concretions.

so it maintains the 2 rules of Dependency Inversion Principle:
- High-level modules should not depend on low-level modules. Both should depend on abstractions.
- Abstractions should not depend on details. Details should depend on abstractions.


## Patterns Used

### Factory Pattern
The `ExamFactory` and `QuestionFactory` classes are the factory classes. The `ExamFactory` class is responsible for creating the `Exam` object. The `QuestionFactory` class is responsible for creating the `Question` object. The `ExamFactory` and `QuestionFactory` classes are used in the `Main` class to create the `Exam` and `Question` objects.

### Singleton Pattern
The `ExamSaver` class is the singleton class. The `ExamSaver` class is responsible for saving the `Exam` object. The `ExamSaver` class is used in the `Main` class to save the `Exam` object.

there are also other classes that are singleton classes. For example, the `ExamFactory` and `QuestionFactory` classes are singleton classes. The `ExamFactory` class is responsible for creating the `Exam` object. The `QuestionFactory` class is responsible for creating the `Question` object. The `ExamFactory` and `QuestionFactory` classes are used in the `Main` class to create the `Exam` and `Question` objects.

the reason of making them singleton is to make sure that there is only one instance of the class. For example, there should be only one instance of `ExamSaver` class. If there are multiple instances of `ExamSaver` class, then there will be multiple files for saving the `Exam` object. And that is not desirable. So, to make sure that there is only one instance of `ExamSaver` class, the `ExamSaver` class is made singleton.