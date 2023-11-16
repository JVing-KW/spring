package org.zerock.springex2.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CheckboxFormatter implements Formatter<Boolean> {
    @Override
    public Boolean parse(String text, Locale locale) throws ParseException {
        if(text == null ) {

            //구글 설정 → 고급 → 언어'로 들어가서 원하는 언어의 우선 순위를 지정하면 된다.
            // 그러면 해당하는 언어에 맞는 메시지 파일이 매칭된다.
            return false;
        }
        return text.equals("on");
        //- resolverLocale() 메서드는 요청과 관련된 Locale을 리턴한다.
        // DispatcherServlet은 등록되어 있는 LocaleResolver의 resolverLocale()
        // 메서드를 호출해서 웹 요청을 처리할 때 사용할 Locale을 구한다.
        //- setLocale() 메서드는 Locale을 변경할 때 사용된다.
        // 예를 들어 쿠키나 세션에 Locale 정보를 저장할 때 이 메서드가 사용된다.
    }

    @Override
    public String print(Boolean object, Locale locale) {
        return object.toString();
    }
}