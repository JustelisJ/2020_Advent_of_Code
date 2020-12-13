package com.adventofcode.day13;

import java.util.List;

public class ShuttleSearch {

    public static int earliestBusIDMultipliedByWaitingMinutes(int arrival, List<Integer> busses){
        int busIDToWaitTheLeast = busses.get(0);
        int soonestArrival = (arrival / busses.get(0)) * busses.get(0) + busses.get(0);
        for(Integer bus : busses){
            if(soonestArrival > (arrival / bus) * bus + bus){
                busIDToWaitTheLeast = bus;
                soonestArrival = (arrival / bus) * bus + bus;
            }
        }

        return (soonestArrival - arrival) * busIDToWaitTheLeast;
    }

}
