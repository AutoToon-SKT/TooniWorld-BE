package flyai.autotoon.toonidot.service;

import flyai.autotoon.toonidot.dto.InfoSaveRequestDto;
import flyai.autotoon.toonidot.dto.InfoSaveResponseDto;
import flyai.autotoon.toonidot.entity.Info;
import flyai.autotoon.toonidot.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InfoService {
    private final InfoRepository infoRepository;

    @Transactional
    public InfoSaveResponseDto saveInfo(InfoSaveRequestDto infoSaveRequestDto){
        Info newinfo = infoRepository.save(infoSaveRequestDto.toEntity());
        return InfoSaveResponseDto.builder()
                .infoId(newinfo.getInfoId())
                .toonName(newinfo.getToonName())
                .build();
    }
}
