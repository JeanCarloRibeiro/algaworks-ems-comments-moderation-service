package com.moderation.api.controller;

import com.moderation.api.model.ModerationInput;
import com.moderation.api.model.ModerationOutput;
import com.moderation.domain.service.ModerationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/moderate")
@Slf4j
@RequiredArgsConstructor
public class ModerationController {

  private final ModerationService service;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public ModerationOutput approveComment(@RequestBody ModerationInput input) {
    log.info("Received Comment {}", input);
    return service.approvedComment(input);
  }

}
