package com.memepatentoffice.mpoffice.domain.user.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class AlarmCheckResponse {
    private Boolean isExist;
}
