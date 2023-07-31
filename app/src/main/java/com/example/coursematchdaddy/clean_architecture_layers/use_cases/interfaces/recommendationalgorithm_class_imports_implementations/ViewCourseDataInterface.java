package com.example.coursematchdaddy.clean_architecture_layers.use_cases.interfaces.recommendationalgorithm_class_imports_implementations;

import java.util.HashMap;
import java.util.List;
public interface ViewCourseDataInterface {
    /**
     * return a list of course maps containing course titles, codes, and descriptions
     *
     * @return List<Map<String, String>>
     */
    public List<HashMap<String, String>> getCourseData();

}
