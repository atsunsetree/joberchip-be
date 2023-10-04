package kr.joberchip.server.v1.share.block.controller.dto;

import kr.joberchip.core.share.block.TemplateBlock;
import kr.joberchip.server.v1.share.page.dto.response.BlockType;

import java.util.UUID;

public record TemplateBlockResponse(UUID objectId,
                                    BlockType type,
                                    String title,
                                    String description,
                                    String previewURL,
                                    String iconUrl,
                                    Integer x,
                                    Integer y,
                                    Integer width,
                                    Integer height) {

  public static TemplateBlockResponse fromEntity(TemplateBlock templateBlock,
                                         String previewURL,
                                         String iconUrl) {

    previewURL = "static/newbie_profile_form.png";
    iconUrl = "static/template_icon_1.png";

    return new TemplateBlockResponse(
            templateBlock.getTemplateBlockId(),
            BlockType.TEMPLATE,
            templateBlock.getTitle(),
            templateBlock.getDescription(),
            previewURL,
            iconUrl,
            templateBlock.getX(),
            templateBlock.getY(),
            templateBlock.getWidth(),
            templateBlock.getHeight()
    );
  }
}
