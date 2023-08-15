package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.InfoSaveRequestDto;
import flyai.autotoon.toonidot.dto.InfoSaveResponseDto;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.entity.User;
import flyai.autotoon.toonidot.repository.InfoRepository;
import flyai.autotoon.toonidot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InfoService {

    private final UserRepository userRepository;
    private final InfoRepository infoRepository;

    @Transactional
    public InfoSaveResponseDto saveInfo(Long userId, InfoSaveRequestDto infoSaveRequestDto){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 존재하지 않습니다. user_id = "+userId));
        Info newinfo = infoRepository.save(infoSaveRequestDto.toEntity(user));
        return InfoSaveResponseDto.builder()
                .infoId(newinfo.getInfoId())
                .userId(newinfo.getUser().getUserId())
                .toonName(newinfo.getToonName())
                .build();
    }
}
