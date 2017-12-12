package cn.morethink.action;

import cn.morethink.eneity.User;
import cn.morethink.util.Result;
import cn.morethink.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 李文浩
 * @version 2017/12/8.
 */

@RestController
@RequestMapping("/users")
public class UserAction {

    @PostMapping
    public Result saveUsers(@RequestBody  List<User> users) {
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

}

