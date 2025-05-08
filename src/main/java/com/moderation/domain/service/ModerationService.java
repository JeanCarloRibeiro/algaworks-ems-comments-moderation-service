package com.moderation.domain.service;

import com.moderation.api.model.ModerationInput;
import com.moderation.api.model.ModerationOutput;

public interface ModerationService {
  ModerationOutput approvedComment(ModerationInput input);
}
