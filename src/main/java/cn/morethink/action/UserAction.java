package cn.morethink.action;

import cn.morethink.eneity.User;
import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 李文浩
 * @version 2017/12/8.
 */

@RestController
@RequestMapping("/users")
public class UserAction {

    @PostMapping
    public Result saveUser(@ModelAttribute User user) {
        return ResultUtil.successResult(user);
    }

    @PostMapping("saveUsers")
    public Result saveUsers(@RequestBody List<User> users) {
        return ResultUtil.successResult(users);
    }

    @GetMapping("/{id}")
    public Result getUser(@PathVariable int id) {
        return ResultUtil.successResult(id);
    }

    @GetMapping("/getRequestHeader")
    public Result getRequestHeader(@RequestHeader("Accept-Encoding") String encoding) {
        return ResultUtil.successResult(encoding);
    }

    @GetMapping("/getCookie")
    public Result getCookie(@CookieValue("JSESSIONID") String cookie) {
        return ResultUtil.successResult(cookie);
    }

    @GetMapping("/tesRequestParam")
    public Result tesRequestParam(@RequestParam("username") String username) {
        return ResultUtil.successResult(username);
    }

    @PostMapping("/tesRequestBody")
    public Result tesRequestBody(@RequestBody User user) {

        return ResultUtil.SUCCESS_RESULT;
    }

    @PostMapping("/setSessionAttribute")
    public Result setSessionAttribute(HttpSession session, String attribute) {
        session.setAttribute("attribute", attribute);
        return ResultUtil.SUCCESS_RESULT;
    }

    @GetMapping("/getSessionAttribute")
    public Result getSessionAttribute(@SessionAttribute("attribute") String attribute) {
        return ResultUtil.successResult(attribute);
    }

    @GetMapping("/testModelAttribute")
    public Result testModelAttribute() {

        return ResultUtil.successResult("");
    }

    @RequestMapping("/doUpload")
    public Result doUpload(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("E://", file.getOriginalFilename()));
        }
        return ResultUtil.SUCCESS_RESULT;
    }

}

