package com.lawProject.SSL.domain.chatroom.model;

import com.lawProject.SSL.domain.chatmessage.model.ChatMessage;
import com.lawProject.SSL.domain.user.model.User;
import com.lawProject.SSL.global.common.dao.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoom extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    private String name;

    private String roomId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "chatRoom", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ChatMessage> messageList = new ArrayList<>();

    @Builder
    public ChatRoom(String roomId, User user) {
        this.roomId = roomId;
        this.user = user;
    }

    /* 연관관계 메서드 */
    public void addMessage(ChatMessage chatMessage) {
        messageList.add(chatMessage);
    }

    public void addMessages(List<ChatMessage> chatMessages) {
        messageList.addAll(chatMessages);
    }
}
