package kr.joberchip.server.v1.block.controller;

import java.util.UUID;

import kr.joberchip.server.v1._utils.ApiResponse;
import kr.joberchip.server.v1.block.controller.dto.BlockResponseDTO;
import kr.joberchip.server.v1.block.controller.dto.TemplateBlockDTO;
import kr.joberchip.server.v1.block.controller.dto.TemplateBlockResponse;
import kr.joberchip.server.v1.block.service.TemplateBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/page/{pageId}/templateBlock")
public class TemplateBlockController {
  private final TemplateBlockService templateBlockService;

  @PostMapping
  public ResponseEntity<ApiResponse.Result<TemplateBlockResponse>> createTemplateBlock(
          @PathVariable UUID pageId, @RequestBody TemplateBlockDTO templateBlockDTO) {

    BlockResponseDTO response = templateBlockService.createTemplateBlock(pageId, templateBlockDTO);
    String preview = "static/newbie_profile_form.png";
    String icon = "static/template_icon_1.png";
    TemplateBlockResponse templateBlockResponse = new TemplateBlockResponse(response, preview, icon);

    return ResponseEntity.ok(ApiResponse.success(templateBlockResponse));
  }

  @DeleteMapping("/{blockId}")
  public ApiResponse.Result<Object> deleteLinkBlock(@PathVariable UUID blockId,
                                                    @PathVariable UUID pageId) {

    templateBlockService.deleteTemplateBlock(blockId);
    return ApiResponse.success();
  }
}
