package Graph;

import java.util.*;

public class CoursePrerequisiteSystem {
    /*
     * Task 1: Represent this prerequisite system using appropriate graph structure
     * Structure: Directed Graph represented as an Adjacency List.
     * We use a HashMap to map each course to a list of courses that require it 
     * (prerequisite -> dependent courses). We also keep track of in-degrees for topological sort.
     */

    private Map<String, List<String>> adjList;
    private Map<String, Integer> inDegree;

    public CoursePrerequisiteSystem() {
        adjList = new HashMap<>();
        inDegree = new HashMap<>();
    }

    public void addCourse(String course) {
        adjList.putIfAbsent(course, new ArrayList<>());
        inDegree.putIfAbsent(course, 0);
    }

    public void addPrerequisite(String prereq, String course) {
        addCourse(prereq);
        addCourse(course);
        adjList.get(prereq).add(course);
        inDegree.put(course, inDegree.get(course) + 1);
    }

    // Task 2: Design an algorithm to detect if there's a circular dependency (cycle detection)
    public boolean hasCircularDependency() {
        Map<String, Integer> tempInDegree = new HashMap<>(inDegree);
        Queue<String> queue = new LinkedList<>();
        
        for (String course : tempInDegree.keySet()) {
            if (tempInDegree.get(course) == 0) {
                queue.add(course);
            }
        }
        
        int visitedCount = 0;
        while (!queue.isEmpty()) {
            String current = queue.poll();
            visitedCount++;
            
            for (String neighbor : adjList.get(current)) {
                tempInDegree.put(neighbor, tempInDegree.get(neighbor) - 1);
                if (tempInDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // If visited count != total courses, there is a cycle
        return visitedCount != adjList.size();
    }

    // Task 3: Design an algorithm to determine all courses that must be completed before taking a target course
    public List<String> getAllPrerequisitesFor(String target) {
        // Need a reverse adjacency list: course -> prerequisites
        Map<String, List<String>> reverseAdjList = new HashMap<>();
        for (String course : adjList.keySet()) {
            reverseAdjList.putIfAbsent(course, new ArrayList<>());
            for (String dependent : adjList.get(course)) {
                reverseAdjList.putIfAbsent(dependent, new ArrayList<>());
                reverseAdjList.get(dependent).add(course);
            }
        }

        Set<String> requiredCourses = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        if (reverseAdjList.containsKey(target)) {
            queue.add(target);
        }
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String prereq : reverseAdjList.getOrDefault(current, new ArrayList<>())) {
                if (!requiredCourses.contains(prereq)) {
                    requiredCourses.add(prereq);
                    queue.add(prereq);
                }
            }
        }
        
        return new ArrayList<>(requiredCourses);
    }

    // Task 4: Generate a valid order in which all courses can be taken (topological sort)
    public List<String> getValidCourseOrder() {
        if (hasCircularDependency()) {
            return new ArrayList<>(); // Cannot complete if there's a cycle
        }
        
        List<String> order = new ArrayList<>();
        Map<String, Integer> tempInDegree = new HashMap<>(inDegree);
        Queue<String> queue = new LinkedList<>();
        
        for (String course : tempInDegree.keySet()) {
            if (tempInDegree.get(course) == 0) {
                queue.add(course);
            }
        }
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            order.add(current);
            
            for (String neighbor : adjList.get(current)) {
                tempInDegree.put(neighbor, tempInDegree.get(neighbor) - 1);
                if (tempInDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        return order;
    }

    public static void main(String[] args) {
        CoursePrerequisiteSystem system = new CoursePrerequisiteSystem();
        system.addPrerequisite("CS101", "CS102");
        system.addPrerequisite("CS101", "CS201");
        system.addPrerequisite("CS102", "CS202");
        system.addPrerequisite("MATH101", "CS201");
        system.addCourse("CS202"); // Just to be safe it's registered
        
        System.out.println("Has circular dependency? " + system.hasCircularDependency());
        System.out.println("Courses required before taking CS202: " + system.getAllPrerequisitesFor("CS202"));
        System.out.println("Valid course taking order: " + system.getValidCourseOrder());
    }
}
