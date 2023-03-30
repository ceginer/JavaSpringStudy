package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    // MemberSaveController 에 사용될 paramName 과 param (Map<paramName,param>)
    // 나머지 필요한 viewPath 와 Member 객체는 FrontController 에서 다루게 됨
    ModelView process(Map<String, String> paramMap);
}
