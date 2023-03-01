package org.example.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Participant {
    public double tab;
    public final String name;

    public void setTab(double userShareOfItem) {
        tab += userShareOfItem;
    }

}
