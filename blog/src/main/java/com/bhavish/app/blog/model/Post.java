package com.bhavish.app.blog.model;

import io.swagger.annotations.ApiModel;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@ApiModel(value = "Posts")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Post {

  Long id;
  String title;
  String content;
  OffsetDateTime publishDateTime;

}
