package com.cnu.motion.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Board")
public class Board{
    @Id
    Long id;

    @OneToMany
    List<Attachment> attachments;

    LocalDate registerDate;

    @ManyToOne
    User registrant;

    String title;

    String contents;
}
