package com.bhavish.app.blog.model;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Comments")
public class Comments {

  Long id;
  String content;
}
