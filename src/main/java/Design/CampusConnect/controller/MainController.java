package Design.CampusConnect.controller;

import Design.CampusConnect.entity.Group;
import Design.CampusConnect.entity.Post;
import Design.CampusConnect.entity.Student;
import Design.CampusConnect.repo.GroupRepo;
import Design.CampusConnect.repo.PostRepo;
import Design.CampusConnect.repo.StudentRepo;
import Design.CampusConnect.service.GroupService;
import Design.CampusConnect.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private StudentRepo studentRepository;

    @Autowired // This means to get the bean called userRepository
    private GroupService GroupService;

    @Autowired // This means to get the bean called userRepository
    private PostService postService;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private PostRepo PostRepository;


//    @GetMapping(path="/add") // Map ONLY GET Requests
//    public @ResponseBody
//    String addNewUser (@RequestParam String name
//            , @RequestParam String email) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//
//        Student n = new Student();
//        n.setName(name);
//        n.setEmail(email);
//        studentRepository.save(n);
//        return "Saved";
//    }

    @RequestMapping(value = "/student/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Student newStudent(Student newStudent) {
        return studentRepository.save(newStudent);

    }

    @RequestMapping(value = "/post/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Post newPost(String content, int poster, int group) {
        return postService.makePost(content, poster,group);

    }

    @RequestMapping(value = "/group/add", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Group newGroup(int creatorId, String groupName) {
        return GroupService.studentCreateGroup(creatorId, groupName);

    }

    @RequestMapping(value = "/group/join", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    void joinGroup(int newMemberId, int groupid) {
        GroupService.studentJoinGroup(newMemberId, groupid);
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Student> getAllUsers() {
        // This returns a JSON or XML with the users
        return studentRepository.findAll();
    }

    @GetMapping(path="/find")
    public @ResponseBody
    Iterable<Student> getUser(@RequestParam Iterable<Integer> id) {
        // This returns a JSON with specific  user
        return studentRepository.findAllById(id);
    }
}

