package flyai.autotoon.toonidot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum Success {

    //200 OK
    SAVE_INFO_SUCCESS(HttpStatus.OK, "카툰 정보가 성공적으로 저장되었습니다."),
    SAVE_STORY_SUCCESS(HttpStatus.OK, "당신의 이야기가 성공적으로 저장되었습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
