package com.heiqi.chat.controller;

import com.heiqi.chat.entity.Metrics;
import com.heiqi.chat.entity.User;
import com.heiqi.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserById/{UserId}")
    public User getUserById(@PathVariable("UserId") int UserId) {
        return userService.getUserById(UserId);
    }

    @GetMapping("/getUserByName/{UserName}")
    public User getUserByName(@PathVariable("UserName") String UserName) {
        return userService.getUserByName(UserName);
    }

    @GetMapping("/getUserByAge/{Age}")
    public User getUserByAge(@PathVariable("Age") int Age) {
        return userService.getUserByAge(Age);
    }
    @GetMapping("/getUserByAddress/{Address}")
    public User getUserByAddress(@PathVariable("Address") String Address) {
        return userService.getUserByAddress(Address);
    }
    @GetMapping("/getUserMatch/{UserId}")
    public List<Metrics> getUserMatch(@PathVariable("UserId") int UserId){
        return userService.getUserMatch(UserId);
    }

    @GetMapping("/getUserCharaPro/{UserId}")
    public boolean getUserCharaPro(@PathVariable("UserId") int UserId){
        return userService.getUserCharaPro(UserId);
    }
    @GetMapping("/getUserInfoPro/{UserId}")
    public boolean getUserInfoPro(@PathVariable("UserId") int UserId){
        return userService.getUserInfoPro(UserId);
    }
    @GetMapping("/getUserMatchPro/{UserId}")
    public int getUserMatchPro(@PathVariable("UserId") int UserId){
        return userService.getUserMatchPro(UserId);
    }


    // 这里写更多的 getter 函数...

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) {
        userService.insertUser(user);
    }

    @DeleteMapping("/deleteUser/{UserId}")
    public void deleteUser(@PathVariable("UserId") int UserId) {
        userService.deleteUser(UserId);
    }

    @PutMapping("/updateUserName/{UserId}")
    public void updateUserName(@PathVariable("UserId") int UserId, @RequestBody String UserName) {
        userService.updateUserName(UserId, UserName);
    }

    @PutMapping("/updateUserAge/{UserId}")
    public void updateUserAge(@PathVariable("UserId") int UserId, @RequestBody int Age) {
        userService.updateUserAge(UserId, Age);
    }

    @PutMapping("/updateUserAddress/{UserId}")
    public void updateUserAddress(@PathVariable("UserId") int UserId, @RequestBody String Address) {
        userService.updateUserAddress(UserId,Address);
    }
    @PutMapping("/updateUserIdentity/{UserId}")
    public void updateUserIdentity(@PathVariable("UserId") int UserId, @RequestBody String Identity) {
        userService.updateUserIdentity(UserId,Identity);
    }

    @PutMapping("/updateUserEducation/{UserId}")
    public void updateUserEducation(@PathVariable("UserId") int UserId, @RequestBody int Education) {
        System.out.println("UserId = " + UserId);
        System.out.println("Education = " + Education);
        userService.updateUserEducation(UserId,Education);
    }

    @PutMapping("/updateUserPhoto/{UserId}")
    public void updateUserPhoto(@PathVariable("UserId") int UserId, @RequestBody String Photo) {
        userService.updateUserPhoto(UserId,Photo);
    }

    @PutMapping("/updateUserIsAuthed/{UserId}")
    public void updateUserIsAuthed(@PathVariable("UserId") int UserId,@RequestBody int IsAuthed){
        userService.updateUserIsAuthed(UserId, IsAuthed);
    }

    @PutMapping("/updateUserIsLogged/{UserId}")
    public void updateUserIsLogged(@PathVariable("UserId") int UserId,@RequestBody int IsLogged){
        userService.updateUserIsLogged(UserId,IsLogged);
    }

    @PutMapping("/updateUserIsTestedCore/{UserId}")
    public void updateUserIsTestedCore(@PathVariable("UserId") int UserId,@RequestBody int IsTestedCore){
        userService.updateUserIsTestedCore(UserId,IsTestedCore);
    }

    @PutMapping("/updateUserIsTestedNoncore/{UserId}")
    public void updateUserIsTestedNoncore(@PathVariable("UserId") int UserId,@RequestBody int IsTestedNoncore){
        userService.updateUserIsTestedNoncore(UserId,IsTestedNoncore);
    }

    // 这里写更多的 setter 函数...
}