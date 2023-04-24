package com.example.dummy.schema;

import java.io.Serializable;

public record Dummy(int id, String name) implements Serializable {

    private static final long serialVersionUID = 1L;
    
}
