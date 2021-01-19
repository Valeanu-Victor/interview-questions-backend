package com.hotinterviewquestions.rest.webservices.db;

import com.hotinterviewquestions.rest.webservices.dto.QuestionDto;
import com.hotinterviewquestions.rest.webservices.dto.UserDto;
import com.hotinterviewquestions.rest.webservices.dtoMapper.QuestionMapper;
import com.hotinterviewquestions.rest.webservices.dtoMapper.UserMapper;
import com.hotinterviewquestions.rest.webservices.entity.Question;
import com.hotinterviewquestions.rest.webservices.entity.User;
import com.hotinterviewquestions.rest.webservices.repository.QuestionsJpaRepository;
import com.hotinterviewquestions.rest.webservices.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DbInit implements CommandLineRunner {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private QuestionMapper questionMapper;
    private QuestionsJpaRepository questionsJpaRepository;

    public DbInit(UserRepository userRepository, QuestionMapper questionMapper,
                  PasswordEncoder passwordEncoder, UserMapper userMapper,
                  QuestionsJpaRepository questionsJpaRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.questionMapper = questionMapper;
        this.questionsJpaRepository = questionsJpaRepository;
    }

    @Override
    public void run(String... args) {
        // everything here is hardcoded for now for the purpose of seeing how the application demo runs

        userRepository.deleteAll();
        questionsJpaRepository.deleteAll();

        QuestionDto question1 = new QuestionDto("What is Docker?", "Docker is an open-source lightweight containerization technology. It has gained widespread popularity in the cloud and application packaging world. It allows you to automate the deployment of applications in lightweight and portable containers.", "Junior", "Docker");
        QuestionDto question2 = new QuestionDto("What is Docker Engine?", "Docker daemon or Docker engine represents the server. The docker daemon and the clients should be run on the same or remote host, which can communicate through command-line client binary and full RESTful API.", "Intermediate", "Docker");
        QuestionDto question3 = new QuestionDto("What command should you run to see all running container in Docker?", "$ docker ps", "Junior", "Docker");
        QuestionDto question4 = new QuestionDto("What is Java?", "Java is the high-level, object-oriented, robust, secure programming language, platform-independent, high performance, Multithreaded, and portable programming language. It was developed by James Gosling in June 1991. It can also be known as the platform as it provides its own JRE and API.", "Junior", "JavaCore");
        QuestionDto question5 = new QuestionDto("What do you understand by Java virtual machine?", "Java Virtual Machine is a virtual machine that enables the computer to run the Java program. JVM acts like a run-time engine which calls the main method present in the Java code. JVM is the specification which must be implemented in the computer system. The Java code is compiled by JVM to be a Bytecode which is machine independent and close to the native code.", "Intermediate", "JavaCore");
        QuestionDto question6 = new QuestionDto("What is the difference between JDK, JRE, and JVM?", "JVM\n" +
                "JVM is an acronym for Java Virtual Machine; it is an abstract machine which provides the runtime environment in which Java bytecode can be executed. It is a specification which specifies the working of Java Virtual Machine. Its implementation has been provided by Oracle and other companies. Its implementation is known as JRE.\n" +
                "\n" +
                "JVMs are available for many hardware and software platforms (so JVM is platform dependent). It is a runtime instance which is created when we run the Java class. There are three notions of the JVM: specification, implementation, and instance.\n" +
                "\n" +
                "JRE\n" +
                "JRE stands for Java Runtime Environment. It is the implementation of JVM. The Java Runtime Environment is a set of software tools which are used for developing Java applications. It is used to provide the runtime environment. It is the implementation of JVM. It physically exists. It contains a set of libraries + other files that JVM uses at runtime.\n" +
                "\n" +
                "JDK\n" +
                "JDK is an acronym for Java Development Kit. It is a software development environment which is used to develop Java applications and applets. It physically exists. It contains JRE + development tools.", "Junior", "JavaCore");
        QuestionDto question7 = new QuestionDto("What is JIT compiler?", "Just-In-Time(JIT) compiler: It is used to improve the performance. JIT compiles parts of the bytecode that have similar functionality at the same time, and hence reduces the amount of time needed for compilation. Here the term “compiler” refers to a translator from the instruction set of a Java virtual machine (JVM) to the instruction set of a specific CPU.", "Intermediate", "JavaCore");
        QuestionDto question8 = new QuestionDto("What gives Java its 'write once and run anywhere' nature?", "The bytecode. Java compiler converts the Java programs into the class file (Byte Code) which is the intermediate language between source code and machine code. This bytecode is not platform specific and can be executed on any computer.", "Intermediate", "JavaCore");
        QuestionDto question9 = new QuestionDto("Is delete, next, main, exit or null keyword in java?", "NO", "Junior", "JavaCore");
        QuestionDto question10 = new QuestionDto("What are the various access specifiers in Java?", "In Java, access specifiers are the keywords which are used to define the access scope of the method, class, or a variable. In Java, there are four access specifiers given below.\n" +
                "\n" +
                "Public\n" + "The classes, methods, or variables which are defined as public, can be accessed by any class or method.\n" +
                "Protected\n" + "Protected can be accessed by the class of the same package, or by the sub-class of this class, or within the same class.\n" +
                "Default\n" + "Default are accessible within the package only. By default, all the classes, methods, and variables are of default scope.\n" +
                "Private\n" + "The private class, methods, or variables defined as private can be accessed within the class only.", "Junior", "JavaCore");
        QuestionDto question11 = new QuestionDto("What new features were added in Java 8?", "Java 8 ships with several new features but the most significant are the following:\n" +
                "\n" +
                "Lambda Expressions − a new language feature allowing treating actions as objects.\n\n" +
                "Method References − enable defining Lambda Expressions by referring to methods directly using their names.\n\n" +
                "Optional − special wrapper class used for expressing optionality.\n\n" +
                "Functional Interface – an interface with maximum one abstract method, implementation can be provided using a Lambda Expression.\n\n" +
                "Default methods − give us the ability to add full implementations in interfaces besides abstract methods.\n\n" +
                "Nashorn, JavaScript Engine − Java-based engine for executing and evaluating JavaScript code.\n\n" +
                "Stream API − a special iterator class that allows processing collections of objects in a functional manner.\n\n" +
                "Date API − an improved, immutable JodaTime-inspired Date API.\n\n" +
                "Along with these new features, lots of feature enhancements are done under-the-hood, at both compiler and JVM level.", "Junior", "Java8Features");
        QuestionDto question12 = new QuestionDto("What is the meaning of String::Valueof expression?", "It is a static method reference to the valueOf method of the String class.", "Junior", "Java8Features");
        QuestionDto question13 = new QuestionDto("Describe some of the Functional Interfaces in the Standard Library.", "There are a lot of functional interfaces in the java.util.function package, the more common ones include but not limited to:\n" +
                "\n" +
                "Function – it takes one argument and returns a result\n" +
                "Consumer – it takes one argument and returns no result (represents a side effect)\n" +
                "Supplier – it takes not argument and returns a result\n" +
                "Predicate – it takes one argument and returns a boolean\n" +
                "BiFunction – it takes two arguments and returns a result\n" +
                "BinaryOperator – it is similar to a BiFunction, taking two arguments and returning a result. The two arguments and the result are all of the same types\n" +
                "UnaryOperator – it is similar to a Function, taking a single argument and returning a result of the same type", "Intermediate", "Java8Features");
        QuestionDto question14 = new QuestionDto("What is a Lambda Expression and what is it used for?", "In very simple terms, a lambda expression is a function that can be referenced and passed around as an object.\n" +
                "\n" +
                "Lambda expressions introduce functional style processing in Java and facilitate the writing of compact and easy-to-read code.\n" +
                "\n" +
                "Because of this, lambda expressions are a natural replacement for anonymous classes as method arguments. One of their main uses is to define inline implementations of functional interfaces.", "Junior", "Java8Features");
        QuestionDto question15 = new QuestionDto("What is Stream Pipelining in Java 8?", "Stream pipelining is the concept of chaining operations together. This is done by splitting the operations that can happen on a stream into two categories: intermediate operations and terminal operations.\n" +
                "\n" +
                "Each intermediate operation returns an instance of Stream itself when it runs, an arbitrary number of intermediate operations can, therefore, be set up to process data forming a processing pipeline.\n" +
                "\n" +
                "There must then be a terminal operation which returns a final value and terminates the pipeline.", "Junior", "Java8Features");
        QuestionDto question16 = new QuestionDto("What is OOP?", "OOP is abbreviated as Object Oriented Programming system in which programs are considered as a collection of objects. Each object is nothing but an instance of a class.", "Junior", "OOP");
        QuestionDto question17 = new QuestionDto("What are the basic concepts of OOP?", "Following are the concepts of OOP:\n" +
                "\n" +
                "1. Abstraction\n" +
                "2. Encapsulation\n" +
                "3. Inheritance\n" +
                "4. Polymorphism", "Junior", "OOP");
        QuestionDto question18 = new QuestionDto("What is Encapsulation?", "Encapsulation is an attribute of an object, and it contains all data which is hidden. That hidden data can be restricted to the members of that class.\n" +
                "\n" +
                "Levels are Public, Protected, Private and Default.", "Junior", "OOP");
        QuestionDto question19 = new QuestionDto("What is Polymorphism?", "Polymorphism is nothing but assigning behavior or value in a subclass to something that was already declared in the main class. Simply, polymorphism takes more than one form.", "Junior", "OOP");
        QuestionDto question20 = new QuestionDto("What is Inheritance?", "Inheritance is a concept where one class shares the structure and behavior defined in another class. If Inheritance applied to one class is called Single Inheritance, and if it depends on multiple classes, then it is called multiple Inheritance.", "Junior", "OOP");
        QuestionDto question21 = new QuestionDto("What are Docker Images?", "When you mention Docker images, your very next question will be “what are Docker images”.\n" +
                "\n" +
                "Docker image is the source of Docker container. In other words, Docker images are used to create containers. When a user runs a Docker image, an instance of a container is created. These docker images can be deployed to any Docker environment.", "Junior", "Docker");
        QuestionDto question22 = new QuestionDto("Tell us something about Docker Compose.", "Docker Compose is a YAML file which contains details about the services, networks, and volumes for setting up the Docker application. So, you can use Docker Compose to create separate containers, host them and get them to communicate with each other. Each container will expose a port for communicating with other containers.", "Intermediate", "Docker");
        QuestionDto question23 = new QuestionDto("What is Docker Swarm?", "You are expected to have worked with Docker Swarm as it’s an important concept of Docker.\n" +
                "\n" +
                "Docker Swarm is native clustering for Docker. It turns a pool of Docker hosts into a single, virtual Docker host. Docker Swarm serves the standard Docker API, any tool that already communicates with a Docker daemon can use Swarm to transparently scale to multiple hosts.", "Intermediate", "Docker");
        QuestionDto question24 = new QuestionDto("Once you’ve worked with an image, how do you push it to docker hub?", "$ docker push <username/image name>", "Advanced", "Docker");
        QuestionDto question25 = new QuestionDto("Will you lose your data, when a docker container exists?", "No, you won’t lose any data when Docker container exits. Any data that your application writes to the container gets preserved on the disk until you explicitly delete the container. The file system for the container persists even after the container halts.", "Advanced", "Docker");
        QuestionDto question26 = new QuestionDto("Can I use JSON instead of YAML for my compose file in Docker?", "You can use JSON instead of YAML for your compose file, to use JSON file with compose, specify the JSON filename to use, for example:\n" +
                "\n" +
                "$ docker-compose -f docker-compose.json up", "Advanced", "Docker");

        Question questionEntity1 = questionMapper.toEntity(question1);
        Question questionEntity2 = questionMapper.toEntity(question2);
        Question questionEntity3 = questionMapper.toEntity(question3);
        Question questionEntity4 = questionMapper.toEntity(question4);
        Question questionEntity5 = questionMapper.toEntity(question5);
        Question questionEntity6 = questionMapper.toEntity(question6);
        Question questionEntity7 = questionMapper.toEntity(question7);
        Question questionEntity8 = questionMapper.toEntity(question8);
        Question questionEntity9 = questionMapper.toEntity(question9);
        Question questionEntity10 = questionMapper.toEntity(question10);
        Question questionEntity11 = questionMapper.toEntity(question11);
        Question questionEntity12 = questionMapper.toEntity(question12);
        Question questionEntity13 = questionMapper.toEntity(question13);
        Question questionEntity14 = questionMapper.toEntity(question14);
        Question questionEntity15 = questionMapper.toEntity(question15);
        Question questionEntity16 = questionMapper.toEntity(question16);
        Question questionEntity17 = questionMapper.toEntity(question17);
        Question questionEntity18 = questionMapper.toEntity(question18);
        Question questionEntity19 = questionMapper.toEntity(question19);
        Question questionEntity20 = questionMapper.toEntity(question20);
        Question questionEntity21 = questionMapper.toEntity(question21);
        Question questionEntity22 = questionMapper.toEntity(question22);
        Question questionEntity23 = questionMapper.toEntity(question23);
        Question questionEntity24 = questionMapper.toEntity(question24);
        Question questionEntity25 = questionMapper.toEntity(question25);
        Question questionEntity26 = questionMapper.toEntity(question26);

        Set<Question> questions = new HashSet<>();
        questions.add(questionEntity1);
        questions.add(questionEntity2);
        questions.add(questionEntity3);
        questions.add(questionEntity4);
        questions.add(questionEntity5);
        questions.add(questionEntity6);
        questions.add(questionEntity7);
        questions.add(questionEntity8);
        questions.add(questionEntity9);
        questions.add(questionEntity10);
        questions.add(questionEntity11);
        questions.add(questionEntity12);
        questions.add(questionEntity13);
        questions.add(questionEntity14);
        questions.add(questionEntity15);
        questions.add(questionEntity16);
        questions.add(questionEntity17);
        questions.add(questionEntity18);
        questions.add(questionEntity19);
        questions.add(questionEntity20);
        questions.add(questionEntity21);
        questions.add(questionEntity22);
        questions.add(questionEntity23);
        questions.add(questionEntity24);
        questions.add(questionEntity25);
        questions.add(questionEntity26);

        this.questionsJpaRepository.saveAll(questions);
    }
}
