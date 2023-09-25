package kr.joberchip.core.space.block;

import javax.persistence.*;

import kr.joberchip.core.storage.ImageBlockFile;
import kr.joberchip.core.space.BaseObject;
import lombok.*;

@Entity
@Table(name = "image_block_tb")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageBlock extends BaseObject {

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @OneToOne(mappedBy = "imageBlock")
  private ImageBlockFile imageBlockFile;
}
