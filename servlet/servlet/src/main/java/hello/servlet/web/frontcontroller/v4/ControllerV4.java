package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    // 하나는 MemberSaveController 에 사용될 paramName 과 param, (Map<paramName,param>)
    // 다른 하나에는 viewPath 와 Member 객체 (Map<viewpath,Member객체>
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
