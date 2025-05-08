package com.moderation.domain.service.impl;

import com.moderation.api.model.ModerationInput;
import com.moderation.api.model.ModerationOutput;
import com.moderation.domain.service.ModerationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModerationServiceImp implements ModerationService {

  private static final List<String> commentsNotAllowed = List.of("ódio", "xingamento");

  @Override
  public ModerationOutput approvedComment(ModerationInput input) {
    Boolean result = approvedComment(input.getText());
    return ModerationOutput.builder()
            .approved(result)
            .reason(result.equals(true) ? null : "Banned words found")
            .build();
  }

  private static Boolean approvedComment(String text) {
    for (String val : commentsNotAllowed) {
      if (text.toLowerCase().contains(val.toLowerCase())) {
        return false;
      }
    }
    return true;
  }


}
