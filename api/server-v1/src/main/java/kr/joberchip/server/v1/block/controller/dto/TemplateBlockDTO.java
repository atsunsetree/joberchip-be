package kr.joberchip.server.v1.block.controller.dto;

import kr.joberchip.core.share.block.TemplateBlock;
import org.springframework.web.bind.annotation.RequestParam;

public record TemplateBlockDTO(@RequestParam String title,
                               @RequestParam String description,
                               @RequestParam Integer x,
                               @RequestParam Integer y,
                               @RequestParam Integer w,
                               @RequestParam Integer h) {
    public TemplateBlock toEntity() {
        return TemplateBlock.of(title, description, x, y, w, h);
    }
}