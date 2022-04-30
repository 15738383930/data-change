package com.example.datachange.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GirlfriendExt extends Girlfriend {

    private String typeText;
}
