package me.lozm.domain.board.vo;

import lombok.Getter;
import me.lozm.global.code.BoardType;
import me.lozm.global.code.ContentType;
import me.lozm.global.code.UseYn;
import me.lozm.global.common.HierarchicalEntity;

import java.time.LocalDateTime;

public class BoardVo {

    @Getter
    public static class ListInfo {
        private Long boardId;
        private HierarchicalEntity hierarchicalBoard;
        private BoardType boardType;
        private ContentType boardContentType;
        private Long boardViewCount;
        private String boardTitle;
        private String boardContent;
        private UseYn boardUse;
        private LocalDateTime boardCreatedDateTime;
        private Long userId;
        private String userIdentifier;

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public void setUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
        }
    }

}