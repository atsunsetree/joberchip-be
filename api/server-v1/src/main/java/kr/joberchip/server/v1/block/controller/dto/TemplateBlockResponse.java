package kr.joberchip.server.v1.block.controller.dto;

import lombok.Getter;

@Getter
public class TemplateBlockResponse {
    private BlockResponseDTO blockResponseDTO;
    private String preview;
    private String icon;

    public TemplateBlockResponse(BlockResponseDTO blockResponseDTO, String preview, String icon) {
        this.blockResponseDTO = blockResponseDTO;
        this.preview = preview;
        this.icon = icon;
    }
}
