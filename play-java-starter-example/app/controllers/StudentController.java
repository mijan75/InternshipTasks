package controllers;

import models.Student;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.students.create;
import views.html.students.edit;
import views.html.students.show;

import javax.inject.Inject;
import java.util.List;

public class StudentController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(){
        List<Student> students = Student.find.all();
        return ok(views.html.students.index.render(students));
    }

    public Result create(){
        Form<Student> studentForm = formFactory.form(Student.class);
        return ok(create.render(studentForm));
    }

    public Result save(){
        Form<Student> studentForm = formFactory.form(Student.class).bindFromRequest();
        if (studentForm.hasErrors()){
            flash("danger","Please correct the form below");
            return badRequest(create.render(studentForm));
        }
        Student student = studentForm.get();
        student.save();
        flash("success","Student added");
        return redirect(routes.StudentController.index());
    }

    public Result edit(String id){
        Student student = Student.find.byId(id);
        if (student == null) {
            return notFound("Student Not Found");
        }
        Form<Student> studentForm = formFactory.form(Student.class).fill(student);
        return ok(edit.render(studentForm));
    }

    public Result something(){
        Form<Student> studentForm = formFactory.form(Student.class).bindFromRequest();
        if (studentForm.hasErrors()){
            flash("danger","Please correct the form below");
            return badRequest(edit.render(studentForm));
        }
        Student newStudent = studentForm.get();
        Student oldStudent = Student.find.byId(newStudent.id);

        if (oldStudent == null) {
            return notFound("Student Not Found");
        }

        oldStudent.name = newStudent.name;
        oldStudent.address = newStudent.address;
        oldStudent.phone = newStudent.phone;
        oldStudent.email = newStudent.email;
        oldStudent.update();
        flash("success","Student updated successfully");
        return redirect(routes.StudentController.index());
    }

    public Result show(String id){
        Student student = Student.find.byId(id);
        if (student == null) {
            return notFound("Student Not Found");
        }
        return ok(show.render(student));
    }

    public Result destroy(String id){
        Student student = Student.find.byId(id);
        if (student == null) {
            return notFound("Student Not Found");
        }
        student.delete();
        flash("danger","Student Deleted successfully");
        return redirect(routes.StudentController.index());
    }
}
