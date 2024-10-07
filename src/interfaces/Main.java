package interfaces;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("john","doe",19247,2020);
        Professor teacher = new Professor("alex","vanmore",953,"math");
        Assistant assistant = new Assistant("mark","mcdan",6534,true);
        System.out.println(student.goToCollege());
        System.out.println(teacher.goToCollege());
        System.out.println(assistant.goToCollege());

        System.out.println();

        student.studtyAtHome();
        teacher.teachToOtherPeople();
        assistant.studtyAtHome();
        assistant.teachToOtherPeople();
    }
}

interface LearningPerson {
    abstract void studtyAtHome();
}
interface TeachingPerson {
    abstract void teachToOtherPeople();
}
class CollegePerson {
    String name;
    String surname;
    int collegeID;
    public String goToCollege() {
        return "name: " + name + ", surname: " + surname + ", collegeID: " + collegeID;
    }
}
class Student extends CollegePerson implements LearningPerson {
    int academicYear;
    public Student(String name, String surname, int id, int year) {
        this.name = name;
        this.surname = surname;
        this.collegeID = id;
        this.academicYear = year;
    }
    @Override
    public String goToCollege() {
        return super.goToCollege() + " - academicYear: " + academicYear;
    }
    @Override
    public void studtyAtHome() {
        System.out.println(name + " is studying at home");
    }
}
class Professor extends CollegePerson implements TeachingPerson {
    String teachingSubject;

    public Professor(String name, String surname, int id, String teachingSubject) {
        this.name = name;
        this.surname = surname;
        this.collegeID = id;
        this.teachingSubject = teachingSubject;
    }
    @Override
    public String goToCollege() {
        return super.goToCollege() + " - teaching subject: " + teachingSubject;
    }
    @Override
    public void teachToOtherPeople() {
        System.out.println(name + " is teaching other people");
    }
}
class Assistant extends CollegePerson implements LearningPerson,TeachingPerson {
    boolean isGoingToBeAPhD;
    public Assistant(String name, String surname, int id, boolean willBeAPhD) {
        this.name = name;
        this.surname = surname;
        this.collegeID = id;
        this.isGoingToBeAPhD = willBeAPhD;
    }
    @Override
    public String goToCollege() {
        return super.goToCollege() + " - is Going To Be A PhD: " + (isGoingToBeAPhD?"Yes" : "No");
    }
    @Override
    public void studtyAtHome() {
        System.out.println(name + " is studying for PHD");
    }

    @Override
    public void teachToOtherPeople() {
        System.out.println(name + " is assisting at teaching other students");
    }
}

/**
 * define an interface LearningPerson that has an abstract method studyAtHome
 * define an interface TeachingPerson that has an abstract method teachToOtherPeople
 * define a Java superclass CollegePerson that has:
 * 3 attributes (name, surname and a numeric collegeId)
 * a method goToCollege that prints all the CollegePerson attributes
 * considering that a student is a CollegePerson that can learn, define a subclass Student that:
 * implements the right interface and overrides the abstract method with an informative message
 * has an attribute academicYear of type int
 * has a constructor that takes 4 params (name, surname, id, year) and assigns their values to the right attributes
 * considering that a professor is a CollegePeorson that can teach, define a subclass Professor that:
 * implements the right interface and overrides the abstract method with an informative message
 * has an attribute of type String called teachingSubject
 * has a constructor that takes 4 params (name, surname, id, subject) and assigns their values to the right attributes
 * considering that an assistant is a CollegePerson that can learn and teach, define a subclass Assistant that:
 * implements the right interfaces and overrides the abstract methods with informative messages
 * has an attribute of type boolean called isGoingToBeAPhD
 * has a constructor that takes 4 params (name, surname, id, willBeAPhD) and assigns their values to the right attributes
 * define a Java testing class where you:
 * create 3 objects, 1 for each subclass type
 * invoke the goToCollege() method for each of the newly created objects
 * invoke the implemented methods from interfaces (1 for Student, 1 for Professor and 2 for Assistant)
 * */