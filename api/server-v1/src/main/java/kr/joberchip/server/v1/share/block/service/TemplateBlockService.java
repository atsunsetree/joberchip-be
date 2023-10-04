package kr.joberchip.server.v1.share.block.service;

import kr.joberchip.core.share.block.TemplateBlock;
import kr.joberchip.core.share.page.SharePage;
import kr.joberchip.server.v1.share.block.controller.dto.TemplateBlockDTO;
import kr.joberchip.server.v1.share.block.repository.TemplateBlockRepository;
import kr.joberchip.server.v1.share.page.repository.SharePageRepository;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static kr.joberchip.server.v1._errors.ErrorMessage.BLOCK_NOT_FOUND;
import static kr.joberchip.server.v1._errors.ErrorMessage.ENTITY_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateBlockService {

    private final SharePageRepository sharePageRepository;
    private final TemplateBlockRepository templateBlockRepository;

    public TemplateBlock createTemplateBlock(UUID pageId, TemplateBlockDTO templateBlockDTO) {
        SharePage sharePage = sharePageRepository.findById(pageId)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND));

        TemplateBlock templateBlock = templateBlockDTO.toEntity();
        templateBlockRepository.save(templateBlock);
        sharePage.addTemplateBlock(templateBlock);

        return templateBlock;
    }

    public void deleteTemplateBlock(UUID blockId) {
        TemplateBlock templateBlock = templateBlockRepository.findById(blockId)
                .orElseThrow(() -> new EntityNotFoundException(BLOCK_NOT_FOUND));

        templateBlockRepository.deleteById(blockId);
    }
}
