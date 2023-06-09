package com.memepatentoffice.mpoffice.domain.meme.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SearchResponse {
    String title;
    int rank;

    int count;

    public void setRank(int rank) {
        this.rank = rank;
    }
}
