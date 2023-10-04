package kr.joberchip.server.v1.block.controller.dto;

import kr.joberchip.core.share.block.TemplateBlock;

public record TemplateBlockDTO(String title,
                               String description,
                               Integer x,
                               Integer y,
                               Integer width,
                               Integer height) {
    public TemplateBlock toEntity() {
        return TemplateBlock.of(title, description);
    }
}
