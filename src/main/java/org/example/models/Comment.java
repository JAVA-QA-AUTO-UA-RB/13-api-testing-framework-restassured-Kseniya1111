package org.example.models;

import lombok.Data;
import java.io.Serializable;

@Data
public class Comment implements Serializable {
    private int id;
    private int postId;
    private String name;
    private String email;
    private String body;
}
