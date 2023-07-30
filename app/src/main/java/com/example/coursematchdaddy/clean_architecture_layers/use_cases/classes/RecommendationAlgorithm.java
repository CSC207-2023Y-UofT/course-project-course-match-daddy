        package com.example.coursematchdaddy.clean_architecture_layers.use_cases.classes;

        import android.util.Log;

        import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Course;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Program;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.Survey;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.User;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.classes.course_subclasses.ArtsAndSciencesCourse;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations.ArtsAndSciencesCourseInterface;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations.ClosedEnrollmentCourseInterface;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.course_class_imports_implementations.OpenEnrollmentCourseInterface;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations.Type1ProgramInterface;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations.Type2ProgramInterface;
        import com.example.coursematchdaddy.clean_architecture_layers.entities.interfaces.program_class_imports_implementations.Type3ProgramInterface;

        import java.util.ArrayList;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.HashMap;
        import java.util.List;

        public class RecommendationAlgorithm implements ArtsAndSciencesCourseInterface,
                OpenEnrollmentCourseInterface, ClosedEnrollmentCourseInterface, Type1ProgramInterface,
                Type2ProgramInterface, Type3ProgramInterface {
            private User user;
            private List<Course> courseList;
            private final int COURSE_LIMIT = 100;
            public RecommendationAlgorithm(User user, List<Course> courseList){
                this.user = user;
                this.courseList = courseList;
            }

            public List<Course> getCourses(){
                List<Course> courses = filterCourses(this.courseList);
                Collections.sort(courses);

                // Extract the top courses or less if the list is smaller
                int limit = Math.min(COURSE_LIMIT, courses.size());
                return courses.subList(0, limit);
            }
            //Produces recommended courses for the user
            private List<Course> filterCourses(List<Course> inputList){
                List<Course> outputList = new ArrayList<>();
                outputList = removeCoursesTaken(inputList);
                updatePrereqRelevance(outputList);
                updateCreditNumberRelevance(outputList);
                return outputList;
            }
            private List<Course> removeCoursesTaken(List<Course> inputList){
                List<Course> outputList = new ArrayList<Course> ();
                List<String> courseTaken = this.user.getUserSurveyData().getCoursesTaken();

                for (Course course : inputList) {
                    // Check if the course is not already taken by the user
                    if (!courseTaken.contains(course.getCourseCode())){
                        outputList.add(course);
                    }
                }
                return outputList;
            }
            //For each course, If the user has at least 1 preq for that course, it should remain in the
            // output list. (Might change upon testing)
            private void updatePrereqRelevance(List<Course> inputList){
                List<Course> outPutList = new ArrayList<>();
                List<String> coursesTaken = this.user.getUserSurveyData().getCoursesTaken();

                for (Course c: inputList){
                    String coursePrereqs = (String) c.getMiscellaneousCourseData().get("Prerequisites");
                    String courseCoreqs = (String) c.getMiscellaneousCourseData().get("Corequisites");
                    for (String s : coursesTaken){

                        // Course in prereq/coreq string => relevance
                        if (coursePrereqs.contains(s)){
                            c.setRelevance(c.getRelevance() + 1);
                        }
                        if (courseCoreqs.contains(s)){
                            c.setRelevance(c.getRelevance() + 1);
                        }
                    }
                }
            }
            private void updateCreditNumberRelevance(List<Course> inputList){
                // 0-5 => first year, 5-10 => second year ... 15-20 => 4th year
                float creditNumber = this.user.getUserSurveyData().getNumCredits();
                 for (Course c: inputList){
                     float courseYear = c.getCourseCode().charAt(3) -'0'; // - '0' converts to regular numbers
                     //TODO: Finish this method
                 }
            }
            private void updateDistributionRelevance(List<Course> inputList){
                //TODO: Finish this method
            }
            public List<Program> getPrograms(Survey surveyData, User userData){
                return (new ArrayList<Program>((Collection<? extends Program>) new Program("THIS", "IS NOT", "COMPLETE")));
            }
            @Override
            public boolean hasPrerequisites(User user) {
                return false;
            }

            @Override
            public boolean enroll(User userData) {
                return false;
            }

            @Override
            public boolean hasSpace() {
                return false;
            }

            @Override
            public boolean enroll(User userData, boolean hasRequirements) {
                return false;
            }

            @Override
            public boolean unenroll(User userData) {
                return false;
            }
        }
