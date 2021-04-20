package com.erikaffekann.qualityoflife.util;

import java.util.UUID;

public class PlayerQuery {
    public UUID playerUUID;
    public boolean query;

    public PlayerQuery(UUID playerUUID, boolean query) {
        this.playerUUID = playerUUID;
        this.query = query;
    }
}
