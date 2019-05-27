package stepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Student;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CucumberStepDefs {

    private List<Student> students = new ArrayList<Student>();

    private Student mapStudent(Map<String, String> params) {
        Student student = new Student();

        student.setName(params.get("name"));
        student.setPk(params.get("pk"));
        student.setAge(Integer.valueOf(params.get("age")));

        return student;
    }

    @Given("student with attributes:")
    public void add_student(Map<String, String> params) {
        students.add(mapStudent(params));
    }

    @When("we add a new student with attributes")
    public void add_another_student(Map<String, String> params) {
        students.add(mapStudent(params));
    }

    @Then("student count is (.*)")
    public void check_student_count(int count) {
        Assertions.assertEquals(count, students.size(), "Incorrect students count!");
    }

    @Then("last student age is (.*)")
    public void check_last_student_age(Integer age) {
        Assertions.assertEquals(age, students.get(students.size() - 1).getAge(), "Incorrect student age!");
    }

}
