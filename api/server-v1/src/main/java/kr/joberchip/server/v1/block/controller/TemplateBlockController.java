package kr.joberchip.server.v1.block.controller;

import java.util.UUID;
import kr.joberchip.server.v1._utils.ApiResponse;
import kr.joberchip.server.v1.block.controller.dto.TemplateBlockDTO;
import kr.joberchip.server.v1.block.service.TemplateBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/page")
public class TemplateBlockController {
  private final TemplateBlockService templateBlockService;

  @PostMapping("/{pageId}/templateBlock")
  public ApiResponse.Result<Object> createTemplateBlock(
          @PathVariable UUID pageId, @RequestBody TemplateBlockDTO templateBlockDTO) {

    templateBlockService.createTemplateBlock(pageId, templateBlockDTO);

    return ApiResponse.success();
  }

  @PutMapping("/{blockId}")
  public ApiResponse.Result<Object> modifyLinkBlock(
      @PathVariable UUID pageId,
      @PathVariable Long blockId,
      @RequestBody TemplateBlockDTO templateBlockDTO) {

    return ApiResponse.success();
  }

  @DeleteMapping("/{blockId}")
  public ApiResponse.Result<Object> deleteLinkBlock(
      @PathVariable UUID pageId, @PathVariable UUID blockId) {

    templateBlockService.deleteTemplateBlock(pageId, blockId);
    return ApiResponse.success();
  }
}
