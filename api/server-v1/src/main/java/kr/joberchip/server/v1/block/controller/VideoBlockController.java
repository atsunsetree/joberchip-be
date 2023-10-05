package kr.joberchip.server.v1.block.controller;

import java.util.UUID;
import kr.joberchip.server.v1._utils.ApiResponse;
import kr.joberchip.server.v1.block.controller.dto.BlockResponseDTO;
import kr.joberchip.server.v1.block.controller.dto.VideoBlockDTO;
import kr.joberchip.server.v1.block.service.VideoBlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/page/{pageId}/videoBlock")
public class VideoBlockController {

  private final VideoBlockService videoBlockService;

  @PostMapping
  public ResponseEntity<ApiResponse.Result<BlockResponseDTO>> createVideoBlock(
      @PathVariable UUID pageId, VideoBlockDTO videoBlockDTO) {

    BlockResponseDTO responseDTO = videoBlockService.createVideoBlock(pageId, videoBlockDTO);

    return ResponseEntity.ok(ApiResponse.success(responseDTO));
  }

  @PutMapping("/{blockId}")
  public ResponseEntity<ApiResponse.Result<BlockResponseDTO>> modifyVideoBlock(
      @PathVariable UUID pageId,
      @PathVariable UUID blockId,
      VideoBlockDTO videoBlockRequestDTO) {

    BlockResponseDTO response =
        videoBlockService.modifyVideoBlock(pageId, blockId, videoBlockRequestDTO);

    return ResponseEntity.ok(ApiResponse.success(response));
  }

  @DeleteMapping("/{blockId}")
  public ApiResponse.Result<Object> deleteVideoBlock(
      @PathVariable UUID pageId, @PathVariable UUID blockId) {

    videoBlockService.deleteVideoBlock(pageId, blockId);

    return ApiResponse.success();
  }
}
