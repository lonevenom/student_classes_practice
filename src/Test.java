import java.util.*;

public class Test {

    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        Scanner userInput = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        int mathCnt = 0;
        int scienceCnt = 0;

        do {
            System.out.println(UserQuestions.askToJoin);
            String join = userInput.next();

            if (join.toUpperCase().startsWith("Y")){
                //Ask my questions
                System.out.println(UserQuestions.askFirstName);
                String firstName = userInput.next();
                System.out.println(UserQuestions.askLastName);
                String lastName = userInput.next();
                System.out.println(UserQuestions.askAge);
                int age = userInput.nextInt();
                Permission.checkAge(age); // calling method to check age
                userInput.nextLine(); // because it goes from taking an int to a string in gender
                System.out.println(UserQuestions.askGender);
                String gender = userInput.next();
                System.out.println(UserQuestions.askClassName);
                String classType = userInput.next();

                Permission.checkClassName(classType); // calling method to check className
                System.out.println("Congratulations! You are registered for " + classType + " class.\n");

                if (classType.toUpperCase().equals("MATH")) {
                    Student student = new MathStudent(firstName, lastName, age, gender, classType);
                    students.add(student);
                } else if (classType.toUpperCase().equals("SCIENCE")) {
                    Student student = new ScienceStudent(firstName, lastName, age, gender, classType);
                    students.add(student);
                }
            }
        } while(students.size() < 3);

        for (Student object : students) {
            System.out.println(object);
        }
        for (Student object : students) {
            if (object.getClassName().toUpperCase().equals("MATH")) mathCnt++;
            else if (object.getClassName().toUpperCase().equals("SCIENCE")) scienceCnt++;
        }
        System.out.println("Math students = " + mathCnt);
        System.out.println("Science students = " + scienceCnt);


    }
}
