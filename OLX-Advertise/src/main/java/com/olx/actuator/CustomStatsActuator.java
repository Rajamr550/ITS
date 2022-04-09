package com.olx.actuator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

/*Assignment: Write a custom actuator in OLX-Advertises named '/advstats' which gives us overall statistics of advertises into database. This actuator should render below information:
1 - Total no of advertises in database
2 - No of OPEN advertises.
3 - No of advertises posted within last month.
Note: since we have not learnt database connectivity, pls generate the values as random numbers.*/

@Component
@Endpoint(id = "adv-stats")
public class CustomStatsActuator {
    private Map<String, Integer> advStatsMap = new HashMap<>();

    @PostConstruct
    public void init() {
	Random random = new Random();
	advStatsMap.put("total no of adv", random.nextInt(100));
	advStatsMap.put("no of open adv", random.nextInt(100));
	advStatsMap.put("no of adv posted last month ", random.nextInt(100));

    }

    @ReadOperation
    public Map<String, Integer> getAllBugFixes() {
	return this.advStatsMap;
    }

}
