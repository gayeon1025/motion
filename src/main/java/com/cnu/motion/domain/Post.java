package com.cnu.motion.domain;

import java.time.LocalDate;
import java.util.List;

public class Post {
    long id;

    List<Attachment> attachments;

    LocalDate registerDate;

    User registrant;
}
