package kr.joberchip.server.v1.block.service;

import kr.joberchip.core.block.TemplateBlock;
import kr.joberchip.core.page.SharePage;
import kr.joberchip.server.v1.block.controller.dto.BlockResponseDTO;
import kr.joberchip.server.v1.block.controller.dto.TemplateBlockDTO;
import kr.joberchip.server.v1.block.repository.TemplateBlockRepository;
import kr.joberchip.server.v1.page.repository.SharePageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

import static kr.joberchip.server.v1._errors.ErrorMessage.BLOCK_NOT_FOUND;
import static kr.joberchip.server.v1._errors.ErrorMessage.ENTITY_NOT_FOUND;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateBlockService {

    private final SharePageRepository sharePageRepository;
    private final TemplateBlockRepository templateBlockRepository;

    public BlockResponseDTO createTemplateBlock(UUID pageId, TemplateBlockDTO templateBlockDTO) {
        SharePage sharePage = sharePageRepository.findById(pageId)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND));

        TemplateBlock templateBlock = templateBlockDTO.toEntity();
        templateBlockRepository.save(templateBlock);
        sharePage.addTemplateBlock(templateBlock);

        return BlockResponseDTO.fromEntity(templateBlock);
    }

    public void deleteTemplateBlock(UUID blockId) {
        TemplateBlock templateBlock = templateBlockRepository.findById(blockId)
                .orElseThrow(() -> new EntityNotFoundException(BLOCK_NOT_FOUND));

        templateBlockRepository.deleteById(blockId);
    }
}
