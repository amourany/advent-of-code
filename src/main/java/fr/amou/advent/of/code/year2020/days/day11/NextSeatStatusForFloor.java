package fr.amou.advent.of.code.year2020.days.day11;

import java.util.Map;
import java.util.Map.Entry;

public class NextSeatStatusForFloor implements NextSeatStatus {

    @Override
    public Entry<String, Seat> apply(Entry<String, Seat> currentSeat, Map<String, Seat> seatOccupation) {
        return currentSeat;
    }
}
